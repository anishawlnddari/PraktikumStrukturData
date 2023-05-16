public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            if (data < head.data) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && data >= current.next.data) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(7);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(3);
        list.printList(); 
    }

}
