public class Print {
    discreteMathematicsSimple dsm = new discreteMathematicsSimple();
    static RegresionLineal rs = new RegresionLineal();

    public void Medias (){
        String[] resultado = dsm.Media();
        System.out.println("Media X :" +resultado[0]);
        System.out.println("Media Y :" +resultado[1] );

    }

    public double Rsquared(){
        System.out.println("\nLa Correlacion (R) es: " + rs.r());
        System.out.println("La Correlacion cuadrada (R2) es: " + rs.r2());
        return rs.r2();
    }

    public void Betas() {
        double B0 = dsm.Beta0();
        double B1 = dsm.Beta1();
        System.out.println("B0 = " + B0);
        System.out.println("B1 = " + B1 + "\n");
    }
}
