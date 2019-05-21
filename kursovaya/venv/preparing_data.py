#!/usr/bin/env python
# -*- coding: utf-8 -*-
import matplotlib.pyplot as plt
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

output = open('ready_data.txt', 'a', encoding='UTF-8')

for line in data:
    if len(line) != 0:
        word = nltk.word_tokenize(line)  # токинезация текста документа
        word_ws = [w.lower() for w in word if w.isalpha()]  # исключение слов и символов
        word_w = [w for w in word_ws if w not in stop_words]  # исключение стоп-слов
        word_wh = [w for w in word_w if not w.startswith("http")]  #исключение http и https
        lem = mystem.lemmatize(" ".join(word_wh))  # лемматизация документа
        lema = [w for w in lem if w.isalpha() and len(w) > 1]  # запись в выходной файл
        output.write(" ".join(lema) + '\n')

output.close()