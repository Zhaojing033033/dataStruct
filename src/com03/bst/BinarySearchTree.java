package com03.bst;

import com02.linked.list.LinkedList;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * create by zhaojing at 2019/7/27 17:00
 * function :
 */
public class BinarySearchTree<E extends Comparable> {

    private Node root;
    int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public void add(E e){
       root= add(root,e);
    }
    private Node add(Node curr,E e){
        if(curr == null){
            size++;
            return new Node(e);
        }
        else if(e.compareTo(curr.e) < 0)
           curr.left= add(curr.left,e);
        else if(e.compareTo(curr.e) > 0)
            curr.right=add(curr.right,e);
        return curr;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    public boolean contains(Node node,E e){
        if(node == null)return false;

        if(e.compareTo(node.e)== 0)
            return true;
        else if(e.compareTo(node.e) < 0 )
            return contains(node.left,e);
        else if(e.compareTo(node.e)>0)
            return contains(node.right,e);
        return false;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null) return;

        preOrder(node.left);

        System.out.println(node.e);

        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null) return;

        System.out.println(node.e);

        inOrder(node.left);

        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.right);
        postOrder(node.left);
        System.out.println(node.e);
    }


    public void levelPrint(){
        LinkedList<Node> queue = new LinkedList<>();

        levelPrint(root,queue);

    }
    public void levelPrint(Node node,LinkedList<Node> queue){
        if(node == null)
            return;
        while (!queue.isEmpty()){
            Node first = queue.getFirst();
            System.out.println(first.e);

            if(first.left !=  null)
                queue.addFirst(first.left);

            if(first.right !=  null)
                queue.addFirst(first.right);
        }
    }

    public void remove(E e){
        root =  remove(root,e);
    }

    public Node remove(Node node,E e){
        if( node == null )
            return null;

        if(e.compareTo(node.e) < 0 ){
            node.left=remove(node.left,e);
            return  node;
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return  node;
        }else{

            if(node.left==null){
                Node rightNode =  node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode =  node.left;
                node.left=null;
                size--;
                return leftNode;
            }

            Node miniNumNode = miniNum(node.right);
            miniNumNode.left=node.left;
            miniNumNode.right=removeMiniNum(node.right);
            node.e=miniNumNode.e;

            return  miniNumNode;
        }

    }

    private Node removeMiniNum(Node node) {

        if(node.left == null){
            Node right = node.right;
            node.right=null;
            size--;
            return  right;
        }
        node.left= removeMiniNum(node.left);
        return node;

    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return miniNum(root).e;
    }

    public Node miniNum(Node node){
        if(node.left == null){
            if(node.right == null){
                return node;
            }else{
                return miniNum(node.right);
            }
        }else{
            return miniNum(node.left);
        }
    }


    class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.left=null;
            this.right=null;
            this.e = e;
        }
    }


}
