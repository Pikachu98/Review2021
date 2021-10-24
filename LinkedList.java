package Model;

// 手写链表
public class LinkedList {
    // 创建一个LinkedList,得到的就是一个head节点和空的next
    Node head;
    static class Node {
        int data;
        Node next;

        Node (int d) {
            this. data = d;
            next = null;
        }
    }

    /**
     * insert 方法，注：因只改变返回值类型不算重载，因此将第二个insert方法注释掉了
     * */
    // 此方法不用非得返回LinkedList，因为linkedlist传进来之后直接就将其改变了
    private static void insert(LinkedList linkedList, int i) {
        Node head = linkedList.head;
        Node newNode = new Node(i);

        // 注意这里不能用前面的那个head,而只能用linkedlist.head，因为head并不直接指向linkedlist.head,
        // 如果将head设置成newNode, linkedlist.head没有任何改变
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            // 找到head.next为空的地方，将新节点赋值给head.next
            while (head.next != null) {
                head = head.next;
            }
            head.next = newNode;
        }
    }


//    public static LinkedList insert(LinkedList list, int data) {
//        // Generate a new node for the inserted data.
//        Node newNode = new Node(data);
//
//        // list is null, 链表无元素
//        if (list.head == null) {
//            // 新节点就是头部
//            list.head = newNode;
//        } else {
//            // 遍历到最后一个元素再添加
//            Node last = list.head;
//
//            while (last.next != null) {
//                last = last.next;
//            }
//
//            last.next = newNode;
//        }
//        return list;
//    }

    /**
     * delete 方法
     * */
    private void delete(LinkedList list, int i) {
        Node prev = null;
        Node curNode = list.head;

        // Case1: 删除头部元素
        if (curNode != null && curNode.data == i) {
            /**
             * 这里又犯了和之前一样的毛病，curNode并不指向list.head!
            curNode = curNode.next;
             */
            list.head = curNode.next;
            return;
        }

        // 没找到对应的值之前一直循环遍历
        while (curNode != null && curNode.data != i) {
            prev = curNode;
            curNode = curNode.next;
        }

        // 找到了这个元素
        if (curNode != null) {
            prev.next = curNode.next;
        }

        // 一直遍历到了链表的最后也没找到这个元素
        if (curNode == null) {
            System.out.println("Sorry, no such element! ");
        }
    }

    public static void printList (LinkedList list) {
        Node node = list.head;

        while (node != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 3);
        list.insert(list, 5);
        list.insert(list, 4);
        printList(list);

        // 测试删除的三种cases
        // Case1: 删除head
        System.out.println("Case1: 删除head");
        list.delete(list, 1);
        printList(list);
        System.out.println();

        // Case2: 删除中间某个元素, 注只删除该元素的第一个位置
        System.out.println("Case2: 删除中间某个元素, 注只删除该元素的第一个位置");
        list.delete(list,3);
        printList(list);
        System.out.println();

        // Case3: 删除一个不存在的元素
        System.out.println("Case3: 删除一个不存在的元素");
        list.delete(list,6);
        printList(list);
        System.out.println();
    }
}
