public class discreteMathematicsSimple extends DataSet {

    double suma = 0;
    double[] dataSetX = getDataSetX();
    double[] dataSetY = getDataSetY();
    double suma1 = 0;
    float n = dataSetX.length;
    double sumaY = Sumatoria(dataSetY);
    double sumaX = Sumatoria(dataSetX);
    double sumaXY = SumaXY();
    double sumaX2 = SumaX2();
    double sumaXx2 = SumaXx2();


    public float Sumatoria(double[] DataSet){
        double sumatoria = 0;
        for (int i = 0; i < DataSet.length; i++) {
            sumatoria += DataSet[i];
        }
        return (float) sumatoria;
    }

    public double SumaY2(){
        suma = 0;
        for (int i = 0; i < dataSetY.length; i++) {
            suma += dataSetY[i] * dataSetY[i];
        }
        return suma;
    }

    public double SumaXY() {
        suma = 0;
        for (int i = 0; i < dataSetX.length; i++) {
            suma += dataSetX[i] * dataSetY[i];
        }
        return suma;
    }

    public double SumaX2() {
        suma1 = 0;
        for (int i = 0; i < dataSetX.length; i++) {
            suma1 += dataSetX[i] * dataSetX[i];
        }
        return suma1;
    }

    public double SumaXx2() {
        suma = 0;
        for (int i = 0; i < dataSetX.length; i++) {
            suma += dataSetX[i];
        }
        return suma * suma;
    }

    public double Beta0() {
        return ((sumaX2 * sumaY) - (sumaX * sumaXY)) / ((n * sumaX2) - sumaXx2);
    }

    public double Beta1() {
        return  ((n * sumaXY) - (sumaX * sumaY)) / ((n * sumaX2) - sumaXx2);
    }

    public String[] Media(){
        String[] resultado = new String[2];
        double MediaX = sumaX / n;
        double MediaY = sumaY / n;
        resultado[0] = MediaX + "";
        resultado[1] = MediaY + "";
        return resultado;
    }
}
