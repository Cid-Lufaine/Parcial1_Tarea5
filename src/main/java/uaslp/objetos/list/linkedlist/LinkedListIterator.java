package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator <T>implements Iterator {
    private Node currentNode;
    LinkedListIterator(Node head){
        currentNode = head;
    }
    public boolean hasNext(){

        return currentNode!=null ;
    }
    public T next(){
        T data = (T)currentNode.data;
        currentNode=currentNode.next;
        return data;
    }

}
