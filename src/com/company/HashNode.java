package com.company;
//there i created nodes
public class HashNode <K,V> {
    K keykey;
    V valuevalue;
    final int hashCode;

    HashNode<K,V> next;

    public HashNode(K keykey, V valuevalue, int hashCodehashCode){
        this.keykey = keykey;
        this.valuevalue = valuevalue;
        this.hashCode = hashCodehashCode;
    }
}