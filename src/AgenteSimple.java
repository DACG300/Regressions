import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteSimple extends Agent {
    protected void setup() {
        System.out.println("Agente Simple iniciado.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent();
                    System.out.println("Agente Simple: Recibido " + content);

                    double r2 = procesarDatos();

                    ACLMessage reply = msg.createReply();
                    reply.setContent("R2Simple: " + r2);
                    send(reply);

                    block();
                } else {
                    block();
                }
            }
        });
    }

    private double procesarDatos() {
        System.out.println("Agente Simple: Procesando datos");
        int[] Narreglo = {58, 60, 65, 125, 340, 1200};

        Print printer = new Print();
        Predictions pred = new Predictions();

        printer.Medias();
        printer.Rsquared();
        printer.Betas();
        pred.Prediccion(Narreglo);

        return printer.Rsquared();
    }
}
