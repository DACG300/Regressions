public class PolynomialRegression {
    DataSet dataset = new DataSet();
    double[] x = dataset.getDataSetX();
    double[] y = dataset.getDataSetY();
    protected int degree;
    protected double[] coefficients;
    protected discreteMathematicsPolynomial dsm = new discreteMathematicsPolynomial();

    public PolynomialRegression(int degree) {
        this.degree = degree;
        this.coefficients = new double[degree + 1];
    }


    public void fit(double[] x, double[] y) {
        int m = degree + 1;

        double[][] matrix = new double[m][m];
        double[] constants = new double[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = dsm.sumOfPowers(x, i + j);
            }
            constants[i] = dsm.sumOfProduct(x, y, i);
        }

        coefficients = gaussJordan(matrix, constants);
    }

    public double predict(double x) {
        double result = 0.0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    protected double[] gaussJordan(double[][] matrix, double[] constants) {
        int n = constants.length;

        for (int i = 0; i < n; i++) {
            double divisor = matrix[i][i];
            if (divisor == 0) {
                throw new ArithmeticException("División por cero detectada en la matriz. Revisa el sistema de ecuaciones.");
            }

            for (int j = 0; j < n; j++) {
                matrix[i][j] /= divisor;
            }
            constants[i] /= divisor;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double factor = matrix[j][i];
                    for (int k = 0; k < n; k++) {
                        matrix[j][k] -= factor * matrix[i][k];
                    }
                    constants[j] -= factor * constants[i];
                }
            }
        }

        return constants;
    }

    public void printCoefficients() {
        System.out.print("Coeficientes: ");
        for (int i = 0; i <= degree; i++) {
            System.out.printf("B%d = %.4f ", i, coefficients[i]);
        }
        System.out.println();

        double[] predictedY = new double[y.length];
        for (int i = 0; i < x.length; i++) {
            predictedY[i] = predict(x[i]);
        }

        double correlation = RPolynomial.calculateCorrelation(predictedY, y);
        double determination = RPolynomial.calculateDetermination(correlation);

        System.out.printf("\nCoeficiente de correlación: %.4f", correlation);
        System.out.printf("\nCoeficiente de determinación: %.4f\n", determination);
    }



}