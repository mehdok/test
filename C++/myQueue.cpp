//Queue class

#include <iostream>
using namespace std;

class Queue
{
    private:
        int front;  //front of Queue
        int rear;   //end of Queue
        int maxsize;  //max of Queue
        int quearr[5];
    public:
        Queue(int ms) : maxsize(ms) , front(0) , rear(-1)    //constructor
        {}

    void add( int j )   //add item to end of Queue
    {
        if (isfull())
            cout << "Queue is full" << endl;
        else
            quearr[rear = ((rear + 1) % maxsize)] = j;
    }

    int remove()    //remove item from top of Queue
    {
        if(isempty())
            cout << "Queue is empty" << endl;
        else
        {
            int temp = quearr[front = ((front + 1) % maxsize)];
            return temp;
        }
    }

    bool isfull()   //true if Queue is full
    {
        return ((rear + 1) % maxsize == front);
    }

    bool isempty()
    {
        return (rear == front);
    }
};  //end of Queue class

int main()
{
    Queue theQueue(5);

    theQueue.add(10);
    theQueue.add(20);
    theQueue.add(30);
    theQueue.add(40);
    theQueue.add(50);

    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl << "OK" << endl;

    theQueue.add(60);
    theQueue.add(70);
    theQueue.add(80);
    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl;
    cout << theQueue.remove() << endl;

    return 0;
}
