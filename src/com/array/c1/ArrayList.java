package com.array.c1;

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

        if(size+1 == data.length)
            reSize(data.length*2);

        data[size++]=item;
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

}
