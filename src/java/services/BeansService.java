/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import beans.LoggingBean;
import beans.LoginBean;
import beans.MOTDBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author c0641055
 */

@Path("/beans")
@SessionScoped
public class BeansService implements Serializable {
   @EJB 
   LoginBean login;
   
   @EJB 
   LoggingBean log;
   
   @EJB 
   MOTDBean motd;
   
   @GET
   @Produces("application/json")
   public Response doGet() {
        JsonObject json = Json.createObjectBuilder()
                .add("name", login.getName())
                 .add("motd", motd.getMotd()).build();
        log.log(json.toString());
        return Response.ok(json).build();
    }

   
   @POST//
   @Consumes("application/json") 
   public Response doPost(JsonObject json) {
       login.setName(json.getString("name"));
       log.log(json.toString());
       motd.setMotd(json.getString("motd"));
       return Response.ok(json).build();
   }
      
}
