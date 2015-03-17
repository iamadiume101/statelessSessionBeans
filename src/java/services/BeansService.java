/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import beans.LoginBean;
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
   
   @GET
   @Produces("application/json")
   public Response doGet() {
        JsonObject json = Json.createObjectBuilder()
                .add("name", login.getName()).build();
        return Response.ok(json).build();
    }

   
   @POST//
   @Consumes("application/json") 
   public Response doPost(JsonObject json) {
       login.setName(json.getString("name"));
       return Response.ok(json).build();
   }
      
}
