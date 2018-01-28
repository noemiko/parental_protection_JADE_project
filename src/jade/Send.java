/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author damia
 */
public class Send extends Agent {
    
    protected void setup() {
        System.out.println("Jestem agentem Jade. Nazywam się -> " + getLocalName());
        addBehaviour(new Send.MyCyclicBehaviour()); 
        //Add cyclic behaviour
    }
    
    protected void takeDown() {
        System.out.println("Nastepuje usuniecie -> " + getLocalName());
        // doDelete();
    }
    
     public class MyCyclicBehaviour extends CyclicBehaviour {
                  

        public void action() {
            
            
ACLMessage msg = myAgent.receive(); 
                if (msg != null) {
                    
                    try{
                     wyslanie();
                    ACLMessage reply = msg.createReply();
                       reply.setPerformative(ACLMessage.INFORM); 
                       reply.setLanguage("Polski");
                       reply.setContent("Wysyłam emaila"); 
                       send(reply); 
                    }
                     catch(Exception ex) {
                    System.out.println(ex);  
                    }


        
        }
      
    }
     public void wyslanie()
     {
         try{
            String host ="smtp.gmail.com" ;
            String user = "email piszący";
            String pass = "hasło";
            String to = "do kogo";
            String from = "email piszący";
            String subject = "Nie dowzwolone wejscie";
            String messageText = "Użytkownik wszedł na strone niedozwoloną lub z niedozowoloną nazwą :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }
            catch(Exception ex)
        {
            System.out.println(ex);
        }
}
    
     }}
