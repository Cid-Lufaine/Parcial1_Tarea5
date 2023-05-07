package uaslp.objetos.list.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;
import uaslp.objetos.list.linkedlist.LinkedList;


public class ArrayListTest {
    @Test
    public void removinWhitValue(){
        List<Object> list2 = new ArrayList<>();
        list2.addAtFront(1);;
        list2.addAtTail(2);
        list2.addAtTail(3);
        list2.addAtTail(4);
        list2.addAtTail(5);
        list2.addAtTail(6);
        list2.addAtTail(7);
        list2.addAtTail(8);
        list2.addAtTail(9);
        list2.addAtTail(10);
        list2.addAtTail(11);
        list2.addAtTail(12);
        list2.addAtTail(13);
        list2.addAtTail(14);
        list2.addAtTail(15);
        list2.addAtTail(16);
        list2.addAtTail(17);
        list2.addAtTail(18);

        list2.removeAllWithValue(18);

        list2.printList();




    }
    @Test
    public  void whenListIsCreated_ItIsEmpty(){
        //Inicializacion
        List<Object> list2 = new ArrayList<>();
        //Ejecucion
        Assertions.assertTrue(list2.isEmpty());
        //Validacion

    }
    @Test
    public  void whenListIsCreated_and_One_Element_is_IncertedAtFront_ItIsNOTEmpty(){
        //Inicializacion
        List<Object> list2 = new ArrayList<>();
        list2.printList();
        //Ejecucion
        try{
            list2.addAtFront("2");

        }catch (NotNullAllowedException exception) {

        }
        //Validacion
        Assertions.assertFalse(list2.isEmpty());
    }
    @Test
    public  void whenListIsCreated_and_One_Element_is_IncertedAtTail_ItIsNOTEmpty(){
        //Inicializacion
        List<Object> list1 = new ArrayList<>();
        //Ejecucion
        try{
            list1.addAtTail("2");

        }catch (NotNullAllowedException exception) {

        }
        //Validacion
        Assertions.assertFalse(list1.isEmpty());
    }
    @Test
    public  void incertin_null_values_exceptions_must_be_trown(){
        //Inicializacion
        List<Object> list1 = new ArrayList<>();
        //Ejecucion
        try{
            list1.addAtTail(null);

        }catch (NotNullAllowedException exception) {

        }
        try{
            list1.addAtFront(null);

        }catch (NotNullAllowedException exception) {

        }
        //Validacion
        Assertions.assertThrowsExactly(NotNullAllowedException.class, ()-> list1.addAtFront(null));
        Assertions.assertThrowsExactly(NotNullAllowedException.class, ()-> list1.addAtTail(null));
    }

