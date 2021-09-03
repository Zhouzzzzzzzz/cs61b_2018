/*
 *
 * 双向队列基于数组实现
 *
 **/


public class ArrayDeque<T> {

    public int length = 8;//队列初始长度

    public int size = 0;

    public int first = 0;//队列左端

    public int last;//队列右端

    public Object []array;

    public ArrayDeque(){
        array = new Object[this.length];
    }

    /* 左端入列 **/
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
    public void removeFirst(){
        if(isEmpty()){
            return;
        }
        Object []temp = new Object[this.size - 1];
        for(int i = 0; i < size-1; i++){
            temp[i] = array[i+1];
        }
        this.array = temp;
        size -= 1;
    }

    /* 右端入列 **/
    public void addLast(T item) {
        if (isFull()) {
            resizeArray();
        }
        array[size] = item;
        size += 1;
    }

    /* 右端出列 **/
    public void removeLast(){
        if(isEmpty()){
            return;
        }
        Object []temp = new Object[this.size - 1];
        for(int i = 0; i < size-1; i++){
            temp[i] = array[i];
        }
        this.array = temp;
        size -= 1;
    }

    /* 判断队列是否已满 **/
    public boolean isFull(){
        return size == length;
    }

    /* 判断队列是否为空 **/
    public boolean isEmpty(){
        return size == 0;
    }

    /* 取出队列中某数 **/
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

    public int getSize(){
        return this.size;
    }

    /* 打印队列 **/
    public void printDeque(){
        if(isEmpty()){
            return;
        }
        for(int i = 0; i < size; i++){
            System.out.print(this.array[i] + " ");
        }
    }


}
