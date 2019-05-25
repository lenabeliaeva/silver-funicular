#!/usr/bin/env python
# -*- coding: utf-8 -*-
import artm

batch_vectorizer = artm.BatchVectorizer(data_path='vk_batches',
                                        data_format='batches')

lda = artm.LDA(num_topics=40, alpha=0.01, beta=0.001,
               num_document_passes=5, dictionary=batch_vectorizer.dictionary,
               cache_theta=True)

lda.fit_offline(batch_vectorizer=batch_vectorizer, num_collection_passes=20)

print lda.perplexity_value
print lda.sparsity_phi_last_value
print lda.sparsity_theta_last_value

top_tokens = lda.get_top_tokens(num_tokens=10)
for i, token_list in enumerate(top_tokens):
    print 'Topic #{0}: {1}'.format(i, token_list)

