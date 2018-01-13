
package jade;
import jade.core.AID;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Personalny extends Agent {
    
    private PersonalnyForm myGui;
    
    protected void setup() {
        myGui = new PersonalnyForm(this);
        myGui.showGui();
        //Dodanie cyklicznego zachowania, 
        addBehaviour(new Personalny.MyCyclicBehaviour());
        
        System.out.println("Jestem agentem Jade. Nazywam się -> " + getLocalName());
    }
    
    protected void takeDown() {
        System.out.println("Nastepuje usuniecie -> " + getLocalName());
        // doDelete();
    }
    
    public class MyCyclicBehaviour extends CyclicBehaviour {

        public void action() {
            ACLMessage msg = myAgent.receive(); 
            if (msg != null) {
                try {
                    String senderName = msg.getSender().getLocalName();
                    System.out.println("Agent get msg from: "+senderName);
                    System.out.println("Message contain: ");
                    String all = msg.getContent(); 
                    if (senderName.compareTo("Detector")==0){
                        System.out.println(all);
                    }
                }
                catch (Exception ex){
                    Logger.getLogger(Personalny.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Tutaj jest cykliczne zadanie, które sprawdza historię przeglądarki
    public void startHistoryDetector (String[] rules) {
        
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Detector", AID.ISLOCALNAME));
                msg.setLanguage("Polski");
                try{
                    msg.setContentObject(new Rules(rules)); 
                    send(msg);
                }
                catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
         
      };
    public String[] readFileRules(){
        FileRules reader = new FileRules();
        return reader.readRules();
        
    }
    public void saveFileRules(String[] rulesToSave){
        FileRules writer = new FileRules();
        writer.saveNewRules(rulesToSave);
    }
       
    }

