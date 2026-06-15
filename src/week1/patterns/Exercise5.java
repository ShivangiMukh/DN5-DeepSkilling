// 1. Interface
interface Shape {
    void draw();
}

// 2. Three classes implementing Shape
// Circle  → prints "Drawing Circle"
// Rectangle → prints "Drawing Rectangle"
// Triangle → prints "Drawing Triangle"
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing circle");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing rectangle");
    }
}
class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing triangle");
    }
}

// 3. Factory class

class ShapeFactory {
    public Shape getShape(String shapeType) {
        // based on shapeType return correct object
        // "CIRCLE" → new Circle()
        // "RECTANGLE" → new Rectangle()
        // "TRIANGLE" → new Triangle()
        // anything else → return null
        if(shapeType.equals("CIRCLE")){
            return new Circle();
        }
        if(shapeType.equals("RECTANGLE")){
            return new Rectangle();
        }
        if(shapeType.equals("TRIANGLE")){
            return new Triangle();
        }
        return null;
    }
}

// 4. Main class - Exercise5
class Exercise5 {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        factory.getShape("CIRCLE").draw();
        factory.getShape("RECTANGLE").draw();
        factory.getShape("TRIANGLE").draw();

        // get shapes from factory
        // call draw() on each
        // don't use new Circle() directly anywhere in main
    }
}