package com.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void greetRegularName() {
        assertEquals("Hello, Jenkins!", App.greet("Jenkins"));
    }

    @Test
    void greetNull() {
        assertEquals("Hello, World!", App.greet(null));
    }

    @Test
    void greetBlank() {
        assertEquals("Hello, World!", App.greet("   "));
    }
}
