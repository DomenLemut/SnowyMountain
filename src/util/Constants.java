package util;

public class Constants {

    public static class Directions {
        public static final int LEFT = 0;
        public static final int RIGHT = 1;
        public static final int UP = 2;
        public static final int DOWN = 3;
    }

    //A class to control character frames
    public static class PlayerConstants {
        //playeractions
        public static final int IDLE_LEFT = 0;
        public static final int IDLE_RIGHT = 1;
        public static final int IDLE_UP = 2;
        public static final int IDLE_DOWN = 3;
        public static final int MOVE_LEFT = 4;
        public static final int MOVE_RIGHT = 5;
        public static final int MOVE_UP = 6;
        public static final int MOVE_DOWN = 7;
        //treba dodati MOVE_UP_RIGHT, MOVE_DOWN_LEFT... 

        public static final int NUM_MOVES = 8;

        //stevilo elementov animacije
        public static int getAnimationAmount(int playerAction) {
            switch(playerAction) {
                case IDLE_LEFT:
                    return 1;
                case IDLE_RIGHT:
                    return 1;
                case IDLE_UP:
                    return 1;
                case IDLE_DOWN:
                    return 1;
                case MOVE_LEFT:
                    return 3;
                case MOVE_RIGHT:
                    return 3;
                case MOVE_UP:
                    return 3;
                case MOVE_DOWN:
                    return 3;
                //...
                default:
                    return 1;
            }
        }
    }
}
