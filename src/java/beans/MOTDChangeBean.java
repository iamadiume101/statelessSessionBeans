/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author c0641055
 */
@MessageDriven(mappedName = "jms/Queue")
public class MOTDChangeBean implements MessageListener {
    
    @EJB
    MOTDBean motd;
    
    @EJB
    LoggingBean log;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String newMOTD = ((TextMessage)message).getText();
                motd.setMotd(newMOTD);
            }
        } catch (JMSException ex) {
            log.log("Error with JMS: " + ex.getMessage());
        }
    }

    
}
