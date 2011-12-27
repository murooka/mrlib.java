package me.murooka.test.game.ui;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import me.murooka.game.ui.Button;



public class ButtonTest {

    public static void main(String[] args) {
        JUnitCore.main(ButtonTest.class.getName());
    }

    @Test
    public void defaultTest() {
        Button button = new Button();


        // $B%\%?%s$r2!$7$?>uBV$N3NG'(B
        button.press();

        // $B%\%?%s$r2!$7$?>uBV$G(B1$B2s99?7(B
        button.update();

        assertTrue(button.isPressed());
        assertTrue(button.isPressing());
        assertEquals(button.pressingTime(), 1);
        assertFalse(button.isReleased());

        // 2$B2s99?7(B
        button.update();

        assertFalse(button.isPressed());
        assertTrue(button.isPressing());
        assertEquals(button.pressingTime(), 2);
        assertFalse(button.isReleased());

        // 10$B2s99?7(B
        for (int i=0; i<8; i++) {
            button.update();
        }

        assertEquals(button.pressingTime(), 10);




        // $B%\%?%s$rOC$7$?>uBV$N3NG'(B
        button.release();

        // 1$B2s99?7(B
        button.update();

        assertFalse(button.isPressed());
        assertFalse(button.isPressing());
        assertTrue(button.isReleased());

        // 2$B2s99?7(B
        button.update();

        assertFalse(button.isPressed());
        assertFalse(button.isPressing());
        assertFalse(button.isReleased());

    }


}

