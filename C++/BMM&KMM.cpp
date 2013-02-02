#include <iostream>
using namespace std;
int BMM(int p1 , int p2)
{
    int temp , bmm , r = 1 ;
    if ( p1 < p2 )
    {
         temp = p1 ;
         p1 = p2 ;
         p2 = temp ;
    }
    while ( r > 0 )
    {
          r = p1 % p2 ;
          if ( r == 0 )
          {
                bmm = p2 ;
          }
          else
          {
              p1 = p2 ;
              p2 = r ;
          }
    }
    return bmm ;
}

int KMM ( int p1 , int p2 )
{
    int kmm;
    kmm = ( p1 * p2 ) / ( BMM( p1 , p2 ));
    return kmm ;
}

int main()
{
    int p1 , p2 , mbmm = 0 , mkmm = 0;
    
    cout << "this program culculate BMM & KMM of two number"<<endl;
    
    cout << "please enter first number : ";
    cin >> p1 ;
    cout << "\nplease enter second number : ";
    cin >> p2 ;
    
    mbmm = BMM ( p1 , p2 ) ;
    mkmm = KMM ( p1 , p2 ) ;
    
    cout << "B.M.M is : " << mbmm << endl ;
    cout << "K.M.M is : " << mkmm << endl ;
    
    system ("pause") ;
    return 0 ;
}

