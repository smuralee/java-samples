package com.smuralee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloSingletonTest {

    private static final HelloSingleton helloSingleton = HelloSingleton.getInstance();
    private static final String INPUT_MESSAGE = "The seagull is enjoying the wind";
    private static final String EXPECTED_MESSAGE = "The response is - ".concat(INPUT_MESSAGE);

    @Test
    @DisplayName("GIVEN a singleton, THEN buildMessage function should be invoked")
    void buildMessage() {
        assertEquals(EXPECTED_MESSAGE, helloSingleton.buildMessage(INPUT_MESSAGE));
    }
}