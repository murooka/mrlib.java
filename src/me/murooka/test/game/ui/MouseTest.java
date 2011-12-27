package me.murooka.test.game.ui;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import me.murooka.game.ui.Mouse;



public class MouseTest {

    public static void main(String[] args) {
        JUnitCore.main(MouseTest.class.getName());
    }

    @Test
    public void defaultTest() {
        Mouse mouse = new Mouse();
        final int id = Mouse.BUTTON1;


        // $B%\%?%s$r2!$7$?>uBV$N3NG'(B
        mouse.press(id, null);

        // $B%\%?%s$r2!$7$?>uBV$G(B1$B2s99?7(B
        mouse.update();

        assertTrue(mouse.isPressed(id));
        assertTrue(mouse.isPressing(id));
        assertEquals(mouse.pressingTime(id), 1);
        assertFalse(mouse.isReleased(id));

        // 2$B2s99?7(B
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertTrue(mouse.isPressing(id));
        assertEquals(mouse.pressingTime(id), 2);
        assertFalse(mouse.isReleased(id));

        // 10$B2s99?7(B
        for (int i=0; i<8; i++) {
            mouse.update();
        }

        assertEquals(mouse.pressingTime(id), 10);




        // $B%\%?%s$rOC$7$?>uBV$N3NG'(B
        mouse.release(id, null);

        // 1$B2s99?7(B
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertFalse(mouse.isPressing(id));
        assertTrue(mouse.isReleased(id));

        // 2$B2s99?7(B
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertFalse(mouse.isPressing(id));
        assertFalse(mouse.isReleased(id));

    }


}

