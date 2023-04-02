package org.alejandroArias.application;


import org.alejandroArias.model.CircularList;

public class Application {


    public static void main(String[] args) {

        CircularList<Integer> circularList = new CircularList<>();

        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);
        circularList.add(6);


        circularList.print();
        circularList.reverse();
        circularList.print();
        CircularList<Integer> circularList1 = new CircularList<>();
        circularList1.add(7);
        circularList1.add(8);
        circularList1 = circularList.merge(circularList1);
        circularList1.print();

        circularList.remove(3);
        circularList.print();

        Integer data = circularList.search(2);
        System.out.println(data);


    }
}
