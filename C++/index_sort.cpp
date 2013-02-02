//index sort program
#include <iostream>
using namespace std;

///////////////////////////////////////////////////////////

int indexsort(int array[] , int iarray[] , const int arraysize)
{
    //finding index of min value
    int min = 0;
    for(int i = 1 ; i < arraysize ; i++)
        if(array[min] > array[i])
            min = i;

    //finding index of max value
    int max = 0;
    for(int i = 1 ; i < arraysize ; i++)
        if(array[max] < array[i])
            max = i;

    //filling iarray with index of min and max value
    iarray[0] = min;
    for(int i = 1 ; i < arraysize ; i++)
        iarray[i] = max;

    //filling iarray with sorted index of value
    for(int i = 1 ; i < arraysize ; i++)
        for(int j = 0 ; j < arraysize ; j ++)
            if((array[iarray[i]] > array[j]) && (array[j] > array[iarray[i-1]]))
                iarray[i] = j ;
}

///////////////////////////////////////////////////////////

int main()
{
    const int arraysize = 10;
    int array[arraysize] = {1 , 22 , 4 , 18 , 40 , 0 , 6 , 11 , 34 , 2};
    int iarray[arraysize];

    indexsort(array , iarray , arraysize);

    //show sorted array
    cout << "sorted array is :" << endl;

    for(int i = 0 ; i < arraysize ; i++)
        cout << array[iarray[i]] << "  ";

    return 0;
}

