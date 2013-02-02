#include <iostream>

using namespace std;

void prem(int *a , const int k , const int n)
{
    if(k == n-1)
    {
        for(int i = 0 ; i < n ; i++)
            cout << a[i] << " ";
        cout << endl;
    }

    else
    {
        for(int i = k ; i < n ; i++)
        {
            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;

            prem(a , k + 1 , n);

            temp = a[k];
            a[k] = a[i];
            a[i] = temp;

        }
    }
}

int main()
{
    const int arraysize = 3;


    int array[arraysize] = {0};

    for (int i = 0 ; i < arraysize ; i++)
        cout << array[i] << " ";
    cout << endl;

    for (int j = 0 ; j < arraysize - 1 ; j++)
    {
        array[j] = 1;
        prem(array , 0 , arraysize);
    }

    array[arraysize - 1] = 1 ;
    for(int i = 0 ; i < arraysize ; i++)
        cout << array[i] << " " ;
    cout << endl;

    system("pause");

    return 0;
}
