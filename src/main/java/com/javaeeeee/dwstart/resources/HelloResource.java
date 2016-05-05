/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaeeeee.dwstart.resources;



import com.javaeeeee.dwstart.domain.Thing;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
 */
@Path("/api")
public class HelloResource {
    
    private static final Logger log =LoggerFactory.getLogger(HelloResource.class);
   
    @Path("/things")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Thing> getThings() {
      log.info("getThings()");
       
        List<Thing> things = new ArrayList<>();
        
        for (int i = 0; i < 10000; i++) {
            Thing sat = new Thing();
            sat.setName("SV"+i);
            things.add(sat);
        }
        return things;
    }
}
