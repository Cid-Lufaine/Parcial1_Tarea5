import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("test del programa");
        list.printlist();
        list.addAtFront("primero ");
        list.addAtFront("segundo ");
        list.addAtTail("tercero");
        list.addAtTail("cuarto");
        list.setAt(2,"quinto");
        System.out.println("el tamaño de la lista es: "+list.getSize());
        list.printlist();
        list.addAtFront("primero ");
        list.addAtFront("primero ");
        list.addAtFront("primero ");
        list.addAtFront("primero ");
        System.out.println("el tamaño de la lista es: "+list.getSize());
        list.printlist();
        list.remove(100);
        list.remove(0);
        list.remove(8);
        list.remove(4);
        System.out.println("el tamaño de la lista es: "+list.getSize());
        list.printlist();
        list.removeAllWithValue("primero ");
        System.out.println("el tamaño de la lista es: "+list.getSize());
        list.printlist();
        list.removeAll();
        System.out.println("el tamaño de la lista es: "+list.getSize());
        list.printlist();



    }
}