#include <stdlib.h>
#include <stdio.h>

struct node
{
    struct node *next;
    int data;
};

struct node *head;
struct node *tail;
int length = 0;

void addFirst(int d)
{
    struct node *newn = (struct node *)malloc(sizeof(struct node));
    newn->data = d;
    if (head == NULL)
    {
        head = newn;
        tail = newn;
        tail->next = NULL;
    }
    else
    {
        struct node *tmp = head;
        head = newn;
        head->next = tmp;
    }
    length++;
}

void addLast(int d)
{
    struct node *newn = (struct node *)malloc(sizeof(struct node));
    newn->data = d;
    if (head == NULL)
    {
        head = newn;
        tail = newn;
    }
    else
    {
        tail->next = newn;
        tail = newn;
        tail->next = NULL;
    }
    length++;
}

void pollFirst()
{   if (head == NULL) return;
    struct node *tmp = head;
    head = head->next;
    free(tmp);
    length--;
}

void pollLast() {
    if (tail == NULL) return;
    struct node *tmp2 = tail;
    struct node *tmp = head;
    while (tmp->next->next != NULL)
    {
        tmp = tmp->next;
    }
    tail = tmp;
    tail->next = NULL;
    free(tmp2);
    length--;
}

int peekF()
{
    return head->data;
}

int peekL()
{
    return tail->data;
}

int get(int i)
{   
    struct node *curr = head;
    int ind = 0;
    if (i > length - 1 || i < 0)
        return -1;
    while (ind < i)
    {
        curr = curr->next;
        ind++;
    }
    return curr->data;
}

void del(int i)
{
    int ind = 1;
    struct node *prev = head;
    struct node *curr = head->next;
    if (i > length - 1 || i < 0)
        return;
    if (i == 0)
    {
        pollFirst();
        return;
    }
    else if (i == length - 1)
    {
        pollLast();
        return;
    }
    while (ind < i)
    {
        ind++;
        prev = prev->next;
        curr = curr->next;
    }
    prev->next = curr->next;
    free(curr);
    length--;
}

void insert(int data, int i)
{
    int ind = 1;
    if (i > length || i < 0)
        return;
    struct node *newn = (struct node *)malloc(sizeof(struct node));
    struct node *curr = head;
    newn->data = data;
    if (i == 0)
    {
        addFirst(data);
    }
    if (i == length)
    {
        addLast(data);
    }
    struct node *post = curr->next;
    while (ind < i)
    {
        ind++;
        curr = curr->next;
        post = post->next;
    }
    curr->next = newn;
    newn->next = post;
}

int len()
{
    return length;
}

void setLoop() {
    tail->next = head;
}

void add(int data)
{
    addLast(data);
}

void poll(int data)
{
    pollLast(data);
}

void traverse()
{
    struct node *curr = head;
    printf("\n\n%d", curr->data);
    curr = curr->next;
    while (curr)
    {
        printf(" -> %d", curr->data);
        curr = curr->next;
    }
}

int main()
{
    add(6);
    add(5);
    add(6);
    add(7);
    add(8);
    add(2);
    add(4);
    add(8);
    traverse();
    addLast(89);
    traverse();
    del(4);
    insert(72, 4);
    traverse();
    printf("\n%d", len());
    return 0;
}
