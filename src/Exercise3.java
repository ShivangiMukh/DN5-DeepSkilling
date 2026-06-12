import java.util.*;
// Low level class
interface Database {
    void save(String data);

}

// High level class - directly depends on MySQLDatabase
// This is the problem
class MySQLDatabase implements Database{
    @Override
    public void save(String data) {
        System.out.println("This is my mysql data"+data);

    }
}
class MongoDataBase implements Database{
    @Override
    public void save(String data){
        System.out.println("This is my mongodb data"+data);

    }
}
class Orderservice{
    private Database database;
    public Orderservice(Database database){
        this.database = database;
    }
    public void saveOrder(String order){
        database.save(order);
    }

}

class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order1 = sc.next();
        Database mysql1 = new MySQLDatabase();
        Database mongo1 = new MongoDataBase();
        mysql1.save(order1);
        mongo1.save(order1);
        Orderservice serviceorder1 = new Orderservice(mysql1);
        serviceorder1.saveOrder(order1);
        Orderservice serviceorder2 = new Orderservice(mongo1);
        serviceorder2.saveOrder(order1);


    }
}