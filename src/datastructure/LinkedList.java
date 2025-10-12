package datastructure;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }

        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new RuntimeException("배열의 크기를 벗어났습니다");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> node = new Node<>(data);
        Node<T> prevNode = head;

        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }

        node.next = prevNode.next;
        prevNode.next = node;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("배열의 크기를 벗어났습니다");
        }

        Node<T> removeNode;

        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else {
            Node<T> prevNode = head;

            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }

            removeNode = prevNode.next;
            prevNode.next = removeNode.next;
        }

        size--;

        return removeNode.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("배열의 크기를 벗어났습니다");
        }

        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(3);
        linkedList.addFirst(1);
        linkedList.addLast(5);
        linkedList.addLast(4);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("get(2) 실행: " + linkedList.get(2));
        System.out.println("remove(1) 실행: " + linkedList.remove(1));

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
