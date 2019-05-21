#!/usr/bin/env python
# -*- coding: utf-8 -*-
import matplotlib.pyplot as plt
import codecs
import os
import numpy as np
import nltk
from nltk import SnowballStemmer
from pymystem3 import Mystem

stop_words = nltk.corpus.stopwords.words('russian')
mystem = Mystem()
stemmer = SnowballStemmer('russian')
path = 'Initial_texts'
f = open('vowpal_wabbit_news.txt', 'w')
x = []
y = []
s = []
for i in range(1, len(os.listdir(path)) + 1):  # перебор файлов с документами по номерам i
    filename = path + '/' + str(i) + ".txt"
    text = " "
    with codecs.open(filename, encoding='UTF-8') as file_object:  # сбор текста из файла i-го документа
        for line in file_object:
            if len(line) != 0:
                text = text + " " + line
    word = nltk.word_tokenize(text)  # токинезация текста i-го документа
    word_ws = [w.lower() for w in word if w.isalpha()]  # исключение слов и символов
    word_w = [w for w in word_ws if w not in stop_words]  # нижний регистр
    lem = mystem.lemmatize(" ".join(word_w))  # лемматизация i -го документа
    lema = [w for w in lem if w.isalpha() and len(w) > 1]
    freq = nltk.FreqDist(lema)  # распределение слов в i -м документе по частоте
    z = []  # обновление списка для нового документа
    z = [(key + ":" + str(val)) for key, val in freq.items() if val > 1]  # частота упоминания через : от слова
    f.write("|text" + " " + " ".join(z) + '\n')  # запись в мешок слов с меткой |text
    c = []
    d = []
    for key, val in freq.items():  # подготовка к сортировке слов по убыванию частоты в i -м документе
        if val > 1:
            c.append(val)
            d.append(key)
    a = []
    b = []
    for k in np.arange(0, len(c), 1):  # сортировка слов по убыванию частоты в i -м документе
        ind = c.index(max(c))
        a.append(c[ind])
        b.append(d[ind])
        del c[ind]
        del d[ind]
    x.append(i)  # список номеров документов
    y.append(len(a))  # список количества слов в документах
    a = a[0:10]
    b = b[0:10]  # TOP-10 для частот a  и слов b в i -м документе
    y_pos = np.arange(1, len(a) + 1, 1)  # построение TOP-10 диаграмм
    performance = a
    plt.barh(y_pos, a)
    plt.yticks(y_pos, b)
    plt.xlabel(u'Количество слов')
    plt.title(u'Частоты слов в документе № %i' % i, size=12)
    plt.grid(True)
    plt.show()
plt.title(u'Количество слов в документах', size=12)
plt.xlabel(u'Номера документов', size=12)
plt.ylabel(u'Количество слов', size=12)
plt.bar(x, y, 1)
plt.grid(True)
plt.show()
f.close()
