package uaslp.objetos.list.ArrayList;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class ArrayList implements List {
    private static final int INITIAL_SIZE = 2;
    private String[] array;
    private int size;


    public ArrayList() {
        array = new String[INITIAL_SIZE];
    }

    public void addAtTail(String data) {
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = data;
        size++;
    }

    public void addAtFront(String data) {
        int newSize;
        if (size == array.length) {
            newSize = array.length * 2;
        } else {
            newSize = array.length;
        }
        String[] newArray = new String[newSize];
        newArray[0] = data;
        for (int i = 0; i < size; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            size--;
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null; //necessary?
        }else {
            System.out.println("index "+ index +" out of range");
        }
    }

    public void removeAll() {
        size = 0;
        array = new String[INITIAL_SIZE];
        //taking advantage of garbage collectors
    }

    public void setAt(int index, String data) {
        if (index > 0 || index < size) {
            array[index] = data;
        }
    }

    public String getAt(int index) {
        String answer;
        if (index > 0 || index < size) {
            answer = array[index];
        } else {
            answer = null;
        }
        return answer;
    }

    public void removeAllWithValue(String data) {
        String[] newArray = new String[array.length];
        int newSize=0;
        for(int i =0;i<size;i++)
        {
            if(array[i]!=data){
                newArray[newSize]=array[i];
                newSize++;
            }
        }
        array=newArray;
        size=newSize;
    }
    public int getSize() {return size;}

    public Iterator getIterator(){
        return new ArrayListIterator(array);
    }

    public void printList() {

        if(size!=0){

            Iterator iterator = getIterator();
            while (iterator.hasNext()){
                String data_list = iterator.next();
                System.out.print(data_list+" ");
            }
            System.out.println();
        }else{
            System.out.println("Empty list");
        }
    }


}
