import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentePolynomial extends Agent {
    protected void setup() {
        System.out.println("Agente Polynomial iniciado.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent();
                    System.out.println("Agente Polynomial: Recibido " + content);

                    procesarDatos();

                    block();
                } else {
                    block();
                }
            }
        });
    }

    private void procesarDatos() {
        System.out.println("Agente Polynomial: Procesando datos");

        Printf printer = new Printf();
        printer.Print();
    }
}
