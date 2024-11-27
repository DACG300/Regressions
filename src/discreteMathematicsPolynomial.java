public class discreteMathematicsPolynomial {
    double suma = 0;
    double suma1 = 0;


    public double sumOfPowers(double[] x, int power) {
        double sum = 0.0;
        for (double xi : x) {
            sum += Math.pow(xi, power);
        }
        return sum;
    }

    public double sumOfProduct(double[] x, double[] y, int power) {
        double sum = 0.0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], power) * y[i];
        }
        return sum;
    }
    public double Sumatoria(double[] DataSet) {
        double sumatoria = 0;
        for (int i = 0; i < DataSet.length; i++) {
            sumatoria += DataSet[i];
        }
        return sumatoria;
    }

    public double SumaXY(double[] dataSetX, double[] dataSetY) {
        suma = 0;
        for (int i = 0; i < dataSetX.length; i++) {
            suma += dataSetX[i] * dataSetY[i];
        }
        return suma;
    }

    public double SumaX2(double[] dataSetX) {
        suma1 = 0;
        for (int i = 0; i < dataSetX.length; i++) {
            suma1 += dataSetX[i] * dataSetX[i];
        }
        return suma1;
    }

    public double SumaY2(double[] dataSetY) {
        suma = 0;
        for (int i = 0; i < dataSetY.length; i++) {
            suma += dataSetY[i] * dataSetY[i];
        }
        return suma;
    }
}
