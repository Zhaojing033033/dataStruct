package com.array.c1;

public class Test {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(5);
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        print(list);

        list.set(1,"111");
        print(list);

        list.remove(3);
        list.remove(3);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        print(list);
    }

    public  static void print(ArrayList list){
        System.out.println("------- size :"+list.size());
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
