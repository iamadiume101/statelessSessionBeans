/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.Stateful;

/**
 *
 * @author c0641055
 */

@Stateful
public class LoginBean {
    
    private String name = "ama";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

    

