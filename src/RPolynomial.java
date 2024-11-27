public class RPolynomial {
    private static discreteMathematicsPolynomial dsm = new discreteMathematicsPolynomial();

    public static double calculateCorrelation(double[] x, double[] y) {
        int n = x.length;

        double sumX = dsm.Sumatoria(x);
        double sumY = dsm.Sumatoria(y);
        double sumXY = dsm.SumaXY(x, y);
        double sumX2 = dsm.SumaX2(x);
        double sumY2 = dsm.SumaY2(y);

        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        return numerator / denominator;
    }

    public static double calculateDetermination(double correlation) {
        return correlation * correlation;
    }
}
