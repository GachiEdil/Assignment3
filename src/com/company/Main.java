package com.company;
// this is the mainn class where i wrote the main function should be executed
public class Main {
    public static void main(String[] args){
        MyHashTable<String, Integer> HashTable = new MyHashTable<>();
        HashTable.add("PYTHON", 3);
        HashTable.add("POP", 1);
        HashTable.add("PYTHON", 4);
        HashTable.add("PYTHON", 2);
        HashTable.add("POP PYTHON", 1);

        System.out.println(HashTable.size());
        System.out.println(HashTable.isEmpty());
        System.out.println(HashTable.remove("PYTHON"));
        System.out.println(HashTable.remove("PYTHON"));
        System.out.println(HashTable.size());
        System.out.println(HashTable.isEmpty());
        System.out.println(HashTable.get("PYTHON"));
        /*здесь я напечатал основные функции которые я прописал в других классах
        такие, как: size, inEmpty, remove, get and etc. */
    }
}