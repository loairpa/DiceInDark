package com.example.framework;

import java.util.List;

public interface Input {
    public static class KeyEvent {
        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;

        public int type;
        public int keyCode;
        public char keyChar;

        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (type == KEY_DOWN)
                builder.append("key down, ");
            else
                builder.append("key up, ");
            builder.append(keyCode);
            builder.append(",");
            builder.append(keyChar);
            return builder.toString();
        }
    }

    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;

        public int type;
        public int x, y;
        public int pointer;

        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (type == TOUCH_DOWN)
                builder.append("touch down, ");
            else if (type == TOUCH_DRAGGED)
                builder.append("touch dragged, ");
            else
                builder.append("touch up, ");
            builder.append(pointer);
            builder.append(",");
            builder.append(x);
            builder.append(",");
            builder.append(y);
            return builder.toString();
        }
    }
public static class GestureEvent{
    public static final int SINGLE_TAP = 0;
    public static final int DOUBLE_TAP = 1;
    public static final int FLING_LEFT = 2;
    public static final int FLING_RIGHT = 3;
 

    public int type;
    public int x, y;
    public int pointer;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (type == SINGLE_TAP)
            builder.append("single tap, ");
        else if (type == DOUBLE_TAP)
            builder.append("double tap ");
        else
            builder.append("FLING, ");
        builder.append(pointer);
        builder.append(",");
        builder.append(x);
        builder.append(",");
        builder.append(y);
        return builder.toString();
    }
}
    public boolean isKeyPressed(int keyCode);

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public float getAccelX();

    public float getAccelY();

    public float getAccelZ();

    public List<KeyEvent> getKeyEvents();

   // public List<TouchEvent> getTouchEvents();
    
    public List<GestureEvent> getGestureEvents();
}