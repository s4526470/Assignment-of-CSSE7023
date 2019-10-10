package pacman.ghost;

/**
 * A class represents the ghost phase
 */
public enum Phase {
    /**
     * Phase where the ghosts chase the hunter.
     */
    CHASE,

    /**
     * Phase where the ghosts are frightened and confused.
     */
    FRIGHTENED,

    /**
     * Phase where the ghosts run home.
     */
    SCATTER;

    /**
     * Get the different duration from different ghost phase
     * @return The duration for different ghost phase
     */
    public int getDuration(){
        switch (this){
            case CHASE:
                return 20;
            case SCATTER:
                return 10;
            case FRIGHTENED:
                return 30;
            default:
                return 0;
        }
    }

}
