
public class MyBinST<K extends Comparable<K>,V> {
    private BSTNode start;


    public void put(K key, V value){
        BSTNode node = new BSTNode(key, value);
        if(start != null){
            BSTNode cursor = start;
            while(true){
                if(cursor.key.compareTo(key)>0){
                    if(cursor.leftChild == null){
                        cursor.leftChild = node;

                        break;
                    }else{
                        cursor = cursor.leftChild;
                    }


                }else{

                    if(cursor.rightChild == null){
                        cursor.rightChild = node;

                        break;
                    }else{
                        cursor = cursor.rightChild;

                    }

                }
            }
        }else{
            start = node;

        }
    }

    public void check(){
        System.out.println(start.value);
        System.out.println(start.leftChild.value);
    }
    public void getMin(){
        getMin(start);
    }
    public BSTNode getMin(BSTNode start) {
        if (start.leftChild == null)
            return start;
        else {
            return getMin(start.leftChild);
        }
    }

    public BSTNode getMax(BSTNode start) {
        if (start.leftChild == null)
            return start;
        else {
            return getMax(start.leftChild);
        }
    }

    public BSTNode remove(BSTNode start, K key) {
        if (start == null)
            return null;
        if (start.key.compareTo(key) > 0) {
            start.leftChild = remove(start.leftChild, key);
        } else if (start.key.compareTo(key) < 0) {
            start.rightChild = remove(start.rightChild, key);

        } else {

            if (start.leftChild != null && start.rightChild != null) {
                BSTNode temp = start;

                BSTNode minNode = getMin(temp.rightChild);

                start.key = minNode.key;

                start.rightChild = remove(start.rightChild, minNode.key);

            }

            else if (start.leftChild != null) {
                start = start.leftChild;
            }

            else if (start.rightChild != null) {
               start = start.rightChild;
            }

            else
                start = null;
        }
        return start;
    }

    public V getValue(K key){
        if(start.key == key){
            return start.value;
        }else{
            BSTNode cursor = start;
            while(true){
                if(cursor.key.compareTo(key)>0){
                    cursor = cursor.leftChild;
                }else if(cursor.key.compareTo(key)==0){
                    return cursor.value;
                }else if(cursor.key.compareTo(key) < 0){
                    cursor = cursor.rightChild;
                }
            }
        }
    }

    public void display(){
        inorderRec(start);
    }

    void inorderRec(BSTNode node)
    {
        if (node != null) {
            inorderRec(node.leftChild);
            System.out.print(node.value + " ");
            inorderRec(node.rightChild);
        }
    }



    private class BSTNode{
        private K key;
        private V value;
        private BSTNode leftChild, rightChild;
        private BSTNode(K key, V value){
            this.key = key;
            this .value = value;
        }
    }
}
