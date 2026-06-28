import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Mobile App] " + stockSymbol + " is now $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Web App] " + stockSymbol + " is now $" + price);
    }
}

class Exercise10 {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStockPrice("AAPL", 195.50);

        market.deregisterObserver(web);
        market.setStockPrice("AAPL", 198.20);
    }
}
