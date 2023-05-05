package uaslp.objetos.list.ArrayList;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList <T> implements List {
    private static final int INITIAL_SIZE = 2;
    private T[] array;
    private int size;


    public ArrayList() {
        array = (T[]) new List [INITIAL_SIZE];
    }

    public void addAtTail(Object data) throws NotNullAllowedException {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = (T[]) newArray;
        }
        if(data == null )
        {
            throw new NotNullAllowedException() ;
        }else {
            array[size] = (T) data;
            size++;
        }
    }

    public void addAtFront(Object data)  throws NotNullAllowedException{
        if(data==null){
            throw new NotNullAllowedException() ;
        }else {


            int newSize;
            if (size == array.length) {
                newSize = array.length * 2;
            } else {
                newSize = array.length;
            }
            Object[] newArray = new Object[newSize];

            newArray[0] = data;
            for (int i = 0; i < size; i++) {
                newArray[i + 1] = array[i];
            }
            array = (T[]) newArray;
            size++;
        }
    }


    public void remove(int index) throws BadIndexException {
        if (index >= 0 && index < size) {
            size--;
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size] = null; //necessary?
        }else {
             throw new BadIndexException() ;
        }
    }

    public void removeAll() {
        size = 0;
        array = (T[]) new List [INITIAL_SIZE];
        //taking advantage of garbage collectors
    }


    public void setAt(int index, Object data) throws BadIndexException, NotNullAllowedException {
        if(data == null)
        {
            throw new NotNullAllowedException();
        }
        if (index < 0 || index > size) {
            throw new BadIndexException();
        }
        if (index > 0 || index < size) {
            array[index] = (T)data;
        }
        return;
    }

    public T getAt(int index) throws BadIndexException{
        T answer;
        if (index > 0 || index < size) {
            answer = array[index];
        } else {
            throw  new BadIndexException();
        }
        return answer;
    }

    public void removeAllWithValue(Object data) {
        T[] newArray = (T[]) new List [INITIAL_SIZE];
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

    public boolean isEmpty() {
        if(getSize()==0){
            return true;
        }else{
            return false;
        }
    }

    public Iterator getIterator(){
        return new ArrayListIterator(array);
    }

    public void printList() {

        if(size!=0){

            Iterator iterator = getIterator();
            while (iterator.hasNext()){
                T data_list = (T) iterator.next();
                System.out.print(data_list+" ");
            }
            System.out.println();
        }else{
            System.out.println("Empty list");
        }
    }


}
