package com;

public interface DataStructures<T> {
    boolean add(T element);
    void clear();
    boolean contains(Object obj);
    boolean isEmpty();
    boolean remove(Object obj);
    int size();
    Object[] toArray(Object[] obj);
    String getStructureType();
    abstract class Set<T> {

    }
    abstract class SortedSet<T> extends Set<T> {

    }
    class HashSet<T> extends Set<T> {

    }
    class LinkedHashSet<T> extends Set<T> {

    }
    class TreeSet<T> extends SortedSet<T> {

    }
    interface Queue<T> {

    }
    class PriorityQueue<T> implements Queue<T> {

    }
    interface Deque<T> extends Queue<T> {

    }
    class ArrayDeque<T> implements Deque<T> {

    }
    interface List<T> extends DataStructures<T> {
        // boolean add(T element);
        void add(int index, T value);
        // void clear();
        // boolean contains(Object obj);
        boolean equals(List<T> list);
        T get(int index);
        int indexOf(Object obj);
        // boolean isEmpty();
        int lastIndexOf(Object obj);
        T remove(int index);
        // boolean remove(Object obj);
        boolean removeAll(T value);  //Doubt
        T set(int index, T value);
        // int size();
        // void sort();
        List<T> sublist(int startIndex, int endIndex);
        // Object[] toArray();
        String toString();
    }
    class ArrayList<T> implements List<T> {

        private int size;
        private Object[] arr = new Object[10];
        
        public ArrayList() {
            arr = new Object[10];
            this.size = 0;
        }

        private void bounds() {
            System.out.println("\nIndexOutOfBounds");
        }

        private void increaseArrSize() {
            int len = arr.length;
            int new_len = len + (int) Math.ceil(len);
            Object[] new_arr = new Object[new_len];
            for (int i = 0; i < new_arr.length; i++) {
                if (i < len)
                    new_arr[i] = arr[i];
                else
                    new_arr[i] = null;
            }
            this.arr = new_arr;
        }

        @Override
        public boolean add(T element) {
            arr[size++] = element;
            if (size == arr.length)
                increaseArrSize();
            return true;
        }

        @Override
        public void add(int index, T value) {
            if (index > size) {
                bounds();
                return;
            }
            for (int i = size; i > index; i--)
                arr[i] = arr[i - 1];
            arr[index] = value;
            size++;
            if (size == arr.length)
                increaseArrSize();
        }

        @Override
        public void clear() {
            for (int i = 0; i < arr.length; i++)
                arr[i] = null;
            this.size = 0;
        }

        @Override
        public boolean contains(Object obj) {
            for (int i = 0; i < size; i++)
                if (arr[i] == obj)
                    return true;
            return false;
        }

        @Override
        public boolean equals(List<T> list) {
            if (this.getStructureType() != list.getStructureType() || this.size != list.size()) return false;
            if (this.size == 0)
                return true;
            for (int i = 0; i < size; i++)
                if (this.get(i) != list.get(i))
                    return false;
            return true;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < size)
                return (T)arr[index];
            bounds();
            return null;
        }
        
        @Override
        public int indexOf(Object obj) {
            for (int i = 0; i < size; i++)
                if (arr[i] == obj)
                    return i;
            return -1;
        }

        @Override
        public boolean isEmpty() {
            if (size == 0)
                return true;
            return false;
        }

        @Override
        public int lastIndexOf(Object obj) {
            for (int i = size - 1; i >= 0; i++)
                if (arr[i] == obj)
                    return i;
            return -1;
        }
        
