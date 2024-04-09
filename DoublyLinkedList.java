public class DoublyLinkedList {

    private Node first;
    private Node last;

    public void addFirst(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void addLast(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                last = last.prev;
                last.next = null;
            }
        }
    }

    public Node find(int key) {
        Node current = first;
        while (current != null && current.key != key) {
            current = current.next;
        }
        return current;
    }

    public boolean deleteKey(int key) {
        Node nodeToDelete = find(key);
        if (nodeToDelete != null) {
            if (nodeToDelete == first) {
                deleteFirst();
            } else if (nodeToDelete == last) {
                deleteLast();
            } else {
                nodeToDelete.prev.next = nodeToDelete.next;
                nodeToDelete.next.prev = nodeToDelete.prev;
            }
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
	public String toString() {
		
		StringBuilder ret = new StringBuilder();
		
		Node currentNode = first;
		
		while (currentNode != null) {
			ret.append(currentNode.key + " -> ");
			currentNode = currentNode.next;
		}
		ret.append("null");
		return ret.toString();
	}

}
