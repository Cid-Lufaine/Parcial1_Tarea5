package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void addAtTail(String data){
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
    public void addAtFront(String data){
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
    public void remove(int index){
        if(index<0 || index> size){
            System.out.println("index out of range");
        }else{

            if(index==0||index==size) {
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
    public void setAt(int index, String data){
        //asumiendo que setAt es una insercion, no una sobre escritura de "data"
        if(index<0 || index> size){
            System.out.println("index out of range");
        }else{

            if(index==0||index==size) {
                if(index==0){
                    addAtFront(data);
                }else{
                    addAtTail(data);
                }
            }else {
                Node currentNode=head;
                for (int current_index = 0; current_index < index; current_index++) {
                    currentNode = currentNode.next;
                }

                Node previousNode=currentNode.previous;

                Node NewNode= new Node();
                NewNode.data=data;

                previousNode.next=NewNode;
                NewNode.previous=previousNode;

                NewNode.next=currentNode;
                currentNode.previous=NewNode;

            }
            size++;
        }

    }
    public String getAt(int index) {
        if(index<0 || index >= size ){
            return null;
        }
        Node currentNode=head;
        for( int current_index=0; current_index < index; current_index++)
        {
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    public int getSize(){
        return this.size;
    }
    public LinkedListIterator getIterator(){
        return new LinkedListIterator(head);
    }
    public void removeAllWithValue(String data){
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

    public void printlist() {

        if(head!=null){

            LinkedListIterator iterator = getIterator();
            while (iterator.hasNext()){
                String data_list = iterator.next();
                System.out.println(data_list);
            }
        }else{
            System.out.println("Empty list");
        }
    }



}
