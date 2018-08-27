/*Выполнила Беляева Елена, 61 группа, 2 курс*/

/*Описать тип данных,
соответствующий представлению многочленов anx^n + a(n-1)x^(n-1) +...a0
в виде списка, причем если аi = 0,
то соответствующее звено не включается в список,
и определить функцию, вычисляющую значение
многочлена р в целочисленной точке х*/

#include <iostream>

using namespace std;

struct node
{
    int num, deg;
    node * next;
};
  
void calc (int res, int x)
{
  node *head = NULL;
  int num, deg, t = 1;
  
  cout<<"Введите коэффициент и степень через пробел: ";
  cin>>num>>deg;
  
  if (num == 0)
  {
    cout<<"Значение многочлена = "<<res;
    return;
  }
  
  node * temp = new node;
  temp -> num = num;
  temp -> deg = deg;
  temp -> next = head;
  
  for (int i = 0; i < deg; i++)
    t *= x;
  
  res += t*num;
  
  calc (res, x);
}

int main ()
{
  int x;
  cout<<"Введите x: "<<endl; cin>>x;
  calc(0, x);
    
  return 0;
}
