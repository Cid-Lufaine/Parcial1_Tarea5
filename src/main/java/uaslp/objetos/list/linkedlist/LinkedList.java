package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList <T>implements List {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void addAtTail(Object data) throws NotNullAllowedException {
        if( data == null) {
            throw new NotNullAllowedException();
        }


        Node node = new Node();
        node.data=data;
        if(head==null) {
            head=node;
        }else
        {
            node.previous=tail;
            tail.next=node;
        }
        tail=node;
        size++;
    }
    public void addAtFront(Object data) throws NotNullAllowedException{
        if( data == null) {
            throw new NotNullAllowedException();
        }

        Node node = new Node();
        node.data=data;
        if(tail==null) {
            tail=node;
        }else
        {
            node.next=head;
            head.previous=node;
        }
        head=node;
        size++;
    }
    public void remove(int index) throws BadIndexException {
        if(index<0 || index>= size){
            throw new BadIndexException();
        }else{

            if(index==0||index==size-1) {
                if(index==0){
                    Node NodeAtHead=head;
                    head=head.next;
                    head.previous=null;

                    //para que sea aislado y eliminado por recolector?
                    NodeAtHead.next=null;
                    NodeAtHead.previous=null;

                }else{
                    Node NodeAtTail=tail;
                    tail=tail.previous;
                    tail.next=null;

                    //para que sea aislado y eliminado por recolector?
                    NodeAtTail.next=null;
                    NodeAtTail.previous=null;
                }
            }else {
                Node currentNode=head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }

                Node previousNode=currentNode.previous;
                Node nextNode=currentNode.next;

                previousNode.next=nextNode;
                nextNode.previous=previousNode;

                //para que sea aislado y eliminado por recolector?
                currentNode.previous=null;
                currentNode.next=null;

            }
            size--;
        }
    }
    public void removeAll(){
        head=null;
        tail=null;
        size=0;

        //all the nodes are cleaned by the recolector?
    }
    public void setAt(int index, Object data) throws BadIndexException, NotNullAllowedException{
        if( data == null) {
            throw new NotNullAllowedException();
        }

        if(index<0 || index> size){
            throw new BadIndexException();
        }else{

            if(index==0||index==size) {
                if(index==0){
                    head.data=data;
                }else{
                    tail.data=data;
                }
            }else {
                Node currentNode=head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }
                currentNode.data= data;
            }
        }

    }

    public T getAt(int index) throws BadIndexException {
        if(index<0 || index >= size ){
            throw  new BadIndexException();
        }
        Node currentNode=head;
        for( int current_index=0; current_index < index; current_index++)
        {
            currentNode=currentNode.next;
        }
        return (T)currentNode.data;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty() {
        if(getSize()==0){
            return true;
        }else{
            return false;
        }
    }

    public Iterator getIterator(){
        return new LinkedListIterator(head);
    }

    public void removeAllWithValue(Object data){
        Node currentNode=head;
        for( int current_index=0; current_index < size; current_index++) {

            if (currentNode.data == data) {


                Node previousNode = currentNode.previous;
                Node nextNode = currentNode.next;

                if (previousNode != null) {
                    previousNode.next = nextNode;
                } else {
                    head = nextNode;
                }
                if (nextNode != null) {
                    nextNode.previous = previousNode;
                } else {
                    tail = previousNode;
                }
                size--;
                //para que sea aislado y eliminado por recolector?
                currentNode.previous = null;
                currentNode.next = null;
                //retomando la exploracion de la lista
                currentNode = nextNode;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public void printList() {

        if(head!=null){

            Iterator iterator = getIterator();
            while (iterator.hasNext()){
                T data_list = (T) iterator.next();
                System.out.println(data_list);
            }
        }else{
            System.out.println("Empty list");
        }
    }



}
