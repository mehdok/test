//anagram.cpp
//creates anagrams
#include <iostream>
#include <string>
using namespace std;
////////////////////////////////////////////////////////////////
class word
{
private:
int size; //length of input word
int count; //numbers in display
string workStr; //workspace
void rotate(int); //rotate part of workStr
void displayWord(); //display workStr
public:
word(string); //constructor
void anagram(int); //anagram ourselves
};
//--------------------------------------------------------------
//constructor
word::word(string inpStr) : workStr(inpStr), count(0)
{ //initialize workStr
size = inpStr.length(); //number of characters
}
//--------------------------------------------------------------
void word::anagram(int newSize)
{
if(newSize == 1) //if too small,
return; //go no further
for(int j=0; j<newSize; j++) //for each position,
{
anagram(newSize-1); //anagram remaining
if(newSize==2) //if innermost,
displayWord(); // display it
rotate(newSize); //rotate word
}
}
//--------------------------------------------------------------
//rotate left all chars from position to end
void word::rotate(int newSize)
{
int j;
int position = size - newSize;
char temp = workStr[position]; //save first letter
for(j=position+1; j<size; j++) //shift others left
workStr[j-1] = workStr[j];
workStr[j-1] = temp; //put first on right
}
//--------------------------------------------------------------
void word::displayWord()
{
if(count < 99) //spaces before onecout
cout << " "; //or two-digit numbers
if(count < 9)
cout << " ";
cout << ++count << " "; //number
cout << workStr << " ";
if(count%6 == 0)
cout << endl;
}
////////////////////////////////////////////////////////////////
int main()
{
string input;
int length;
cout << "Enter a word: "; //get word
cin >> input;
length = input.length(); //get its length
word theWord(input); //make a word object
theWord.anagram(length); //anagram it
return 0;
} //end main()
