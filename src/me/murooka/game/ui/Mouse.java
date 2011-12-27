package me.murooka.game.ui;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class Mouse {

    public static final int BUTTON1 = MouseEvent.BUTTON1;
    public static final int BUTTON2 = MouseEvent.BUTTON2;
    public static final int BUTTON3 = MouseEvent.BUTTON3;

    private Button button1;
    private Button button2;
    private Button button3;
    
    private Point pressedPoint1, releasedPoint1, currentPoint1;
    private Point pressedPoint2, releasedPoint2, currentPoint2;
    private Point pressedPoint3, releasedPoint3, currentPoint3;


    private Button button(int id) {
        Button b = null;
        switch (id) {
            case BUTTON1: b = this.button1; break;
            case BUTTON2: b = this.button2; break;
            case BUTTON3: b = this.button3; break;
        }
        return b;
    }

    public Point pressedPoint(int id) {
        Point p = null;
        switch (id) {
            case BUTTON1: p = this.pressedPoint1; break;
            case BUTTON2: p = this.pressedPoint2; break;
            case BUTTON3: p = this.pressedPoint3; break;
        }
        return p;
    }

    public Point releasedPoint(int id) {
        Point p = null;
        switch (id) {
            case BUTTON1: p = this.releasedPoint1; break;
            case BUTTON2: p = this.releasedPoint2; break;
            case BUTTON3: p = this.releasedPoint3; break;
        }
        return p;
    }

    public Point currentPoint(int id) {
        Point p = null;
        switch (id) {
            case BUTTON1: p = this.currentPoint1; break;
            case BUTTON2: p = this.currentPoint2; break;
            case BUTTON3: p = this.currentPoint3; break;
        }
        return p;
    }

    private void setPressedPoint(int id, Point p) {
        switch (id) {
            case BUTTON1: this.pressedPoint1 = p; break;
            case BUTTON2: this.pressedPoint2 = p; break;
            case BUTTON3: this.pressedPoint3 = p; break;
        }
    }

    private void setReleasedPoint(int id, Point p) {
        switch (id) {
            case BUTTON1: this.releasedPoint1 = p; break;
            case BUTTON2: this.releasedPoint2 = p; break;
            case BUTTON3: this.releasedPoint3 = p; break;
        }
    }

    private void setCurrentPoint(int id, Point p) {
        switch (id) {
            case BUTTON1: this.currentPoint1 = p; break;
            case BUTTON2: this.currentPoint2 = p; break;
            case BUTTON3: this.currentPoint3 = p; break;
        }
    }



    public Mouse() {
        this.button1 = new Button("Button1");
        this.button2 = new Button("Button2");
        this.button3 = new Button("Button3");

        this.pressedPoint1 = null;
        this.pressedPoint2 = null;
        this.pressedPoint3 = null;

        this.releasedPoint1 = null;
        this.releasedPoint2 = null;
        this.releasedPoint3 = null;

        this.currentPoint1 = null;
        this.currentPoint2 = null;
        this.currentPoint3 = null;
    }


    public void press(int id, Point p) {
        this.button(id).press();
        this.setCurrentPoint(id, p);
        this.setPressedPoint(id, p);
        this.setReleasedPoint(id, null);
    }

    public void release(int id, Point p) {
        this.button(id).release();
        this.setReleasedPoint(id, p);
        this.setCurrentPoint(id, p);
        this.setPressedPoint(id, null);
    }

    public void drag(int id, Point p) {
        assert this.button(id).isPressing();
        this.setCurrentPoint(id, p);
    }

    public void move(int id, Point p) {
        assert !this.button(id).isPressing();
        this.setCurrentPoint(id, p);
    }



    public void update() {
        this.button1.update();
        this.button2.update();
        this.button3.update();
    }

    public boolean isPressed(int id) {
        return this.button(id).isPressed();
    }

    public boolean isPressing(int id) {
        return this.button(id).isPressing();
    }

    public boolean isReleased(int id) {
        return this.button(id).isReleased();
    }

    public boolean isClicked(int id) {
        // TODO
        return false;
    }

    public int pressingTime(int id) {
        return this.button(id).pressingTime();
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Mouse\n");
        sb.append(this.button1).append("\n");
        sb.append(this.button2).append("\n");
        sb.append(this.button3);

        return sb.toString();
    }

}

