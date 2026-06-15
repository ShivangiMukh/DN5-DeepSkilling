/*  --Bad Example--
class DatabaseConnection {
    public DatabaseConnection() {
        System.out.println("New connection created");
    }
    public void connect() {
        System.out.println("Connected to database");
    }
}
class Exercise4 {
    public static void main(String[] args) {
        // Problem - creating multiple connections
        DatabaseConnection conn1 = new DatabaseConnection();
        DatabaseConnection conn2 = new DatabaseConnection();
        DatabaseConnection conn3 = new DatabaseConnection();
        // 3 separate connections created - wasteful and dangerous
    }
}
*/
// --Solution--
class DatabaseConnection{
    private static DatabaseConnection instance;
    private DatabaseConnection(){
        System.out.println("Connection created");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public void connect() {
        System.out.println("Connected to database");
    }
}
class Exercise4 {
    public static void main(String[] args) {
        // This should print "Connection created" only ONCE
        // no matter how many times you call getInstance()
        DatabaseConnection c1 = DatabaseConnection.getInstance();
        DatabaseConnection c2 = DatabaseConnection.getInstance();
        DatabaseConnection c3 = DatabaseConnection.getInstance();

        // This should print true - same object
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
}
