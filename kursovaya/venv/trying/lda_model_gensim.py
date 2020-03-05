from gensim import corpora, models
from gensim.models import CoherenceModel
import pprint, json

f = open('ready_data.txt', 'r', encoding='utf-8')
input = [line.strip() for line in f]
dataset = [l.split() for l in input]

#Create dictionary
id2word = corpora.Dictionary(dataset)

#Create corpus
texts = dataset

#Term-document frequency
corpus = [id2word.doc2bow(text) for text in texts]

model = models.ldamodel.LdaModel(
    corpus=corpus,
    id2word=id2word,
    num_topics=20,
    random_state=100,
    update_every=1,
    chunksize=100,
    passes=10,
    alpha='auto',
    per_word_topics=True
)

with open('topics.json', 'w') as write_file:
    json.dump(model.print_topics(), write_file)

# Compute Perplexity
print('\nPerplexity: ', model.log_perplexity(corpus))

pprint.pprint(model.print_topics())

f.close()
