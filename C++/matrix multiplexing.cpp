#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "please enter N (below than 20) : ";
    cin >> n;

    while(n>20)
    {
        cout << "you must enter a number below than 20. " << endl;
        cout << "please enter N (blew than 20) : ";
        cin >> n;
    }

    int a[n][n] , b[n][n] , c[n][n];
    for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
        {
            cout << "please enter matrix A" << i+1 << j+1 << " :";
            cin >> a[i][j];
        }

    for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
        {
            cout << "please enter matrix B" << i+1 << j+1 << " :";
            cin >> b[i][j];
        }

    for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
            c[i][j] = 0;

    for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
            for(int k = 0 ; k < n ; k++)
                c[i][j] += a[i][k] * b[k][j];

    cout << "the result of A*B is :" << endl;
    for(int i = 0 ; i < n ; i++)
    {
        for(int j = 0 ; j < n ; j++)
            cout << c[i][j] << "\t";
        cout << endl;
    }

    return 0;
}

