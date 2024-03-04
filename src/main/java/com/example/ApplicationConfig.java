package com.example;

import java.util.ArrayList;


import jakarta.ws.rs.core.Application;

import com.example.model.Gluttony;

public class ApplicationConfig extends Application {
    public static ArrayList<Gluttony> gluttony = new ArrayList<Gluttony>();

}
