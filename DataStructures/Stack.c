#include <stdlib.h>
#include <stdio.h>
#define MAX 1000

int stack[MAX];
int top=-1;

int isFull() {
    if (top + 1 == MAX) return 1;
    return 0;
}

int isEmpty() {
    if (top == -1) return 1;
    return 0;
}

void push(int d) {
    if (isFull()) {
        printf("\nIs Full!");
        return;
    }
    stack[++top] = d;
}

int pop() {
    if (isEmpty()) {
        printf("\nIs Empty!");
        return INT_MIN;
    }
    int elm = stack[top];
    top--;
    return elm;
}

void printStack()  {
    printf("\n");
    for (int i=0; i<=top; i++) printf("%d ", stack[i]);
}

int main() {
    push(4);
    push(7);
    push(8);
    push(3);
    push(2);
    push(9);
    push(0);
    push(1);
    printStack();
    pop();
    printStack();
    return 0;
}