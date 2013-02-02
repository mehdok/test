//program to liner search an array
#include <iostream>

using namespace std;

int search (int array[] ,const int arraysize , int skey)
{
    int index = 0;

    for ( int i = 0 ; i < arraysize ; i++)
        if (array[i] == skey)
            index = i + 1;

    return index;
}

int main()
{
    const int arraysize = 10;
    int array[arraysize] = {0};
    int skey = 0;

    for (int j = 0 ; j < arraysize ; j++)
    {
        cout << "\nplease enter number " << j + 1 << " of array : ";
        cin >> array[j];
    }

    cout << "\nplease enter a number to search it in array : ";
    cin >> skey;

    int element = search(array , arraysize ,skey);

    if(element == 0)
        cout << "\nyour search key was not found\n" << endl;
    else
        cout << "your search key was found in position : " << element << endl;

    system("pause");

    return 0;
}
