package uaslp.objetos.list.ArrayList;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator {
    String[] array;
    private int index;
    ArrayListIterator(String []array){
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
    public String next(){

        String data = array[index];
        index++;
        return data;
    }

}
