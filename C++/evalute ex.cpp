//program to evalute e^x = 1 + x^1 / 1! + x^2 + 2! + ....
#include <iostream>
#include <cmath>

using namespace std;

unsigned long fac(int num1)
{
    unsigned long total = 1;
    for(num1 ; num1 > 1 ; num1--)
        total = total * num1;

    return total;
}

int main()
{
    double sum = 1.0 , tavan = 0 , x;
    int num ;
    cout << "we want to evalute sum of 'e^x'"
         << "\n\nplease enter number of 'x' : ";
    cin >> x;

    cout << "\n\nnow enter number of series : ";
    cin >> num ;

    for (int i = 1 ; i < num ; i++)
    {
        tavan = pow(x,i);
        sum = sum + ( tavan / fac(i));
    }

    cout << "\n\nthe sum of this series is : " << sum << endl;

    system("pause");

    return 0;
}




