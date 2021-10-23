package Model;

import sun.awt.image.ImageWatched;

// 手写链表
public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node (int d) {
            this. data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        // Generate a new node for the inserted data.
        Node newNode = new Node(data);

        // list is null, 链表无元素
        if (list.head == null) {
            // 新节点就是头部
            list.head = newNode;
        } else {
            // 遍历到最后一个元素再添加
            Node last = list.head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }


        return list;
    }

    public static void printList (LinkedList list) {
        Node node = list.head;

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);

        printList(list);
    }
}
