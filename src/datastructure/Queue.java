package datastructure;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("큐에 자리가 없습니다");
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.dequeue()); //10
        System.out.println(queue.peek()); //20
    }
}
