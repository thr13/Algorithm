package datastructure;

public class Deque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addFront(int value) {
        if (isFull()) {
            throw new RuntimeException("덱의 남는 자리가 없습니다");
        }
        front = (front - 1 + maxSize) % maxSize;
        arr[front] = value;
        size++;
    }

    public void addRear(int value) {
        if (isFull()) {
            throw new RuntimeException("덱의 남는 자리가 없습니다");
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = value;
        size++;
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("덱이 비어있습니다");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        size--;
        return value;
    }

    public int removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("덱이 비어있습니다");
        }
        int value = arr[rear];
        rear = (rear - 1 + maxSize) % maxSize;
        size--;
        return value;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("덱이 비어있습니다");
        }
        return arr[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("덱이 비어있습니다");
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.addRear(10);
        deque.addFront(20);
        deque.addRear(30);
        deque.addFront(40);
        System.out.println(deque.peekFront()); //40
        System.out.println(deque.removeFront());
        System.out.println(deque.peekRear()); //30
        System.out.println(deque.removeRear());
        System.out.println(deque.size);
    }
}
