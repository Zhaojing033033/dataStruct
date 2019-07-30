package com01.array.list;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(5);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.remove(4);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);
    }
}
