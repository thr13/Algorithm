package datastructure;

public class Stack {
    private int[] arr;
    private int top;
    private int maxSize;

    public Stack(int size) {
        arr = new int[size];
        maxSize = size;
        top = -1; //스택이 비어있는 것으로 취급
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("스택의 남은 자리가 없습니다");
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비어있습니다");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("스택이 비어있습니다");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop()); //30
        System.out.println(stack.peek()); //20
        System.out.println(stack.size()); //2
    }
}
