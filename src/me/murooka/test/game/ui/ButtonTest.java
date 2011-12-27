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


        // ボタンを押した状態の確認
        button.press();

        // ボタンを押した状態で1回更新
        button.update();

        assertTrue(button.isPressed());
        assertTrue(button.isPressing());
        assertEquals(button.pressingTime(), 1);
        assertFalse(button.isReleased());

        // 2回更新
        button.update();

        assertFalse(button.isPressed());
        assertTrue(button.isPressing());
        assertEquals(button.pressingTime(), 2);
        assertFalse(button.isReleased());

        // 10回更新
        for (int i=0; i<8; i++) {
            button.update();
        }

        assertEquals(button.pressingTime(), 10);




        // ボタンを話した状態の確認
        button.release();

        // 1回更新
        button.update();

        assertFalse(button.isPressed());
        assertFalse(button.isPressing());
        assertTrue(button.isReleased());

        // 2回更新
        button.update();

        assertFalse(button.isPressed());
        assertFalse(button.isPressing());
        assertFalse(button.isReleased());

    }


}

