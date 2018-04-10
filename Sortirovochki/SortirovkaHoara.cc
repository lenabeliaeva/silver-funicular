#include <iostream>
#include <string>

using namespace std;

/*void hoaresort (int *a, int first, int last, string p)
{
    if (first>=last) return;
    int i=first,j=last,t,x=a[rand()%(j-i)+i];
    if (p=="middle") x=a[(i+j)/2];
    while (i<=j)
    {
        while (a[i]<x) i++;
        while (a[j]>x) j--;
        if (i<=j)
        {
            t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
    }
    
    if (i>first) hoaresort(a,first,j,p);
    if (j<last) hoaresort(a,i,last,p);
}*/

int partition(int * a, int p, int r)
{
    int x = a[p];
    int i = p - 1, j = r + 1;
    while (true)
    {
        while (a[--j] > x);
        while (a[++i] < x);
        if (i < j)
        {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        else return j;
    }
}

int randomizedPartition(int * a, int p, int r)
{
    int i = rand()%r + p;
    int t = a[p];
    a[p] = a[i];
    a[i] = t;
    return partition(a, p, r);
}

void quickSort (int * a, int p, int r)
{
    if (p < r)
    {
        int q = partition(a, p, r);
        quickSort(a, p, q); quickSort(a, q + 1, r);
    }
}

void randomizedQuickSort (int * a, int p, int r)
{
    if (p < r)
    {
        int q = randomizedPartition(a, p, r);
        randomizedQuickSort(a, p, q); randomizedQuickSort(a, q + 1, r);
    }
}

int main()
{
    int n, start_time, end_time;
    string flag, pivot;

    cout<<"Enter a number of elements: "; cin>>n;
    int *a = new int [n];
    srand(time(0));
    for (int i=0;i<n;i++)
    {
        *(a+i)=rand()%100;
    }
    cout<<"Enter yes if you want to print the original and sorted array and no if only sorted: ";
    cin>>flag;
    cout<<"Enter what is the way of choosing pivot do you want (common or random): ";
    cin>>pivot;
    
    if (flag == "yes")
    {
        cout<<"Original array: ";
        for (int i=0;i<n;i++)
            cout<<*(a+i)<<" ";
    }
    cout<<endl;

    if (pivot == "common")
    {
        start_time = clock();
        quickSort (a, 0, n-1);
        end_time = clock();
    }
    
    else if (pivot == "random")
    {
        start_time = clock();
        randomizedQuickSort (a, 0, n-1);
        end_time = clock();
    }
    
    cout<<"Sorted array: ";
    for (int i = 0; i < n; i++) cout<<*(a+i)<<" ";
    cout<<endl;
    cout<<"Sort-time:"<<(end_time - start_time)/(CLOCKS_PER_SEC/1000.0)<<" ms"<<endl;
    
    return 0;
}
