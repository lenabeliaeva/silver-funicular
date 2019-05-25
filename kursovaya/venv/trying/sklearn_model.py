import nltk
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.decomposition import LatentDirichletAllocation

def display_topics(model, feature_names, no_top_words):
    for topic_idx, topic in enumerate(model.components_):
        print("Topic %d:" % (topic_idx))
        print(" ".join([feature_names[i]
                        for i in topic.argsort()[:-no_top_words - 1:-1]]))

with open('ready_data.txt', 'r', encoding='UTF-8')as f:
    data = [line.strip() for line in f]

tf_vectorizer = CountVectorizer(stop_words='english')
tf = tf_vectorizer.fit_transform(data)
tf_feature_names = tf_vectorizer.get_feature_names()

lda = LatentDirichletAllocation(n_components=20,
                                max_iter=30,
                                n_jobs=5,
                                learning_method='batch',
                                verbose=1)
lda.fit(tf)

no_top_words = 20
display_topics(lda, tf_feature_names, no_top_words)
