package com.example;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;

import com.example.model.Gluttony;
@ApplicationScoped
public class ApplicationConfig extends Application {
    public static ArrayList<Gluttony> gluttony = new ArrayList<Gluttony>();

}
