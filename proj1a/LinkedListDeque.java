/*
 *
 * 双向队列基于链表实现
 *
 **/
public class LinkedListDeque <T>{

    private class Node<T>{
        private T item;
        private Node<T> next;
        private Node<T> pre;
        private Node(T item){
            this.item = item;
        }
    }

    private Node first;//左节点
    private Node last;//右节点
    private int size;//长度

    public LinkedListDeque(){
        Node first = new Node(null);
        Node last = new Node(null);
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item){
        if(isEmpty()){
            first = new Node(item);
            last = first;
        }else{
            Node oldfirst = first;
            first = new Node(item);
            first.next = oldfirst;
            oldfirst.pre = first;
        }
        size += 1;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }else{
            T t = (T) first.item;
            first = (Node) first.next;
            size -=1;
            return t;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }else{
            T t = (T) last.item;
            last = (Node) last.pre;
            last.next = null;
            size -=1;
            return t;
        }
    }

    public void addLast(T item){
        if(isEmpty()){
            last = new Node(item);
            first = last;
        }else{
            Node oldlast = last;
            last = new Node(item);
            last.pre = oldlast;
            oldlast.next = last;
        }
        size += 1;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(size < index){
            return null;
        }
        Node p = first;
        while(index > 0){
            p = p.next;
            index -= 1;
        }
        return (T) p.item;
    }

    public T getRecursive(int index){
        if (size < index){
            return null;
        }
        return (T) getRecursive(first, index);
    }

    private T getRecursive(Node node, int i){
        if(i == 0){
            return (T) node.item;
        }
        return (T) getRecursive(node.next, i-1);

    }


    public void printDeque(){
        if(isEmpty()){
            return;
        }
        Node p = first;
        while(p != null){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }


}
