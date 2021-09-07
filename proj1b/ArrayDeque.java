/*
 *
 * 双向队列基于数组实现
 *
 **/


public class ArrayDeque<T> implements Deque<T> {

    private int length = 8;//队列初始长度

    private int size = 0;

    private int first = 0;//队列左端

    private int last;//队列右端

    private Object []array;

    public ArrayDeque(){
        array = new Object[this.length];
    }

    /* 左端入列 **/
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resizeArray();
        }
        for(int i = size; i > 0; i--){
            array[i] = array[i-1];
        }
        size += 1;
        this.array[first] = item;

    }

    /* 左端出列 **/
    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T t = (T) array[0];
        Object []temp = new Object[this.size - 1];
        for(int i = 0; i < size-1; i++){
            temp[i] = array[i+1];
        }
        this.array = temp;
        size -= 1;
        return t;
    }

    /* 右端入列 **/
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resizeArray();
        }
        array[size] = item;
        size += 1;
    }

    /* 右端出列 **/
    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T t = (T) array[size];
        Object []temp = new Object[this.size - 1];
        for(int i = 0; i < size-1; i++){
            temp[i] = array[i];
        }
        this.array = temp;
        size -= 1;
        return t;
    }

    /* 判断队列是否已满 **/
    public boolean isFull(){
        return size == length;
    }

    /* 判断队列是否为空 **/
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /* 取出队列中某数 **/
    @Override
    public T get(int index){
        if (size < index){
            System.out.print("所取元素下标超出队列长度");
        }
        T item = (T) this.array[index];
        return item;
    }

    /* 扩充数组 **/
    public void resizeArray(){
        this.length *= 2;
        Object []arrayList = new Object[this.length];
        for(int i = 0; i < size; i++){
            arrayList[i] = this.array[i];
        }
        this.array = arrayList;
    }

    @Override
    public int Size(){
        return this.size;
    }

    /* 打印队列 **/
    @Override
    public void printDeque(){
        if(isEmpty()){
            return;
        }
        for(int i = 0; i < size; i++){
            System.out.print(this.array[i] + " ");
        }
    }


}
