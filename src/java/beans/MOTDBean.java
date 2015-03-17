/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.Singleton;

/**
 *
 * @author c0641055
 */
@Singleton
public class MOTDBean {

    private String motd = "Hello World!";

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    
}
