#include <stdlib.h>
#include <stdio.h>
#define MAX 1000

int queue[MAX];
int front = 0, rear = -1;

int isEmpty() {
    if (rear == -1 || front > rear) return 1;
    return 0;
}

int isFull() {
    if (rear == MAX-1) return 1;
    return 0;
}

void enqueue(int d)
{
    if (isFull()) printf("\nIs Full!"); //Full
    else queue[++rear] = d;
}

int dequeue()
{
    if (isEmpty()) {
        printf("\nIs Empty!"); //Empty
        return INT_MIN;
    }
    int elm = queue[front];
    front++;
    return elm;
}

void printQueue() {
    if (front <= rear) printf("\n%d", queue[front]);
    for (int i=front+1; i<=rear; i++) {
        printf(" -> %d", queue[i]);
    }
}

int main() {
    dequeue();
    enqueue(5);
    enqueue(6);
    enqueue(7);
    enqueue(4);
    printQueue();
    printf("\n%d", dequeue());
    printQueue();
    printf("\n%d", dequeue());
    printf("\n%d", dequeue());
    printf("\n%d", dequeue());
    printf("\nf: %d, r: %d", front, rear);
    dequeue();
    printQueue();
}
