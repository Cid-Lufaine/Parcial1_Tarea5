package uaslp.objetos.list.ArrayList;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator <T> implements Iterator {
    T[] array;
    private int index;
    ArrayListIterator(T []array){
        index = 0;
        this.array=array;
    }
    public boolean hasNext(){
        if(index< array.length)
        {
            return array[index]!=null;
        }else {
            return false;
        }

    }
    public T next(){

        T data = array[index];
        index++;
        return data;
    }

}
