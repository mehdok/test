//program to sort an array
#include <iostream>

using namespace std;

void sort(int array[] , const int arraysize)
{
    for (int i = 0 ; i < arraysize ; i++)
        for(int j = i + 1 ; j < arraysize ; j++)
            if (array[i] < array[j])//to sort in min reverse '<' to '>'
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
}

int main()
{
    const int arraysize = 12;
    int array[arraysize] = {0};

    for(int j = 0 ; j < arraysize ; j++)
    {
        cout <<"please enter number " << j + 1 << " of array : ";
        cin >> array[j];
    }

    sort (array , arraysize);
    cout << "your array after sorting is :\n" <<endl;
    for(int k = 0 ;k < arraysize ; k++)
        cout << array[k] << "  ";

    cout << endl << endl;

    system("pause");

    return 0;
}

