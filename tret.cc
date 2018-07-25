//Беляева Елена, 61 группа
//Проверить, входит ли атом в список

#include <iostream>
#include <queue>

using namespace std;

int member (char *A, queue <char> &L, int n)
{
    int check = 0;
    while (check == 0 && !L.empty())
    {
        for (int i = 0; i < n; i++)
        {
            if (A[i] == L.front())
            {
                L.pop();
                check = 1;
            }
            else 
            {
                L.pop();
                check = 0;
                i = n;
            }
        }
        if (L.front() == (',' || ')') && check == 1)
            while (!L.empty()) L.pop();
    }
    return check;
}

int main()
{
    char c;
    int n, f;
    queue<char>L;
    cout<<"Введите список: ";
    do
    {
        cin>>c;
        L.push(c);
    }
    while (c != '.');
    
    cout<<"n = "; cin>>n;
    char *A = new char[n];
    cout<<"atom: ";
    for (int i = 0; i < n; i++)
    {
        cin>>A[i];
    }
    
    f = member (A, L, n);
    if (f == 1) cout<<"yes"; else cout<<"no"<<endl;
    
    return 0;
}