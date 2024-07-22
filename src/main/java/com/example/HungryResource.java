package com.example;


import java.util.Arrays;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import com.example.model.Gluttony;
import com.example.model.Meal;

@Path("/")
public class HungryResource {
    
    @Inject
    Logger logger;

    @ConfigProperty(name="app.dishSize",defaultValue="1048576")
    int dishSize;
    
    @GET
    @Path("/eat")
    @Produces(MediaType.TEXT_PLAIN)

    public String prepareMeal() {
        logger.info("Prepare meal");
        makeDisk(dishSize);
        return "Added "+dishSize+" bytes";
    }
    
    @GET
    @Path("/eat/{numberOfDishes}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Add multiple dishes")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.TEXT_PLAIN))
    public String prepareMeals(@PathParam("numberOfDishes") int numberOfDishes) {
        long total=0;
        for(int i=0;i<numberOfDishes;i++){
            logger.info("Prepare meal for dish no. "+(i+1));
            makeDisk(dishSize);
            total+=dishSize;
            
        }
        return "Added "+total+" bytes";
    }

    @GET
    @Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Check how much memory already allocated")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.TEXT_PLAIN))
    public String numOfMeals(){
        long size=0;
        int i = 0;
        logger.info("Calculate total dishes size");
        for(Gluttony hunger:ApplicationConfig.gluttony){   
            
            logger.info("dish: "+(i+1)+" size: "+hunger.getSize()+" bytes");
            size+=hunger.getSize();
            logger.info("Total: "+size);
            i++;
        }  
        float total = size;

        return "Total "+i+" dishes, "+total/(1024*1024)+" MB";
    }

    @GET
    @Path("/kill")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Exit with exit code 9")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.TEXT_PLAIN))
    public void exitWithSigKill() {
        logger.info("Exit with SIGKILL (9)");
        System.exit(9);
    }
    private void makeDisk(int size){
        char[] array = new char[size];  
        Arrays.fill(array, 'x'); 
        Meal meal = new Meal(new String(array));
        ApplicationConfig.gluttony.add(new Gluttony(meal, size));
        logger.info("Allocated "+size+" bytes");
    }
}