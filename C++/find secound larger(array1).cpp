//program to determin second max value
#include <iostream>
using namespace std;

int max (int array[] , const int arraysize , int ignore)
{
    int i = 0 , index = 0 , max = array[i];

    for (i ; i < arraysize ; i++)
    {
        if(i == ignore)
            continue;
        else if(max < array[i])
        {
            max = array[i];
            index = i;
        }
    }
    return index;
}

int main()
{
    const int arraysize = 12;
    int array[arraysize] = {0};
    int ignore = -1;

    for(int i = 0 ; i < arraysize ; i++)
    {
        cout <<"please enter number " << i + 1 <<" of array : ";
        cin >> array[i];
    }

    int index = max(array , arraysize , ignore);
    ignore = index;
    index = max(array , arraysize , ignore);

    cout << "\nyour array is :\n\n";
    for (int i = 0 ; i < arraysize ; i++)
        cout << array[i] << "  ";

    cout << "\nand second max value is : " << array[index] << "\nand her index is : " << index + 1 << endl;

    system("pause");

    return 0;
}
