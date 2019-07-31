package com02.linked.list;

import com.sun.org.apache.regexp.internal.RE;

/**
 * create by zhaojing at 2019/7/27 15:39
 * function :
 */
public class LinkedList <T>{

    Node dynnyHead;
    int size;

    public LinkedList() {
        dynnyHead = new Node(null);
        this.size = 0;
    }

    public void add(int index,T val){

        Node preNode = dynnyHead;

        for (int i = 0; i < index; i++)
            preNode=preNode.next;

        preNode.next= new Node(val,preNode.next);

        size++;
    }

    public void addFirst(T val){
        add(0,val);
    }

    public void addLast(T val){
        add(size,val);
    }

    public T remove(int index ){
        Node prev=dynnyHead;

        for (int i = 0; i < index; i++)
            prev=prev.next;

        Node removeNode = prev.next;

        prev.next=prev.next.next;
        size--;

        return removeNode.val;

    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    public void set(int index,T val){

        Node prev=dynnyHead;

        for (int i = 0; i < index; i++)
            prev=prev.next;

        prev.next.val=val;

    }


    public T get(int index){
        Node prev=  dynnyHead;

        for (int i = 0; i < index; i++)
            prev=prev.next;

        return prev.next.val;

    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size-1);
    }

    public boolean contains(T val){
        Node curr=dynnyHead.next;
        if(curr != null)
            return contains(curr,val);
        return false;
    }

    private boolean contains(Node curr,T val){
        if(curr.val.equals(val))
            return true;
        else{
            if(curr.next!=null)
                return contains(curr.next,val);
            else
                return false;
        }

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dynnyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    class Node{
        public T val;
        public Node next;
        public Node(T t, Node next) {
            this.val = t;
            this.next = next;
        }
        public Node(T val){
            this(val,null);
        }

        public T getVal() {
            return val;
        }


        public Node getNext() {
            return next;
        }


        @Override
        public String toString() {
            return val.toString();
        }
    }
}
