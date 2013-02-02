#include <iostream>
using namespace std;

int binary(int number1)
{
     int i = 0 ; 
     int array1[200] = {0};
          
     for (i = 0 ; number1 != 0 ; i++ )
     {
         array1[i] = ( number1 % 2 );
         number1 = ( number1 / 2);
         
     }
          
     cout << "your number in base 2 is : \n" ;
     
     for (int j = i - 1 ; j >= 0 ; j-- )
     {
         cout << array1[j];
     }
     cout << endl;
}

int main()
{
    int number = 0;
    
    cout << "please enter your number in base 10 : " ;
    cin >> number ;

    binary ( number );
    
    system ("pause");
    
    return 0 ;
}
