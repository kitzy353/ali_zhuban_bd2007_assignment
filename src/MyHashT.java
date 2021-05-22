public class MyHashT<K extends Comparable<K>,V> {
    private class MyNode<K,V>{
        private K key;
        private V value;
        MyNode<K,V> next;
        public MyNode(K key, V value){
            this.value = value;
            this.key = key;
        }
    }
    private int buckets = 10;
    private MyNode<K,V>[] myNodes = new MyNode[buckets];
    private int size;

    public MyHashT(){

    }

    public MyHashT(int buckets){
        this.buckets = buckets;
        myNodes = new MyNode[buckets];
    }

    public int getHash(K key){
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

    public void put(K key, V value){
        MyNode<K,V> node = new MyNode<>(key,value);
        int k = getHash(key);
        if(myNodes[k]!= null){
            MyNode<K,V> cursor =myNodes[k];
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = node;
        }else{
            myNodes[k] = node;
        }
        size++;
    }

    public V remove(K key){
        MyNode<K,V> cursor;
        int k = getHash(key);
        cursor = myNodes[k];
        if(cursor.key == key){ //checking if our key is the first element of bucket
            MyNode<K,V> temp = cursor; // to save our value
            myNodes[k] = cursor.next;
            return temp.value; // returning that saved node's value
        }
        while(cursor.next.key != key){ //if its not the first element
            cursor = cursor.next;
        }
        MyNode<K,V> temp = cursor.next; //saving node
        cursor.next = cursor.next.next;
        size--;
        return temp.value; //returning saved node's value
    }

    public boolean contains(V value){
        for(int i = 0; i < buckets; i++){
            MyNode<K,V> cursor = myNodes[i];
            while(cursor!=null){
                if(cursor.value == value){
                    return true;
                }else{
                    cursor = cursor.next;
                }
            }
        }
        return false;
    }


    public V get(K key){
        int k = getHash(key);
        MyNode<K,V> cursor =myNodes[k];
        while(cursor!=null){
            if(cursor.key == key){
                return cursor.value;
            }else{
                cursor = cursor.next;
            }
        }
        return null;
    }


}
