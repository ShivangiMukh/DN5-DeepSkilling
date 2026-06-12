import java.util.*;
interface DiscountCalculator {
    public double calculate(double price);
}
class PremiumCalculator implements DiscountCalculator{
    @Override
    public double calculate(double price) {
        return price*0.2;

    }
}
class RegularCalculator implements DiscountCalculator{
    public double calculate(double price) {
        return price*0.1;

    }

}
class StudentDiscount implements DiscountCalculator{
    @Override
    public double calculate(double price) {
        return price*0.15;
    }
}
class Exercise2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        DiscountCalculator calc1 = new PremiumCalculator();
        DiscountCalculator calc2 = new RegularCalculator();
        DiscountCalculator calc3 = new StudentDiscount();
        double disc1 = calc1.calculate(price);
        double disc2 = calc2.calculate(price);
        double studisc1 = calc3.calculate(price);
        System.out.println("My first discount is "+disc1);
        System.out.println("My second discount is "+disc2);
        System.out.println("My student discount is "+studisc1);



    }
}