class CustomerOrder {
    int orderId;
    String customerName;
    double totalPrice;

    public CustomerOrder(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", customer=" + customerName + ", total=" + totalPrice + "}";
    }
}

class OrderSorter {
    // Bubble Sort - O(n^2) worst/average, repeatedly swaps adjacent out-of-order pairs
    public static void bubbleSort(CustomerOrder[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort - O(n log n) average, divide and conquer using a pivot
    public static void quickSort(CustomerOrder[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(CustomerOrder[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

class Exercise17 {
    public static void main(String[] args) {
        CustomerOrder[] bubbleOrders = {
                new CustomerOrder(1, "Shivangi", 1500.0),
                new CustomerOrder(2, "Rahul", 300.0),
                new CustomerOrder(3, "Priya", 4200.0),
                new CustomerOrder(4, "Aman", 800.0)
        };

        OrderSorter.bubbleSort(bubbleOrders);
        System.out.println("Bubble sorted by totalPrice:");
        for (CustomerOrder o : bubbleOrders) System.out.println(o);

        CustomerOrder[] quickOrders = {
                new CustomerOrder(1, "Shivangi", 1500.0),
                new CustomerOrder(2, "Rahul", 300.0),
                new CustomerOrder(3, "Priya", 4200.0),
                new CustomerOrder(4, "Aman", 800.0)
        };

        OrderSorter.quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println();
        System.out.println("Quick sorted by totalPrice:");
        for (CustomerOrder o : quickOrders) System.out.println(o);

        // Quick Sort is preferred at scale: O(n log n) average vs Bubble Sort's O(n^2).
        // Bubble Sort only makes sense for teaching or tiny/nearly-sorted datasets.
    }
}
