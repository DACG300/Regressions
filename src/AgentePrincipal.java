import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentePrincipal extends Agent {
    private boolean usePolynomial = false;

    protected void setup() {
        System.out.println("Agente Principal iniciado.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive(); // Recibe el Mensaje de Emisor
                if (msg != null) {
                    String content = msg.getContent();
                    System.out.println("Agente Principal: Recibido " + content);

                    if (esRegresionMultiple(content)) {
                        System.out.println("Agente Principal: Datos adecuados para regresión múltiple.");

                        ACLMessage forward = new ACLMessage(ACLMessage.REQUEST);
                        forward.setContent(content);
                        forward.addReceiver(getAID("AgenteMultiple"));
                        send(forward);

                        System.out.println("Agente Principal: Enviando datos a Agente Multiple.");
                    } else if (esRegresionPolynomial(content) && usePolynomial) {
                        System.out.println("Agente Principal: Datos adecuados para regresión polinómica.");

                        ACLMessage forward = new ACLMessage(ACLMessage.REQUEST);
                        forward.setContent(content);
                        forward.addReceiver(getAID("AgentePolynomial"));
                        send(forward);

                        System.out.println("Agente Principal: Enviando datos a Agente Polynomial.");
                    } else if (esRegresionSimple(content)) {
                        System.out.println("Agente Principal: Datos adecuados para regresión simple.");

                        // Ejecutar GenAgent solo cuando sea regresión simple
                        try {
                            // Obtener y ejecutar el comportamiento de GenAgent
                            Agent genAgent = (Agent) getAgent();

                            // Agregar comportamiento para ejecutar la operación del GenAgent
                            genAgent.addBehaviour(new GenBehaviour());
                            System.out.println("Agente Principal: Ejecutando GenAgent para regresión simple.");

                        } catch (Exception e) {
                            System.out.println("Agente Principal: No se pudo ejecutar GenAgent.");
                            e.printStackTrace();
                        }

                        ACLMessage forward = new ACLMessage(ACLMessage.REQUEST);
                        forward.setContent(content);
                        forward.addReceiver(getAID("AgenteSimple"));
                        send(forward);

                        System.out.println("Agente Principal: Enviando datos a Agente Simple.");
                    } else {
                        System.out.println("Agente Principal: Datos no adecuados para regresión.");
                    }
                } else {
                    block();
                }
            }

            private boolean esRegresionSimple(String content) {
                String[] pairs = content.split(" ");
                for (String pair : pairs) {
                    String[] values = pair.replace("(", "").replace(")", "").split(",");
                    if (values.length != 2) {
                        return false;
                    }
                    try {
                        Double.parseDouble(values[0]);
                        Double.parseDouble(values[1]);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
                return true;
            }

            private boolean esRegresionMultiple(String content) {
                String[] pairs = content.split(" "); //separamos los datos en pares
                for (String pair : pairs) {
                    String[] values = pair.replace("(", "").replace(")", "").split(",");
                    if (values.length == 3) {
                        try {
                            Double.parseDouble(values[0]);
                            Double.parseDouble(values[1]);
                            Double.parseDouble(values[2]);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                }
                return false;
            }

            private boolean esRegresionPolynomial(String content) {
                String[] pairs = content.split(" ");
                for (String pair : pairs) {
                    String[] values = pair.replace("(", "").replace(")", "").split(",");
                    if (values.length == 2) {
                        try {
                            Double.parseDouble(values[0]);
                            Double.parseDouble(values[1]);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                }
                return false;
            }
        });
    }
}
