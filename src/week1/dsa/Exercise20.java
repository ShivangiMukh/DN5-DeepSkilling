class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{id=" + bookId + ", title=" + title + ", author=" + author + "}";
    }
}

class BookSearch {
    // Linear search - O(n), works on any order
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    // Binary search - O(log n), requires array sorted alphabetically by title
    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int low = 0, high = sortedBooks.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedBooks[mid].title.compareToIgnoreCase(targetTitle);
            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

class Exercise20 {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Clean Code", "Robert Martin"),
                new Book(2, "Effective Java", "Joshua Bloch"),
                new Book(3, "The Pragmatic Programmer", "Andrew Hunt")
        };

        Book foundLinear = BookSearch.linearSearchByTitle(books, "Effective Java");
        System.out.println("Linear search found: " + foundLinear);

        Book[] sortedBooks = books.clone();
        java.util.Arrays.sort(sortedBooks, (a, b) -> a.title.compareToIgnoreCase(b.title));

        Book foundBinary = BookSearch.binarySearchByTitle(sortedBooks, "Effective Java");
        System.out.println("Binary search found: " + foundBinary);

        // Use linear search for small or frequently-changing catalogs.
        // Use binary search once the catalog is large and sorted/static -
        // O(log n) beats O(n) by a wide margin as the dataset grows.
    }
}
