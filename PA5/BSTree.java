import java.util.Iterator;
import java.util.LinkedList;

public class BSTree<T extends Comparable<? super T>> implements Iterable {

    private int nelems;
    private BSTNode root;

    protected class BSTNode {

        T key;
        LinkedList<T> dataList;
        BSTNode left;
        BSTNode right;

        public BSTNode(BSTNode left, BSTNode right, LinkedList<T> dataList, T key) {
            //TODO
        }

        public BSTNode(BSTNode left, BSTNode right, T key) {
            //TODO
        }

        public T getKey() {
            //TODO
            return null;
        }

        public BSTNode getLeft() {
            //TODO
            return null;
        }

        public BSTNode getRight() {
            //TODO
            return null;
        }

        public LinkedList<T> getDataList() {
            //TODO
            return null;
        }

        public void setleft(BSTNode newleft) {
            //TODO
        }

        public void setright(BSTNode newright) {
            //TODO
        }

        public void setDataList(LinkedList<T> newData) {
            //TODO
        }

        public void addNewInfo(T data) {
            //TODO
        }

        public boolean removeInfo(T data) {
            //TODO
            return false;
        }
    }

    public BSTree() {
        //TODO
    }

    public BSTNode getRoot() {
        //TODO
        return null;
    }

    public int getSize() {
        //TODO
        return 0;
    }

    public boolean insert(T key) {
        //TODO
    }

    public boolean findKey(T key) {
        //TODO
        return false;
    }

    public void insertData(T key, T data) {
        //TODO;
    }

    public LinkedList<T> findDataList(T key) {
        //TODO
        return null;
    }

    public int findHeight() {
        //TODO
        return 0;
    }

    public int leafCount() {
        //TODO
        return 0;
    }

    //******************ITERATOR STARTS HERE!!!********************************
    public class BSTree_Iterator implements Iterator<T> {

        public BSTree_Iterator() {
            //TODO
        }

        public boolean hasNext() {
            //TODO
            return false;
        }

        public T next() {
            //TODO
            return null;
        }
    }

    public Iterator<T> iterator() {
        //TODO
        return null;
    }
}
