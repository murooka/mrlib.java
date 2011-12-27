package me.murooka.game.ui;


public class Input {

    private static final Mouse mouse;

    static {
        mouse = new Mouse();
    }

    public static Mouse mouse() {
        return mouse;
    }


    public static void update() {
        mouse.update();
    }

}



