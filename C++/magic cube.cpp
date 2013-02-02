#include <iostream>

using namespace std;

void magic(int n)
{
    const int maxsize = 51;
    int square[maxsize][maxsize] , k , l;
    if((n > (maxsize)) || (n < 1))
    {
        cerr << "error!..n out of range" << endl ;
        return;
    }
    else if (!(n % 2))
    {
        cerr << "eroor!..n is even" <<endl;
        return;
    }

    for (int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
            square[i][j] = 0;

    square[0][(n-1)/2] = 1;

    int key = 2 , i = 0 , j =(n-1)/2;

    while(key <= n * n)
    {
        if(i - 1 < 0)
            k = n - 1;
        else
            k = i - 1;

        if(j - 1 < 0)
            l = n - 1;
        else
            l = j - 1;

        if(square[k][l])
            i = (i + 1) % n ;
        else
        {
            i = k;
            j = l;
        }

        square[i][j] = key;
        key++;
    }

    cout << "magic square of size " << n << endl;

    for(i = 0 ; i < n ; i++)
        {
        for(j = 0 ; j < n ; j++)
            cout << square[i][j] << " ";
        cout << endl;
        }
}

int main()
{
    int n;

    cout << "please enter number of cube : ";
    cin >> n;
    cout << endl;

    magic(n);

    return 0;
}



