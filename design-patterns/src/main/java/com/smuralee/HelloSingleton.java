package com.smuralee;

import java.io.Serializable;

public class HelloSingleton implements Serializable {

    private static HelloSingleton instance = null;

    // Private constructor to avoid the public instantiation
    private HelloSingleton() {
    }

    public static HelloSingleton getInstance() {
        if (instance == null) {
            instance = new HelloSingleton();
        }
        return instance;
    }

    public String buildMessage(final String message) {
        return String.format("The response is - %s", message);
    }
}