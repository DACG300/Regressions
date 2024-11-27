public class Predictions {

    discreteMathematicsSimple discreteMathematics = new discreteMathematicsSimple();

    double B0;
    double B1;

    public Predictions() {
        this.B0 = this.discreteMathematics.Beta0();
        this.B1 = this.discreteMathematics.Beta1();
    }

    public void Prediccion(int[] Narreglo){
        for(int i = 0; i < Narreglo.length; i++){
            int result = Narreglo[i];
            double Prediccion = B0 + (B1 * result);
            System.out.println("Predicción para X = " + result + ": " + Prediccion);
        }
    }
}
