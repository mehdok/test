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
        Queue(int ms) : maxsize(ms) , front(-1) , rear(-1)    //constructor
        {}

    void add( int j )   //add item to end of Queue
    {
        if (isfull())
            cout << "Queue is full";
        else if ((rear == maxsize - 1) && (front != -1))
        {
            rear = -1 ;
            quearr[++rear] = j;
        }
        else
            quearr[++rear] = j;
    }

    int remove()    //remove item from top of Queue
    {
        if(isempty())
            cout << "Queue is empty";
        else if ((front == maxsize - 1) && (rear != -1))
        {
            front = -1;
            int temp = quearr[++front];
            return temp;
        }
        else
            {
                int temp = quearr[++front];
                return temp;
            }

    }

    bool isfull()   //true if Queue is full
    {
        return (((rear == maxsize -1) && (front == -1)) ||
                    (rear + 1 == front));
    }

    bool isempty()
    {
        return (((front == maxsize -1) && (rear == -1))||
                    (rear == front));
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
    theQueue.add(60);

    return 0;
}
