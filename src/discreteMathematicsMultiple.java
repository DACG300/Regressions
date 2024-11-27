public class discreteMathematicsMultiple {

    private double[] dataSetX;
    private double[] dataSetX2;
    private double[] dataSetY;

    public discreteMathematicsMultiple(double[] dataSetX, double[] dataSetX2, double[] dataSetY) {
        this.dataSetX = dataSetX;
        this.dataSetX2 = dataSetX2;
        this.dataSetY = dataSetY;
    }

    public double[] calculateRegression() {
        double sumX = 0, sumX2 = 0, sumY = 0;
        double sumXY = 0, sumX2Y = 0, sumX3 = 0, sumX4 = 0;

        for (int i = 0; i < dataSetX.length; i++) {
            sumX += dataSetX[i];
            sumX2 += dataSetX2[i];
            sumY += dataSetY[i];
            sumXY += dataSetX[i] * dataSetY[i];
            sumX2Y += dataSetX2[i] * dataSetY[i];
            sumX3 += dataSetX[i] * dataSetX2[i];
            sumX4 += dataSetX2[i] * dataSetX2[i];
        }

        double[][] A = {
                {dataSetX.length, sumX, sumX2},
                {sumX, sumX2, sumX3},
                {sumX2, sumX3, sumX4}
        };
        double[] C = {sumY, sumXY, sumX2Y};

        MultipleRegression math = new MultipleRegression();
        double[][] inverseA = math.invertMatrix(A);
        double[] B = math.multiplyMatrix(inverseA, C);

        return B;
    }
}
