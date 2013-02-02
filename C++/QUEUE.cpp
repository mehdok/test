//Queue class

#include <iostream>
using namespace std;

class Queue
{
    private:
        int front;  //front of Queue
        int rear;   //end of Queue
        const int maxsize;  //max of Queue
        int quearr[5];
    public:
        Queue(const int ms) : maxsize(ms) , front(-1) , rear(-1)    //constructor
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
        return (((rear + 1) % maxsize) == front);
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
    cout << "add 10" << endl;
    theQueue.add(20);
    cout << "add 20" << endl;
    theQueue.add(30);
    cout << "add 30" << endl;
    theQueue.add(40);
    cout << "add 40" << endl;
    theQueue.add(50);
    cout << "add 50" << endl;

    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl << "OK" << endl;

    theQueue.add(60);
    cout << "add 60" << endl;
    theQueue.add(70);
    cout << "add 70" << endl;
    theQueue.add(80);
    cout << "add 80" << endl;

    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl;
    cout << "remove : " << theQueue.remove() << endl;

    return 0;
}