    @Test
    public  void multiples_objects_are_adeded_size_must_be_10(){
        List<Object> list1 = new ArrayList<>();
        list1.addAtTail(1);
        list1.addAtTail(1);
        list1.addAtTail(1);
        list1.addAtTail(1);
        list1.addAtFront(1);
        list1.addAtFront(1);
        list1.addAtFront(1);
        list1.addAtFront(1);
        list1.addAtFront(1);
        list1.addAtFront(1);
        list1.printList();

        Assertions.assertEquals(10,list1.getSize());
    }
    @Test
    public  void multiples_objects_are_adeded_and_deleted_size_must_be_2_and_printed(){
        List<Object> list1 = new ArrayList<>();
        list1.addAtFront(1);
        list1.addAtFront(2);
        list1.addAtFront(3);
        list1.addAtFront(4);
        list1.addAtFront(5);
        list1.addAtFront(6);
        list1.addAtTail(7);
        list1.addAtTail(7);
        list1.addAtTail(7);
        list1.addAtTail(7);
        //
        list1.remove(0);
        list1.remove(0);
        list1.remove(0);
        list1.remove(0);
        list1.removeAllWithValue(7);
        list1.printList();

        Assertions.assertEquals(2,list1.getSize());
        list1.removeAll();
        Assertions.assertEquals(0,list1.getSize());
    }
    @Test
    public  void multiples_objects_are_adeded_and_deleted_from_the_midle(){
        List<Object> list1 = new ArrayList<>();
        list1.addAtFront(1);
        list1.addAtFront(2);
        list1.addAtFront(3);
        list1.addAtFront(4);
        list1.addAtFront(5);
        list1.addAtFront(6);
        list1.addAtTail(7);
        list1.addAtTail(8);
        list1.addAtTail(9);
        list1.addAtTail(10);
        //
        list1.remove(0);
        list1.remove(1);
        list1.remove(2);
        list1.remove(6);

        Assertions.assertEquals(6,list1.getSize());
        list1.removeAll();
        Assertions.assertEquals(0,list1.getSize());
    }
    @Test
    public  void in_a_list_try_to_remobe_bad_index_and_trow_exceptions(){
        List<Object> list1 = new ArrayList<>();
        list1.addAtFront(1);
        list1.addAtFront(2);
        list1.addAtFront(3);
        list1.addAtFront(4);
        list1.addAtFront(5);
        list1.addAtFront(6);
        list1.addAtTail(7);
        list1.addAtTail(8);
        list1.addAtTail(9);
        list1.addAtTail(10);
        //
        try {
            list1.remove(11);
        }catch (BadIndexException exception){

        }
        Assertions.assertEquals(10,list1.getSize());
        Assertions.assertThrows(BadIndexException.class,()->list1.remove(11));
    }
    @Test
    public  void in_a_list_of_size10_change_someValues(){
        List<Object> list1 = new ArrayList<>();
        list1.addAtFront(1);
        list1.addAtFront(2);
        list1.addAtFront(3);
        list1.addAtFront(4);
        list1.addAtFront(5);
        list1.addAtFront(6);
        list1.addAtTail(7);
        list1.addAtTail(8);
        list1.addAtTail(9);
        list1.addAtTail(10);
        //
        try {
            list1.setAt(0,0);
            list1.setAt(9,9);
            list1.setAt(5,5);
            list1.setAt(11,11);
        }catch (BadIndexException exception){

        }catch (NotNullAllowedException exception){

        }
        try {
            list1.setAt(2,null);
        }catch (BadIndexException exception){

        }catch (NotNullAllowedException exception){

        }

        Assertions.assertEquals(10,list1.getSize());
        Assertions.assertThrows(BadIndexException.class,()->list1.setAt(11,11));
        Assertions.assertThrows(NotNullAllowedException.class,()->list1.setAt(5,null));
    }
    @Test
    public  void in_a_list_of_size10_getsomevalues() {
        List<Object> list1 = new ArrayList<>();
        list1.addAtFront(1);
        list1.addAtFront(2);
        list1.addAtFront(3);
        list1.addAtFront(4);
        list1.addAtFront(5);
        list1.addAtFront(6);
        list1.addAtTail(7);
        list1.addAtTail(8);
        list1.addAtTail(9);
        list1.addAtTail(10);
        try{
            list1.getAt(0);
            list1.getAt(9);
            list1.getAt(5);
            list1.getAt(15);
        }catch (BadIndexException ex){

        }
        Assertions.assertEquals(10,list1.getAt(9));
        Assertions.assertEquals(6,list1.getAt(0));


        Assertions.assertThrows(BadIndexException.class,()->list1.getAt(15));

    }
    @Test
    public  void inAnListDeleteMultiple_values_by_vallue(){
        List<Object> list1 = new LinkedList<>();
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(1);
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(5);
        list1.addAtFront(1);
        list1.addAtFront(5);
        list1.addAtFront(5);
        //
        list1.removeAllWithValue(1);
        list1.removeAllWithValue(5);
        list1.printList();

        Assertions.assertEquals(0,list1.getSize());

    }
    @Test
    public void forcingthenewarraycreationinremovewhitvalue(){
        List<Object> list1 = new LinkedList<>();
        list1.printList();

    }

}
