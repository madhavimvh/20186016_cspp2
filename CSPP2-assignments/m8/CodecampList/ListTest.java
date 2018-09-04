import java.util.Arrays;

public class ListTest {
    private int[] list;
    private int size;
    public ListTest() {
        list = new int[10];
        size = 0;

    }
    public int count(int item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                count++;
        }
    }
    return count;
}
    public String toString() {
        // Replace the code below
        String s = "[";
        for (int i = 0; i < size - 1; i++) {
            s += list[i] + ",";
        }
        s += list[size-1] + "]";
        return s;
    } 
    public void add(int item) {
        if(size < list.length){
        list[size] = item;
        size++;    
        }
    }
    public void addAll(int[] item) {
        int n = size + item.length;
        if( n < list.length){
        for (int i = 0; i < list.length; i++) {
            list[i + size] = item[i];
        }   
        } else {
            System.out.println("cannot add");
        }
    }
    public void add(int index, int item) {
        int[] b = Arrays.copyOfRange(list, 0, list.length);
        System.out.println(Arrays.toString(b));
        for(int i = index; i < size; i++) {
            System.out.println(i);
            list[i + 1] = b[i];
            System.out.println(Arrays.toString(list));
        }
        size++;
        list[index] = item;
    }
    public static void main(String[] args) {
        ListTest list = new ListTest();
        list.add(33);
        System.out.println(list);
        list.add(34);
        System.out.println(list);
        list.add(35);
        System.out.println(list);
        list.add(0, 234);
        System.out.println(list);
        list.add(1, 456);
        System.out.println(list);
        list.addAll();
        System.out.println(list);
    } 
}