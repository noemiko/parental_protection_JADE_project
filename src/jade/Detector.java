package jade;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Detector extends Agent {
    Browser detector;

    public Detector() {
        this.detector = new Browser();
    }
    
    protected void setup() {
        System.out.println("Jestem agentem Jade. Nazywam się -> " + getLocalName());
        addBehaviour(new MyCyclicBehaviour()); 
        //Add cyclic behaviour
    }
    
    protected void takeDown() {
        System.out.println("Nastepuje usuniecie -> " + getLocalName());
        // doDelete();
    }
    
    public class MyCyclicBehaviour extends CyclicBehaviour {

        public void action() {

            try
            {
                ACLMessage msg = myAgent.receive(); 
                if (msg != null) {
                    
                    try{
                        
                        Rules rules = (Rules) msg.getContentObject();
                         
                        String urls = getInformationAboutDetectedForbiddenWords(rules.getRules());

                       ACLMessage reply = msg.createReply();
                       reply.setPerformative(ACLMessage.INFORM); 
                       reply.setLanguage("Polski");
                       reply.setContent(urls); 
                       send(reply); 
                    }
                    catch(Exception ex) {
                    System.out.println(ex);  
                    }
                } else {
                    block(); 
                }
            }
            catch(Exception ex)
                    {
             System.out.println(ex);  
                    }

        }
    }
    
    public String getInformationAboutDetectedForbiddenWords(String[] rules) {
        
        return detector.getForbiddenUrls(rules);
    }

}
