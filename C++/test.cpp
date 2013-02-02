//sortedList.cpp
//demonstrates sorted list
#include <iostream>
using namespace std;
////////////////////////////////////////////////////////////////
class Link
{
public:
double dData; //data item
Link* pNext; //next link in list
//-------------------------------------------------------------
Link(double dd) : dData(dd), pNext(NULL) //constructor
{ }
//-------------------------------------------------------------
void displayLink() //display this link
{ cout << dData << " "; }
}; //end class Link
////////////////////////////////////////////////////////////////
class SortedList
{
private:
Link* pFirst; //ptr to first link
public:
//-------------------------------------------------------------
SortedList() : pFirst(NULL) //constructor
{ }
//-------------------------------------------------------------
~SortedList() //destructor
{ // (deletes links)
Link* pCurrent = pFirst; //start at first
while(pCurrent != NULL) //until end of list,
{
Link* pOldCur = pCurrent; //save current link
pCurrent = pCurrent->pNext; //move to next link
delete pOldCur; //delete old current
}
}
//-------------------------------------------------------------
bool isEmpty() //true if no links
{ return (pFirst==NULL); }
//-------------------------------------------------------------
void insert(double key) //insert, in order
{
Link* pNewLink = new Link(key); //make new link
Link* pPrevious = NULL; //start at first
Link* pCurrent = pFirst;
//until end of list,
while(pCurrent != NULL && key > pCurrent->dData)
{ //or key > current,
pPrevious = pCurrent;
pCurrent = pCurrent->pNext; //go to next item
}
if(pPrevious==NULL) //at beginning of list
pFirst = pNewLink; //first --> newLink
else //not at beginning
pPrevious->pNext = pNewLink; //old prev --> newLink
pNewLink->pNext = pCurrent; //newLink --> old current
} //end insert()
//-------------------------------------------------------------
void remove() //remove first link
{ //(assumes non-empty list)
Link* pTemp = pFirst; //save first
pFirst = pFirst->pNext; //new first --> next
delete pTemp; //delete old first link
}
//-------------------------------------------------------------
void displayList()
{
cout << "List (first-->last): ";
Link* pCurrent = pFirst; //start at beginning of list
while(pCurrent != NULL) //until end of list,
{
pCurrent->displayLink(); //print data
pCurrent = pCurrent->pNext; //move to next link
}
cout << endl;
}
}; //end class SortedList
////////////////////////////////////////////////////////////////
int main()
{
SortedList theSortedList; //create new list
theSortedList.insert(20); //insert 2 items
theSortedList.insert(10);
theSortedList.displayList(); //display list (20, 40)
theSortedList.insert(40); //insert 3 more items
theSortedList.insert(30);
theSortedList.insert(50);
theSortedList.displayList(); //display list
// (10, 20, 30, 40, 50)
theSortedList.remove(); //remove smallest item
theSortedList.displayList(); //display list (20, 30, 40, 50)
return 0;
} //end main()
