import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteMultiple extends Agent {
    protected void setup() {
        System.out.println("Agente Multiple iniciado.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent();
                    System.out.println("Agente Multiple: Recibido " + content);

                    System.out.println("Agente Multiple: Datos recibidos correctamente.");

                    procesarDatos();
                } else {
                    block();
                }
            }
        });
    }

    private void procesarDatos() {
        System.out.println("Agente Multiple: Procesando los datos recibidos.");

        DataSet dataSet = new DataSet();

        discreteMathematicsMultiple regression = new discreteMathematicsMultiple(dataSet.getDataSetX(), dataSet.getDataSetX2(), dataSet.getDataSetY());

        double[] coefficients = regression.calculateRegression();

        System.out.println("Coeficientes de la regresión múltiple:");
        System.out.println("B0 (intercepto): " + coefficients[0]);
        System.out.println("B1 (coeficiente de X): " + coefficients[1]);
        System.out.println("B2 (coeficiente de X2): " + coefficients[2]);

        double[] nuevoX = {58, 60, 65, 125, 340, 1200};
        double[] nuevoX2 = {3364, 3600, 4225, 15625, 115600, 1440000};

        Prediciones predicciones = new Prediciones();

        double[] resultados = predicciones.hacerPredicciones(nuevoX, nuevoX2, coefficients);

        predicciones.imprimirPredicciones(nuevoX, nuevoX2, resultados);

        ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
        reply.setContent("Coeficientes: B0=" + coefficients[0] + ", B1=" + coefficients[1] + ", B2=" + coefficients[2]);
        reply.addReceiver(getAID("AgentePrincipal"));
        send(reply);

        System.out.println("Agente Multiple: Enviado el resultado de vuelta al AgentePrincipal.");
    }
}
