import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class AgenteEmisor extends Agent {
    protected void setup() {
        System.out.println("Agente Emisor iniciado.");


        DataSet dataset = new DataSet();
        double[] dataSetX = dataset.getDataSetX();
        double[] dataSetY = dataset.getDataSetY();

        boolean enviarConX2 = false;

        StringBuilder dataContent = new StringBuilder();
        if (enviarConX2) {
            double[] dataSetX2 = dataset.getDataSetX2();
            for (int i = 0; i < dataSetX.length; i++) {
                dataContent.append("(").append(dataSetX[i]).append(",").append(dataSetX2[i]).append(",").append(dataSetY[i]).append(") ");
            }
        } else {
            for (int i = 0; i < dataSetX.length; i++) {
                dataContent.append("(").append(dataSetX[i]).append(",").append(dataSetY[i]).append(") ");
            }
        }

        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST); //creamos el mensaje para enviar los datos al agente principal
        msg.setContent(dataContent.toString().trim());
        msg.addReceiver(getAID("AgentePrincipal"));
        send(msg);

        System.out.println("Agente Emisor: Datos enviados. Contenido: " + dataContent);
    }
}
