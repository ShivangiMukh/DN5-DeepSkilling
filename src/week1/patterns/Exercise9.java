interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + filename + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // lazy initialization - only load when actually needed
            realImage = new RealImage(filename);
        } else {
            System.out.println("Using cached image: " + filename);
        }
        realImage.display();
    }
}

class Exercise9 {
    public static void main(String[] args) {
        Image image = new ProxyImage("vacation.jpg");

        System.out.println("First call:");
        image.display(); // loads from server

        System.out.println();
        System.out.println("Second call:");
        image.display(); // uses cache, no reload
    }
}
