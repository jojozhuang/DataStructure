package johnny.dsa.ds;

public class DoublyLinkedNode {
    public int val;
    public DoublyLinkedNode previous;
    public DoublyLinkedNode next;
    public DoublyLinkedNode(int val) {
        this.val = val;
        this.previous = null;
        this.next = null;
    }
}
