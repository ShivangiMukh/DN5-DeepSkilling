class SearchableProduct {
    int productId;
    String productName;
    String category;

    public SearchableProduct(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class ProductSearch {
    // Linear search - O(n) worst case, checks every element
    public static SearchableProduct linearSearch(SearchableProduct[] products, int targetId) {
        for (SearchableProduct p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    // Binary search - O(log n), requires array sorted by productId
    public static SearchableProduct binarySearch(SearchableProduct[] sortedProducts, int targetId) {
        int low = 0, high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedProducts[mid].productId == targetId) {
                return sortedProducts[mid];
            } else if (sortedProducts[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

class Exercise16 {
    public static void main(String[] args) {
        SearchableProduct[] products = {
                new SearchableProduct(3, "Keyboard", "Electronics"),
                new SearchableProduct(1, "Laptop", "Electronics"),
                new SearchableProduct(5, "Desk", "Furniture"),
                new SearchableProduct(2, "Mouse", "Electronics"),
                new SearchableProduct(4, "Chair", "Furniture")
        };

        SearchableProduct found = ProductSearch.linearSearch(products, 4);
        System.out.println("Linear search found: " + (found != null ? found.productName : "not found"));

        SearchableProduct[] sorted = products.clone();
        java.util.Arrays.sort(sorted, (a, b) -> a.productId - b.productId);

        SearchableProduct foundBinary = ProductSearch.binarySearch(sorted, 4);
        System.out.println("Binary search found: " + (foundBinary != null ? foundBinary.productName : "not found"));

        // Binary search wins for large, mostly-static datasets searched repeatedly.
        // Linear search wins when data changes constantly (no time spent re-sorting).
    }
}
