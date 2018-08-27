/*Описать функцию, которая присваивает парметру Е
элемент из самого левого листа непустого дерева Т
*/
//Беляева Елена

#include <iostream>

using namespace std;

struct tree
{
    int key;
    tree *left, *right;
};

void push (int key, tree *&root)
{
    if (root == NULL)
    {
        root = new tree;//выделяем память под звено дерева
        root -> key = key;//записываем данные в звено
        root -> left = root -> right = NULL;//подзвенья иниц-ем пустотой
    }
    if (key < root-> key)//уходим влево
    {
        if (root -> left != NULL) push (key, root -> left);
        else
        {
            root -> left = new tree;//выделяем память левому подзвену
            root -> left -> left = root -> left -> right = NULL;//инициализируем его подзвенья
            root -> left -> key = key;//записываем в левое подзвено
        }
    }
    if (key > root -> key)
    {
        if (root -> right != NULL) push (key, root -> right);
        else
        {
            root -> right = new tree;
            root -> right -> left = root -> right -> right = NULL;
            root -> right -> key = key;
        }
    }
}

void findleft (tree *root, int &e)
{
    tree *find = root;
    tree *cur = root;
    while (cur != NULL)
    {
        find = cur;
        if (cur -> left != NULL)
            cur = cur -> left;
        else if (cur -> right != NULL)
            cur = cur -> right;
        else cur = NULL;
    }
    e = find -> key;
}

int main()
{
    tree *root = NULL;
    
    int n,x,e;
    
    cout<<"Введите количество элементов: "<<endl; cin>>n;
    cout<<"Вводите числа: "<<endl;
    for (int i = 0; i < n; i++)
    {
        cin>>x;
        push (x, root);
    }
    
    cout<<"Введите Е: "; cin>>e;
    findleft(root, e);
    cout<<"E = "<<e;

    return 0;
}