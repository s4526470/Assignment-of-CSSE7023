package pacman.util;

/**
 * A class represents entities' direction
 */
public enum Direction {
    /**
     * Facing to the left
     */
    LEFT,

    /**
     * Facing to the right
     */
    RIGHT,

    /**
     * Facing up
     */
    UP,

    /**
     * Facing down
     */
    DOWN;

    /**
     * Retrieve the offset related to the direction
     *
     * @return The offset related to the direction
     */
    public Position offset(){
        switch(this){
            case LEFT:
                return new Position(-1, 0);

            case RIGHT:
                return new Position(1, 0);

            case UP:
                return new Position(0, -1);

            case DOWN:
                return new Position(0, 1);

            default:
                return new Position(0, 0);


        }
    }

    /**
     * Get the opposite direction from this direction
     *
     * @return The opposite direction from this direction
     */
    public Direction opposite(){
        switch(this){
            case LEFT:
                return RIGHT;

            case RIGHT:
                return LEFT;

            case UP:
                return DOWN;

            case DOWN:
                return UP;

            default:
                return this;


        }

    }

}
