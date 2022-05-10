package com.company;
import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable <K,V> {
    private ArrayList<HashNode<K,V>> containerArray; // массив с цепочкой узлов; K - ключ, V - значение; массив с цепочкой узлов; K - ключ, V - значение;
    private int numContainers; // вместимость списка

    private int sizesize; // фактическое количество или размер элементов фактическое количество или размер элементов

    public MyHashTable(){
        containerArray = new ArrayList<>();
        numContainers = 10;
        sizesize = 0;

        for (int i = 0; i < numContainers; i++){
            containerArray.add(null); // заполнение пустого массива нулевыми элементами заполнение пустого массива нулевыми элементами
        }
    }

    // здесь мы прописываем геттеры
    public int size(){
        return sizesize;
    }

    // isEmpty() - проверка пусто или нет -> возврат true или false
    public boolean isEmpty(){
        return size() == 0;
    }

    public final int hashCode(K keykey){
        return Objects.hashCode(keykey);
    }

    // здесь я написал геттер для индекса элемента массива, чтобы он возвращал индекс этого самого элемента
    private int getBucketIndex(K keykey){
        int hashCode = hashCode(keykey);
        int index = hashCode % numContainers;

        index = (index < 0) ? index * (-1) : index; // проверка индекса - если индекс отрицательный, умножение на (-1) проверка индекса - если индекс отрицательный, умножение на (-1)
        return index;
    }

    // здесь я написал функцию которая удаляет элемент в массиве
    // remove() - удалить элемент
    public V remove (K keykey){
        int bucketIndex = getBucketIndex(keykey);
        int hashCode = hashCode(keykey);

        HashNode<K,V> head = containerArray.get(bucketIndex);

        HashNode<K,V> previousel = null; // дополнительный узел для соединения предыдущего узла с текущим узлом дополнительный узел для соединения предыдущего узла с текущим узлом
        while (head != null){
            if (head.keykey.equals(keykey) && hashCode == head.hashCode){
                break;
            }

            previousel = head;
            head = head.next;
        }

        if (head == null){
            return null;
        }

        sizesize--;

            if (previousel != null) {previousel.next = head.next;} // если элемент расположен посередине
        else {containerArray.set(bucketIndex, head.next);} // если элемент расположен вначале
        return head.valuevalue;
    }

    // get() -получение значения элемента с помощью ключа. получение значения элемента с помощью ключа.
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K,V> head = containerArray.get(bucketIndex); // начиная с head и получая указатель на первый элемент внутри bucket
        while (head != null){
            if (head.keykey.equals(key) && head.hashCode == hashCode) // проверка ключа с помощью хэш-кода, потому что ключи могут совпадать с другим элементом
             {return head.valuevalue;}

            head = head.next;
        }

        return null;
    }

    // здесь я написал функцию которая добавляет элемент в массив
    // add() - прибавление элемента
    public void add(K keykey, V valuevalue){
        int bucketIndex = getBucketIndex(keykey);
        int hashCode = hashCode(keykey);
        HashNode<K,V> head = containerArray.get(bucketIndex);

        while(head != null){
            if (head.keykey.equals(keykey) && head.hashCode == hashCode){
                head.valuevalue = valuevalue;
                return;
            }
            head = head.next;
        }

        sizesize++;
        head = containerArray.get(bucketIndex);
        HashNode<K,V> newNode = new HashNode<K,V>(keykey, valuevalue, hashCode);
        newNode.next = head;
        containerArray.set(bucketIndex, newNode);

        //здесь я написал функцию которая увеличивает емкость массива
        //увеличение емкости массива, если заполнено 70% массива
        if ((1.0 * sizesize) / numContainers >= 0.7){
            ArrayList<HashNode<K,V>> temp = containerArray;
            containerArray = new ArrayList<>();
            numContainers = 2 * numContainers;
            sizesize = 0;
            for (int i = 0; i < numContainers; i++){
                containerArray.add(null);
            }

            for (HashNode<K,V> headNode:temp){
                while(headNode != null){
                    add(headNode.keykey, headNode.valuevalue);
                    headNode = headNode.next;
                }
            }
        }
    }
}