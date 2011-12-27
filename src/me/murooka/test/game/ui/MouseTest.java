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


        // ボタンを押した状態の確認
        mouse.press(id, null);

        // ボタンを押した状態で1回更新
        mouse.update();

        assertTrue(mouse.isPressed(id));
        assertTrue(mouse.isPressing(id));
        assertEquals(mouse.pressingTime(id), 1);
        assertFalse(mouse.isReleased(id));

        // 2回更新
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertTrue(mouse.isPressing(id));
        assertEquals(mouse.pressingTime(id), 2);
        assertFalse(mouse.isReleased(id));

        // 10回更新
        for (int i=0; i<8; i++) {
            mouse.update();
        }

        assertEquals(mouse.pressingTime(id), 10);




        // ボタンを話した状態の確認
        mouse.release(id, null);

        // 1回更新
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertFalse(mouse.isPressing(id));
        assertTrue(mouse.isReleased(id));

        // 2回更新
        mouse.update();

        assertFalse(mouse.isPressed(id));
        assertFalse(mouse.isPressing(id));
        assertFalse(mouse.isReleased(id));

    }


}

