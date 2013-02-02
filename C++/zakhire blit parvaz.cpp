#include <iostream>
using namespace std;

int first_class (int &count1 ,int array[])
{
    
         if (count1 == 5)
         {
                    cout <<"the first class is full you can not give chair\n";
         }
         else
         {
             array[count1] = 1;
             count1 += 1;
         }
}

int economy(int &count1 , int &count2 , int array[] , int &passokh)
{
    if (count2 == 10)
    {
               cout <<"the economy is full ,do you want give first class ( 1 for 'yes' , 0 for 'no' :\n";
               cin >> passokh;
               
               if (passokh == 1)
                  first_class(count1 , array);
               else if (passokh == 0)
                   cout << "next flight leaves in 3 hours\n";
    }
    else
    {
        array[count2] = 1 ;
        count2 += 1;
    }
}
int main()
{
       
    int number = 0 ;
    int array[10] = {0} ;
    int count1 = 0 ;
    int count2 = 5 ;
    int passokh ;
    
    while (number != -1)
    {
         
         cout << "please type 1 for \"first class\"";
         cout << "\nplease type 2 for \"economy\"" << endl;
         cout << "please type -1 for terminating program" << endl;
         
         cin >> number;
         
         if (number == 1)
            first_class(count1 , array );
         
         if (number == 2)
            economy(count1 , count2 , array , passokh);
         
         cout << "the first class chair is :\n";
         for (int i = 0 ; i <= 4; i++)
         {
             cout << endl << i + 1 <<" : ";
             if (array[i] == 1)
                cout <<"*";
         }
         cout <<"\n\nthe economy chair is :\n";
         for(int j = 5 ; j <= 9 ; j++)
         {
                 cout << endl << j + 1 <<" : ";
                 if (array[j] == 1)
                    cout << "*";
         }
         cout << endl;
         
         system("pause");
    }
    return 0;
}
    
    
   
    

            
