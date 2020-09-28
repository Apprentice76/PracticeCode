#include <stdlib.h>
#include <stdio.h>
#define MAX 1000

int queue[MAX];
int front = 0, rear = -1, elms=0;

int isEmpty()
{
    if (rear == -1 || elms == 0)
        return 1;
    return 0;
}

int isFull()
{   if (elms == MAX) return 1;
    // if (rear != -1 && (rear+1)%MAX == front)
    //     return 1;            
    return 0;
}

void enqueue(int d)
{
    if (isFull()) {
        printf("\nIs Full!"); //Full
        return;
    }
    ++rear;
    if (rear == MAX) rear = 0;
    queue[rear] = d;
    elms++;
}

int dequeue()
{
    if (isEmpty())
    {
        printf("\nIs Empty!"); //Empty
        return INT_MIN;
    }
    int elm = queue[front];
    front++;
    if (front == MAX) front = 0;
    elms--;
    return elm;
}

void printQueue() {
    // int i=front;
    printf("\n");
    if (elms!=0)
    for (int i=front; ; i++) {
        // i++;
        if (i == MAX) i=0;
        printf("%d ", queue[i]);
        if (i == rear) break;
    }
}

int main()
{
    // dequeue();
    enqueue(5);
    enqueue(6);
    enqueue(7);
    enqueue(4);
    printQueue();
    printf("\n%d", dequeue());
    // printQueue();
    // printf("\n%d", dequeue());
    // printf("\n%d", dequeue());
    // printf("\n%d", dequeue());
    enqueue(21);
    enqueue(21);
    printf("\nf: %d, r: %d", front, rear);
    printQueue();
    dequeue();
    dequeue();
    dequeue();
    dequeue();
    printf("\nf: %d, r: %d", front, rear);
    dequeue();
    dequeue();
    printQueue();
}
