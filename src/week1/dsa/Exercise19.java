class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", name=" + taskName + ", status=" + status + "}";
    }
}

class TaskNode {
    Task data;
    TaskNode next;

    public TaskNode(Task data) {
        this.data = data;
    }
}

// Singly linked list - each node only knows the next node, not the previous one
class TaskLinkedList {
    private TaskNode head;

    public void add(Task task) { // O(1) - new node becomes the head
        TaskNode newNode = new TaskNode(task);
        newNode.next = head;
        head = newNode;
    }

    public Task search(int taskId) { // O(n) worst case
        TaskNode current = head;
        while (current != null) {
            if (current.data.taskId == taskId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() { // O(n) - must visit every node
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void delete(int taskId) { // O(n) - find node, then unlink in O(1)
        if (head == null) return;

        if (head.data.taskId == taskId) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.data.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

class Exercise19 {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.add(new Task(1, "Design schema", "Pending"));
        list.add(new Task(2, "Write API", "In Progress"));
        list.add(new Task(3, "Test endpoints", "Pending"));

        System.out.println("All tasks:");
        list.traverse();

        Task found = list.search(2);
        System.out.println();
        System.out.println("Search for id 2: " + found);

        list.delete(1);
        System.out.println();
        System.out.println("After deleting id 1:");
        list.traverse();

        // Linked lists avoid the shifting cost arrays have on insert/delete (O(1)
        // once you have the node), trading that for O(n) access by position
        // and a bit more memory use (extra pointer per node).
    }
}
