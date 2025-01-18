package com.ragu;

import java.util.ArrayList;
import java.util.List;

public class Heaps<T extends Comparable<T>>{
    private List<T> heap;
    public Heaps() {
        heap = new ArrayList<T>();
    }
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int left(int i) {
        return i*2+1;
    }
    private int right(int i) {
        return i*2+2;
    }
    public void upheap(int i) {
        if(i==0)return;
        int parent = parent(i);
        if(heap.get(i).compareTo(heap.get(parent)) < 0) {
            swap(i, parent);
            upheap(parent);
        }
    }
    public void downheap(int i) {
        int min = i;
        int left = left(i);
        int right = right(i);
        if(left<heap.size()&&heap.get(min).compareTo(heap.get(left)) > 0)
            min = left;
        if(right<heap.size()&&heap.get(min).compareTo(heap.get(right)) > 0)
            min = right;
        if(min != i) {
            swap(i, min);
            downheap(min);
        }
    }
    public T remove() throws Exception{
        if (heap.isEmpty()) throw new Exception("Heap is empty");
        T temp = heap.get(0);
        T last=heap.remove(heap.size()-1);
       if (!heap.isEmpty()){
           heap.set(0, last);
           downheap(0);
       }
       return temp;
    }
    public List<T> getHeap() {
        return heap;
    }
    public void insert(T t) {
        heap.add(t);
        upheap(heap.size()-1);
    }
    public void PriorityQueue() throws Exception {
        List<T> temp=new ArrayList<>(heap);
        while (!temp.isEmpty()) {
            System.out.print(remove()+" ");
        }

    }
}
