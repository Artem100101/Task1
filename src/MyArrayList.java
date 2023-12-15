import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T>{
    private Object[] array = new Object[10];
    private int size = 0;

    public T get(int index) {
        if(index < 0 || index >= size){
            checkIndex(index);
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public boolean add(T list) {
        increaseArray();
        array[size] = list;
        size++;
        return true;
    }

    public boolean add(T list, int index) {
        increaseArray();
        for (int i =size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = list;
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends T> collections) {
        for (T el : collections) {
            add(el);
        }
        return true;
    }



    public boolean remove(T list) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(list)) {
                return removeAt(i);
            }
        }
        return false;
    }

    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public void bubbleSort() {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if ((int) array[i] > (int) array[i + 1]) {
                    Object temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }



    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray(){
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

}

