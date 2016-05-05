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
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    private List<Thing> things = new ArrayList<>();
    
    public HelloResource() {
     for (int i = 0; i < 10000; i++) {
            Thing sat = new Thing();
            sat.setName("SV"+i);
            things.add(sat);
        }
    }

    @Path("/things")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Thing> getThings() {
      log.info("getThings()");
        return things;
    }
    
    @Path("/things/{name}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Thing getThing(@PathParam("name") String name) {
        for(Thing thing : things) {
            if(thing.getName().equalsIgnoreCase(name))
                return thing;
        }
        throw new NotFoundException();
    } 
    
    @Path("/things")
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Thing addThing(Thing thing) {
        log.info("addThing()");
        things.add(thing);
        return thing;
    }
}
