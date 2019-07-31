package com01.array.list;

import java.util.Arrays;

public class ArrayList<T> {
    private T [] data;
    private int size;


    public ArrayList(int capacity) {
        this.size = 0;
        data =(T[])new Object[capacity];
    }

    public ArrayList() {
        this(10);
    }

    public void add(T item){
        add(size++,item);
    }

    public void add(int index,T item){
        if(size+1 == data.length)
            reSize(data.length*2);
        data[index]=item;
        size++;
    }

    public void addFirst(T e){
        add(0,e);
    }

    public void addLast(T e){
        add(size,e);
    }

    public int size(){
        return this.size;
    }

    public T get(int index){

        if(index < 0 || index >=size)
            throw new RuntimeException("out of index");

        return data[index];

    }

    public T set(int index,T item){

        if(index < 0 || index >=size)
            throw new RuntimeException("out of index");

        T old = data[index];

        data[index]=item;

        return  old;

    }

    public T remove(int index ){

        if(index < 0 || index >=size)
            throw new RuntimeException("out of index");

        T old = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }

        size--;

        if(data.length / 4 == size && data.length/2 != 0)
            reSize(data.length/2);

        return old;

    }


    public void reSize(int newSize){
        int capacity = data.length;
        System.out.println("reCapacity "+capacity+" ->"+newSize );
        data=Arrays.copyOf(data, newSize);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
