//Беляева Елена
//Задан текстовый файл. Определить количество вхождений заданного слова в тексте.

#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>

using namespace std;

const int size = 256;

struct Hash
{
    string key;
    int count;
    Hash *next;
};

Hash *hashT [size];

void create()
{
    for (int i = 0; i < size; i++)
        hashT[i] = NULL;
}

void deleteHashTable()
{
    for (int i = 0; i < size; i++)
    delete hashT[i];
}

int fromStringToInt(string slovo)
{
    int word = 0;
    for (int i = 0; i < slovo.length(); ++i)
        if (!(ispunct(slovo[i]))) word += slovo[i] + 'a';
    return word;
}

unsigned int hashFunc(string slovo)
{
    float A = 0.618033;
    int key = fromStringToInt(slovo);
    int hashCode = size * fmod(key, A);
    return hashCode;
}

void add(string word) 
{
    int hashNumber = hashFunc(word);
    Hash *pCrawl = hashT[hashNumber];
    Hash *prev = NULL;
    if (pCrawl == NULL)
    {
        Hash *w = new Hash;
        w -> key = word;
        w -> count = 1;
        w -> next = NULL;
        hashT[hashNumber] = w;
        return;
    }
    while (pCrawl != NULL)
    {
        if (pCrawl -> key == word)
        {
            (pCrawl -> count) ++;
            return;
        }
        prev = pCrawl;
        pCrawl = pCrawl->next;
    }
    Hash *w = new Hash;
    w -> key = word;
    w -> count ++;
    w -> next = NULL;
    prev->next = w;
}

int main ()
{
    string wordFromFile, yourWord;
    int hashN;
    bool flag = true;
    cout<<"Введите слово: "; cin>>yourWord;
    if (isupper(yourWord[0])) yourWord[0] = tolower(yourWord[0]);
    ifstream myFile ("f.txt");
    if (myFile.is_open())
    {
        while (!myFile.eof())
        {
            myFile>>wordFromFile;
            if (isupper(wordFromFile[0])) wordFromFile[0] = tolower(wordFromFile[0]);
            if (ispunct(wordFromFile.back())) wordFromFile.pop_back();
            add(wordFromFile);
        }
        Hash *p = hashT[hashFunc(yourWord)];
        while (p != NULL)
        {
            if (p -> key == yourWord)
            {
                cout<<"Слово "<<yourWord<<" появляется "<<p -> count<<" раз(a)."<<endl;
                flag = false;
            }
            p = p -> next;
        }
        if (flag) cout<<"Этого слова нет"<<endl;
        myFile.close();
    }
    else cout << "Файл не открывается";
    deleteHashTable();
    
    return 0;
}