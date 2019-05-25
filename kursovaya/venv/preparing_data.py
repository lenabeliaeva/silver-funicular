#!/usr/bin/env python
# -*- coding: utf-8 -*-
import codecs
import os
import nltk
import json
from nltk import SnowballStemmer
from pymystem3 import Mystem

stop_words = nltk.corpus.stopwords.words('russian')
mystem = Mystem()
stemmer = SnowballStemmer('russian')

with open("texts_713664710.json", "r") as input:
    data = json.load(input)


output = open('ready_data.txt', 'a')

for line in data:
    if len(line) != 0:
        word = nltk.word_tokenize(line)  # токенизация текста документа
        word_ws = [w.lower() for w in word if w.isalpha()]  # исключение слов и символов
        word_w = [w for w in word_ws if w not in stop_words]  # исключение стоп-слов
        word_wh = [w for w in word_w if not w.startswith("http")]  #исключение http и https
        lem = mystem.lemmatize(" ".join(word_wh))  # лемматизация документа
        lema = [w for w in lem if w.isalpha() and len(w) > 1]  # запись в выходной файл
        freq = nltk.FreqDist(lema)  # распределение слов в i -м документе по частоте
        z = []  # обновление списка для нового документа
        z = [(key + ":" + str(val)) for key, val in freq.items() if val > 1]  # частота упоминания через : от слова
        if len(z) > 0:
            output.write("|text" + " " + " ".join(z).encode('utf-8') + '\n')

output.close()
