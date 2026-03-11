package com.sveta.collections.list;

import java.util.List;

public class ListDemo {
    static void main(String[] args){
        List<String> list = new MyArrayList(args);
        list.add("Potato");
        list.add("Salat");
        list.add("Cucumber");
        System.out.println(list);
        list.set(2,"Carrot");
        System.out.println(list.get(2));
        list.clear();
        System.out.println(list);

        list.add("Potato");
        list.add("Salat");
        list.add("Cucumber");
        System.out.println(list.size());
        System.out.println(list.contains("Salat"));
        System.out.println(list.contains("meat"));
        list.remove("Potato");
        System.out.println(list);
        System.out.println(list.indexOf("Cucumber"));
    }
}