        @Override
        @SuppressWarnings("unchecked")
        public T remove(int index) {
            if (index >= size) {
                bounds();
                return null;
            }
            T var = (T)arr[index];
            for (int i = index; i < size - 1; i++)
                arr[i] = arr[i + 1];
            size--;
            return var;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object obj) {
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                if (arr[i] == (T)obj && flag) {
                    flag = false;
                }
                if (!flag) {
                    arr[i] = arr[i + 1];
                    size--;
                }
            }
            return !flag;
        }
        
        @Override
        public boolean removeAll(T value) {
            int count = 0;
            for (int i = 0; i < size - count; i++) {
                if (arr[i] == value) {
                    count++;
                    arr[i] = arr[i + 1];
                }
            }
            size -= count;
            return true;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T set(int index, T value) {
            if (index < size) {
                T old = (T) arr[index];
                arr[index] = value;
                return old;
            }
            bounds();
            return null;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public List<T> sublist(int startIndex, int endIndex) {
            List<T> list = new ArrayList<>();
            endIndex = Math.min(size, endIndex);
            for (int i=startIndex; i<endIndex; i++) list.add((T)arr[i]);
            return list; 
        }

        @Override
        @SuppressWarnings("unchecked")
        public Object[] toArray(Object[] obj) {
            Object[] array = new Object[size];
            for (int i=0; i<size; i++) array[i] = arr[i];
            return array;
        }

        @Override
        public String toString() {
            if (size == 0) return "[]";
            String s = "[";
            for (int i=0; i<size-1; i++) s+=arr[i] + ", ";
            return s+=arr[size-1] + "]";
        }

        void trimToSize() {
            Object[] list = new Object[size];
            for (int i=0; i<size; i++) list[i] = arr[i];
            this.arr = list;
        }

        @Override
        public String getStructureType() {
            return "ArrayList";
        }


    }
    class LinkedList<T> implements List<T>, Deque<T> {
        private Node head, tail;
        private int size;

        class Node {
            Node prev, next;
            T data;
            Node(T data) {
                this.data = data;
                next = null;
                prev = null;
            }
        }

        public LinkedList() {
            this.head = this.tail = null;
            this.size = 0;
        }

        private void bounds() {
            System.out.println("\nIndexOutOfBounds");
        }

        @Override
        public boolean add(T element) {
            size++;
            if (head == null) {
                head = new Node(element);
                tail = head;
                return true;
            }
            tail.next = new Node(element);
            tail = tail.next;
            return true;
        }

        @Override
        public void clear() {
            this.head = this.tail = null;
            this.size = 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean contains(Object obj) {
            Node front = head;
            Node end = tail;
            if (front.data == obj) return true; 
            while (front != tail.next) {
                if (front.data == (T)obj || end.data == (T)obj) return true;
                front = front.next;
                end = end.prev;
            }
            return false;
        }

        @Override
        public boolean isEmpty() {
            if (this.head == null) return true;
            return false;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object obj) {
            Node curr = head;
            while (curr.next != null) {
                if (curr.data == (T)obj) {
                    curr.next = curr.next.next;
                    curr.next.prev = curr;
                    size--;
                    return true;
                }
            }
            return false;
        }

        @Override
        public int size() {
            return this.size;
        }

        private void link(Node first, Node second) {
            if (first != null) first.next = second;
            if (second != null) second.prev = first;
        }

        @Override
        public void add(int index, T value) {
            Node post = head;
            if (index >= size) {
                bounds();
                return;
            }
            int i=0;
            size++;
            while(i++ != index) {
                post = post.next;
            }
            Node tmp = new Node(value);
            link(post.prev, tmp);
            link(tmp, post);
        }

        @Override
        public String getStructureType() {
            return "LinkedList";
        }

        @Override
        public boolean equals(List<T> list) {
            if (this.getStructureType() != list.getStructureType() || this.size != list.size())
                return false;
            if (this.size == 0) return true;
            Node curr = this.head;
            Object[] checker = list.toArray(new Object[list.size()]);
            int i=0;
            while (curr.next != null) {
                if (curr.data != checker[i++]) return false;
                curr = curr.next;
            }
            return true;
        }

        @Override
        public T get(int index) {
            if (index >= size) {
                bounds();
                return null;
            }
            int i = 0;
            Node curr = head;
            while (i != index) curr = curr.next;
            return curr.data;
        }

        @Override
        @SuppressWarnings("unchecked")
        public int indexOf(Object obj) {
            int i = 0;
            Node curr = head;
            while (curr.next != null) {
                if (curr.data == (T)obj) return i;
                i++;
            }
            return -1;
        }

        @Override
        @SuppressWarnings("unchecked")
        public int lastIndexOf(Object obj) {
            int i = size-1;
            Node curr = tail;
            while (curr.prev != null) {
                if (curr.data == (T)obj)
                    return i;
                i--;
            }
            return -1;
        }

        @Override
        public T remove(int index) {
            if (index >= size) {
                bounds();
                return null;
            }
            if (index == 0) {
                T val = head.data;
                head = head.next;
                return val;
            }
            int i = 0;
            Node curr = head;
            while (i < index) {
                curr = curr.next;
            }
            T val = curr.data;
            link(curr.prev, curr.next);
            size--;
            return val;
        }

        @Override
        public boolean removeAll(T value) {
            Node curr = head;
            while (curr.next != null) {
                if (curr.data =)
            }
            return false;
        }

        @Override
        public T set(int index, T value) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<T> sublist(int startIndex, int endIndex) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Object[] toArray(Object[] obj) {
            // TODO Auto-generated method stub
            return null;
        }
        
    }

    // class Stack<T> implements List<T> {

    // }
}


abstract class Map {
    abstract class SortedMap extends Map {

    }

    class HashMap extends Map {

    }

    class LinkedHashMap extends Map {

    }

    class TreeMap extends SortedMap {

    }
}
