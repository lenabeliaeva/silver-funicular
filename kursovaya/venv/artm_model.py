#!/usr/bin/env python
# -*- coding: utf-8 -*-
import glob
import os
import matplotlib.pyplot as plt
import json

import artm


def print_measures(model_artm):
    print 'Sparsity Phi: {0:.3f}'.format(model_artm.score_tracker['SparsityPhiScore'].last_value)

    print 'Sparsity Theta: {0:.3f}'.format(model_artm.score_tracker['SparsityThetaScore'].last_value)

    print 'Perplexity: {0:.3f}'.format(model_artm.score_tracker['PerplexityScore'].last_value)

    plt.plot(xrange(model_artm.num_phi_updates), model_artm.score_tracker['PerplexityScore'].value, 'r--', linewidth=2)
    plt.xlabel('Iterations count')
    plt.ylabel('ARTM perp.')
    plt.grid(True)
    plt.show()


def print_topics(model_artm):
    for topic_name in model_artm.topic_names:
        print topic_name + ': ',
        print ' '.join(model_artm.score_tracker['TopTokensScore'].last_tokens[topic_name])


def dump_to_json(model_artm):
    with open('topics.json', 'w')as write_file:
        for topic_name in model_artm.topic_names:
            line = topic_name + ': '.join(model_artm.score_tracker['TopTokensScore'].last_tokens[topic_name])
            json.dump(line, write_file)


batch_vectorizer = None
if len(glob.glob(os.path.join('vk_batches', '*.batch'))) < 1:
    batch_vectorizer = artm.BatchVectorizer(data_path='', data_format='vowpal_wabbit', target_folder='vk_batches')
else:
    batch_vectorizer = artm.BatchVectorizer(data_path='vk_batches', data_format='batches')

dictionary = artm.Dictionary()

model_artm = artm.ARTM(topic_names=['topic_{}'.format(i) for i in xrange(8)],
                       scores=[artm.PerplexityScore(name='PerplexityScore',
                                                    use_unigram_document_model=False,
                                                    dictionary=dictionary)],
                       regularizers=[artm.SmoothSparseThetaRegularizer(name='SparseTheta', tau=-0.15)],
                       cache_theta=True)

if not os.path.isfile('vk_batches/dictionary.txt'):
    dictionary.gather(data_path=batch_vectorizer.data_path)
    dictionary.save_text(dictionary_path='vk_batches/dictionary.txt')
dictionary.load_text(dictionary_path='vk_batches/dictionary.txt')

model_artm.initialize(dictionary=dictionary)

model_artm.scores.add(artm.SparsityPhiScore(name='SparsityPhiScore'))
model_artm.scores.add(artm.SparsityThetaScore(name='SparsityThetaScore'))
model_artm.scores.add(artm.TopicKernelScore(name='TopicKernelScore', probability_mass_threshold=0.5))
model_artm.scores.add(artm.TopTokensScore(name='TopTokensScore', num_tokens=10))

model_artm.regularizers.add(artm.SmoothSparsePhiRegularizer(name='SparsePhi', tau=-0.001))
model_artm.regularizers.add(artm.DecorrelatorPhiRegularizer(name='DecorrelatorPhi', tau=1.5e+5))
model_artm.regularizers['SparseTheta'].tau = -2

model_artm.num_document_passes = 1

model_artm.fit_offline(batch_vectorizer=batch_vectorizer, num_collection_passes=10)

print_measures(model_artm)
print_topics(model_artm)
dump_to_json(model_artm)
