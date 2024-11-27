public class Prediciones {

    public double[] hacerPredicciones(double[] nuevoX, double[] nuevoX2, double[] coeficientes) {
        double[] predicciones = new double[nuevoX.length];

        for (int i = 0; i < nuevoX.length; i++) {
            predicciones[i] = coeficientes[0] + coeficientes[1] * nuevoX[i] + coeficientes[2] * nuevoX2[i];
        }

        return predicciones;
    }

    public void imprimirPredicciones(double[] nuevoX, double[] nuevoX2, double[] predicciones) {
        System.out.println("\nPredicciones:");
        for (int i = 0; i < nuevoX.length; i++) {
            System.out.println("X: " + nuevoX[i] + ", X2: " + nuevoX2[i] + " = Predicción: " + predicciones[i]);
        }
    }
}
