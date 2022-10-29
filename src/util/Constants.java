package util;

public class Constants {
    
    //A class to control character frames
    public static class PlayerConstants {
        //playeractions
        public static final int MOVE_LEFT = 0;
        public static final int MOVE_RIGHT = 1;
        public static final int MOVE_UP = 2;
        public static final int MOVE_DOWN = 3;
        //treba dodati MOVE_UP_RIGHT, MOVE_DOWN_LEFT... 

        //stevilo elementov animacije
        public static int getAnimationAmount(int playerAction) {
            switch(playerAction) {
                case MOVE_LEFT:
                    return 4;
                case MOVE_RIGHT:
                    return 4;
                case MOVE_UP:
                    return 4;
                case MOVE_DOWN:
                    return 4;
                //...
                default:
                    return 1;
            }
        }
    }
}
