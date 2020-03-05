#!/usr/bin/env python
# -*- coding: utf-8 -*-
import matplotlib.pyplot as plt
import codecs
import os
import nltk
import json
import numpy as np
from nltk import SnowballStemmer
from pymystem3 import Mystem

stop_words = nltk.corpus.stopwords.words('russian')
mystem = Mystem()
stemmer = SnowballStemmer('russian')

with open("texts_713664710.json", "r") as input:
    data = json.load(input)

output = open('ready_data.txt', 'a')
x = []
y = []
s = []
i = 0
for line in data:
    if len(line) != 0:
        i = i + 1
        word = nltk.word_tokenize(line)  # токенизация текста документа
        word_ws = [w.lower() for w in word if w.isalpha()]  # исключение слов и символов
        word_w = [w for w in word_ws if w not in stop_words]  # исключение стоп-слов
        word_wh = [w for w in word_w if not w.startswith("http")]  #исключение http и https
        lem = mystem.lemmatize(" ".join(word_wh))  # лемматизация документа
        lema = [w for w in lem if w.isalpha() and len(w) > 1]  # запись в выходной файл
        freq = nltk.FreqDist(lema)  # распределение слов в i -м документе по частоте
        # z = []  # обновление списка для нового документа
        # z = [(key + ":" + str(val)) for key, val in freq.items() if val > 1]  # частота упоминания через : от слова
        # if len(z) > 0:
        #     output.write("|text" + " " + " ".join(z).encode('utf-8') + '\n')
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

output.close()
