package com.smuralee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloSingletonTest {

    private static final HelloSingleton helloSingleton = HelloSingleton.getInstance();

    @Test
    @DisplayName("GIVEN a singleton, THEN a method within the singleton should be invoked")
    void printMessage() {
        helloSingleton.printMessage();
    }
}