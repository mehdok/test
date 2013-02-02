#include <iostream>
using namespace std;

int main()
{
    long int number;
    long int i = 1;
    
    cout << "please enter your number in base 2 : ";
    cin >> number;
    
    long int r = 0 , total = 0;
    
    while (number > 0)
    {
          r = number % 10;
          number = number / 10 ;
          total = total + (r * i);
          i = i * 2;
    }
    
    cout << "your number in base 10 is : " << total << endl;
    
    system("pause");
    
    return 0;
}
          
          
          
