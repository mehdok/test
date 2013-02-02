//towers.cpp
//solves Towers of Hanoi puzzle
#include <iostream>
using namespace std;
void doTowers(int, char, char, char); //prototype
//––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
int main()
{
int nDisks; //number of disks
cout << "Enter number of disks: "; //get # of disks
cin >> nDisks;
doTowers(nDisks, 'A', 'B', 'C'); //solve it
return 0;
}
//––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
void doTowers(int topN, char src, char inter, char dest)
{
if(topN==1) //display
cout << "Disk 1 from " << src << " to " << dest << endl;
else
{
doTowers(topN-1, src, dest, inter); //src to inter
cout << "Disk " << topN //display
<< " from " << src << " to " << dest << endl;
doTowers(topN-1, inter, src, dest); //inter to dest
}
}
