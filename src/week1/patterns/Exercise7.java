// Target interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1 - existing gateway, incompatible interface
class PayPalGateway {
    public void makePayPalPayment(double amountInUSD) {
        System.out.println("Processing $" + amountInUSD + " via PayPal");
    }
}

// Adaptee 2 - another gateway, different method signature
class StripeGateway {
    public void sendStripeCharge(double amount, String currency) {
        System.out.println("Charging " + amount + " " + currency + " via Stripe");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayPalPayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.sendStripeCharge(amount, "USD");
    }
}

class Exercise7 {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        paypal.processPayment(250.0);
        stripe.processPayment(499.50);
    }
}
