package me.murooka.game.ui;

/**
 * 入力インターフェイスであるボタンに対応するクラスです
 * キーボードのキーやマウスのボタンなどが該当します
 *
 */
public class Button {

    private String name = null;
    private boolean pressing = false;
    private int counter = -1;



    public Button() {
        this(null);
    }

    public Button(String name) {
        this.name = name;
    }



    public void press() {
        this.pressing = true;
    }

    public void release() {
        this.pressing = false;
    }



    public void update() {
        final int c = this.counter;
        assert c!=0;

        if (this.pressing) {
            this.counter = c<0 ? 1 : c+1;
        } else {
            this.counter = c>0 ? -1 : c-1;
        }
    }

    public boolean isPressed() {
        return counter==1;
    }

    public boolean isPressing() {
        return counter>0;
    }

    public boolean isReleased() {
        return counter==-1;
    }

    public int pressingTime() {
        return counter;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Button ");
        if (name==null) {
            sb.append("noname ");
        } else {
            sb.append("name:").append(name).append(" ");
        }

        String state;
        if (this.isPressed()) {
            state = "pressed";
        } else if (this.isReleased()) {
            state = "released";
        } else if (this.isPressing()) {
            state = "pressing";
        } else {
            state = "releasing";
        }
        sb.append("state:").append(state).append(" ");

        sb.append("time:").append(Math.abs(counter));

        return sb.toString();
    }

}

