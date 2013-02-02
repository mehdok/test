#include <iostream>
using namespace std;
int main()
{
    int control = 0 , input;
 //   int j;
    cout<<"Enter a number:(2 or bigger)"<<endl;
    cin>>input;
    cout<<"primes less than " << input <<":" << endl << "2\t";//entered number:"<<endl<<"2\t";
    for(int i = 3 ; i < input ; i += 2)
    {
        for(int j = 2 ; j < i ; j++)
            if((i % j) == 0)
            {
                control = 1;
                break;
            }
        if(control == 0)
            cout<< i << "\t";
        control = 0;
    }
    return 0;
}
