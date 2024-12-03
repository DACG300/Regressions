public class RegresionLineal {

    DataSet dataset = new DataSet();
    discreteMathematicsSimple dsm = new discreteMathematicsSimple();

    double n;
    double sumaY;
    double sumaX;
    double sumaXY;
    double sumaX2;
    double sumaY2;
    double b0;
    double b1;

    public RegresionLineal() {
        n = dataset.getDataSetX().length;

        sumaX = dsm.Sumatoria(dataset.getDataSetX());
        sumaY = dsm.Sumatoria(dataset.getDataSetY());
        sumaXY = dsm.SumaXY();
        sumaX2 = dsm.SumaX2();
        sumaY2 = dsm.SumaY2();
         b0 = dsm.Beta0();
         b1 = dsm.Beta1();
    }

    public double r() {
        double numerador = n * sumaXY - sumaX * sumaY;
        double denominador = Math.sqrt((n * sumaX2 - sumaX * sumaX) * (n * sumaY2 - sumaY * sumaY));

        if (denominador == 0) {
            return 0;
        }
        return (numerador / denominador);
    }

    public double r2() {
        double correlacion = r();
        return correlacion * correlacion;
    }

    public double[] getBetas() {
        return new double[]{b0, b1};
    }

    public double[] getPredictions(double[] X) {
        double[] predictions = new double[X.length];

        for (int i = 0; i < X.length; i++) {
            predictions[i] = b0 + b1 * X[i];
        }
        return predictions;
    }
}
