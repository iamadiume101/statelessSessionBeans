/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author c0641055
 */

@Stateless
public class LoggingBean {
//    private String pastLog = "";
    
   public void log(String str){
//       pastLog += str;
//        System.out.println("PastLog: " + pastLog);
        System.out.println(new Date() + ": " + str);
    }

    
    
}
