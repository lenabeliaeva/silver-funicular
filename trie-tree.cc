#include <iostream>
#include <string>
#include <queue>

using namespace std;
 
const int ALPHABET_SIZE = 26;

struct TrieNode
{
    struct TrieNode *children[ALPHABET_SIZE];
    bool isEndOfWord;
};

struct TrieNode *getNode(void)
{
    struct TrieNode *pNode =  new TrieNode;
 
    pNode->isEndOfWord = false;
 
    for (int i = 0; i < ALPHABET_SIZE; i++)
        pNode->children[i] = NULL;
 
    return pNode;
}

bool isEmpty (struct TrieNode *root)
{
    return root == NULL;
}

void insert(struct TrieNode *root, string key)
{
    struct TrieNode *pCrawl = root;
 
    for (unsigned int i = 0; i < key.length(); i++)
    {
        int index = key[i] - 'a';
        if (!pCrawl->children[index])
            pCrawl->children[index] = getNode();
 
        pCrawl = pCrawl->children[index];
    }
    
    pCrawl->isEndOfWord = true;
}

void print(struct TrieNode *root, string slovo)
{
    if (root == NULL) return;
    if (root -> isEndOfWord == true)
    {
        cout<<slovo<<endl;
        for (int i = 0; i < ALPHABET_SIZE; ++i)
            if (root -> children[i] != NULL) print(root -> children[i], slovo + char(i + 'a'));
    }
    else
        for (int i = 0; i < ALPHABET_SIZE; ++i)
            if (root -> children[i] != NULL) print(root -> children[i], slovo + char(i + 'a'));
}

bool isPalindrome(int i, int j, string slovo)
{
    while (i <= j)
    {
        if (slovo[i] != slovo[j]) return false;
        ++i; --j;
    }
    return true;
}

void findPalindrome(struct TrieNode *root, string slovo, queue <string> &palindromes)
{
    if (root -> isEndOfWord == true)
    {
        if (isPalindrome (0, slovo.length() - 1, slovo)) print(root, slovo);
        for (int i = 0; i < ALPHABET_SIZE; i++)
        {
            if (root->children[i] != NULL) findPalindrome(root -> children[i], slovo + char(i + 'a'), palindromes);
        }
    }
    else 
    {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root -> children[i] != NULL) findPalindrome(root -> children[i], slovo + char(i + 'a'), palindromes);
    }
}

int main()
{
    struct TrieNode *root = getNode();
    queue <string> palindromes;
    string word, slovo = "";
    bool check = true;
    
    while (check)
    {
        cout << "Введите слово" << endl;
        cin >> word;
        insert (root, word);
        cout << "Хотите добавить в дерево ещё слово? (1-да/0-нет)" << endl;
        cin >> check;
    }
    cout<<"Вы хотите увидеть дерево? (1-да/0-нет)"<<endl; cin>>check;
    if (check)
    {
        if (isEmpty(root)) cout<<"Дерево пустое"<<endl;
        else print(root, "");
    }
    
    cout<<endl<<"Слова - палиндромы:"<<endl;
    findPalindrome(root, slovo, palindromes);
    while (!palindromes.empty())
    {
        cout<<palindromes.front()<<endl;
        palindromes.pop();
    }
    return 0;
}