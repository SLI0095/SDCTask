package com.example.SDCTask;

public class SDCTask {



    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Please specify path of the file.");
            return;
        }
        //setting property for suppressing log4j2 error to display on console
        System.setProperty("log4j2.loggerContextFactory", "org.apache.logging.log4j.simple.SimpleLoggerContextFactory");
        PrimeFinder.printPrimesFromFile(args[0]);
    }
}
