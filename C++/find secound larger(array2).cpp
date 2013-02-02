/* this program writen to calculate second larger value in an array
                    writer : mehdi sohrabi*/

#include <iostream>
using namespace std;

int main()
{
    const int arraysize = 11; //this is array size
    int array[arraysize][2] = {0}; //this is array with two boed
    for (int i = 0 ; i < arraysize ; i++) // thia loop is to getting array value
    {
        cout << "please enter number " << i + 1 << " : ";
        cin >> array[i][0];
        array[i][1] = i + 1; // this store index of value
    }

    for (int j = 0 ; j < arraysize ; j++) // with this two loop array is sorting
        for (int k = j + 1 ; k < arraysize ; k++)
            if (array[j][0] < array[k][0])
            {
                int temp = 0; //this three line change value
                temp = array[j][0];
                array[j][0] = array[k][0];
                array[k][0] = temp;
                int temp2 = array[j][1]; // this three line change index of value
                array[j][1] = array[k][1];
                array[k][1] = temp2;
            }

    cout << "\nsecond larger value is : " << array[1][0];
    cout << "\n\nand his index is : " << array[1][1] << endl << endl;

    system("pause");

    return 0 ;
}
