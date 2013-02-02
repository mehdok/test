//Generate all the permutations of an array

#include <iostream>

using namespace std;

void perm(char *a , const int k , const int n)
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
            char temp = a[k];
            a[k] = a[i];
            a[i] = temp;

            perm(a , k + 1 , n);

            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
    }
}

int main()
{
    const int arraysize = 4;

    char array[arraysize] = {'a','b','c','d'};

    perm(array , 0 , arraysize);

    system("pause");

    return 0;
}


