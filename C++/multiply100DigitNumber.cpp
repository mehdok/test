#include <iostream>

#define MAX 10000

using namespace std;

char * multiply(char a[],char b[])
{
    static char mul[MAX];
    char c[MAX];
    char temp[MAX];
    int aLength,bLength;
    int i,j,k = 0,x = 0,y;
    long int r = 0;
    long sum = 0;
    aLength = strlen(a) - 1;
    bLength = strlen(b) - 1;

    for(i=0 ; i <= aLength ; i++)
    {
        a[i] = a[i] - 48;
    }

    for(i=0 ; i <= bLength ; i++)
    {
        b[i] = b[i] - 48;
    }

    for(i = bLength ; i >= 0 ; i--)
    {
         r = 0;
         for(j = aLength ; j >= 0 ; j--)
         {
             temp[k++] = (b[i] * a[j] + r) % 10;
             r = (b[i] * a[j] + r) / 10;
         }
         temp[k++] = r;
         x++;
         for(y = 0 ; y < x ; y++)
         {
             temp[k++] = 0;
         }
    }

    k = 0;
    r = 0;
    for(i = 0 ; i < aLength+bLength+2 ; i++)
    {
         sum = 0;
         y = 0;
         for(j = 1 ; j <= bLength+1 ; j++)
         {
             if(i <= aLength+j)
             {
                 sum = sum + temp[y+i];
             }
             y += j + aLength + 1;
         }
         c[k++] = (sum + r) %10;
         r = (sum + r) / 10;
    }

    c[k] = r;
    j = 0;
    for(i = k-1 ; i >= 0 ; i--){
         mul[j++]=c[i] + 48;
    }
    mul[j] = '\0';
    return mul;
}




int main()
{
    char a[MAX];
    char b[MAX];
    char *result;

    cout << "Please Enter First Number (MAX 100 DIGIT ) : ";
    cin >> a;
    cout << "Please Enter Second Number (MAX 100 DIGIT ) : ";
    cin >> b;

    result = multiply (a, b);
    cout << "Multiplication is : " << result <<"\n";

    system("pause");

    return (0);
}

