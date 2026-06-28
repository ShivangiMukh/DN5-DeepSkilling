class FinancialForecaster {
    // FV(year) = FV(year - 1) * (1 + growthRate), base case FV(0) = presentValue
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }
}

class Exercise21 {
    public static void main(String[] args) {
        double presentValue = 100000.0;
        double growthRate = 0.08; // 8% annual growth
        int years = 5;

        double futureValue = FinancialForecaster.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future value after " + years + " years: " + futureValue);

        // Time complexity is O(n) where n = years - one recursive call per year.
        // Each call waits on the previous result, so this can't be parallelized as written.
        //
        // To optimize: convert to an iterative loop (avoids stack growth for large
        // 'years'), or use the closed-form formula FV = PV * (1 + r)^years directly
        // with Math.pow() - O(1) for practical purposes.
    }
}
