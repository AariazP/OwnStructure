package org.alejandroArias.application;

import org.alejandroArias.model.LinkedList;

public class Application {


    public static void main(String[] args) {

        // verify that LinkedList is working
        //verify all methods of LinkedList

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list);

        list.add(0, 0);
        list.add(11, 11);
        list.add(5, 5);

        System.out.println(list);


        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.get(11));

        list.remove(0);
        list.remove(5);
        //list.remove(11);

        System.out.println(list);





    }
}
