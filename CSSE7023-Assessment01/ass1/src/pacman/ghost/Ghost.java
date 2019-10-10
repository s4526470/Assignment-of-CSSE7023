package pacman.ghost;

import pacman.game.Entity;
import pacman.util.Direction;
import pacman.util.Position;

/**
 * A abstract class represents the ghost in pacman game.
 */
public abstract class Ghost extends Entity {

    /**
     * The duration of the ghost's phase
     */
    private int duration;

    /**
     * The ghost's phase
     * CHASE, SCATTER or FRIGHTENED
     */
    private Phase phase;

    /**
     * The ghost's status
     * alive or dead.
     */
    private boolean isDead;


    /**
     * Creates a ghost, which is alive and has SCATTER phase.
     * The duration of SCATTER phase is default value.
     * The position of ghost is (0,0), The direction of ghost is facing up.
     */
    public Ghost(){
        this.isDead = false;
        this.phase = Phase.SCATTER;
        this.duration = this.phase.getDuration();
        setDirection​(Direction.UP);
        setPosition​(new Position(0, 0));


    }

    /**
     * Set the ghose phase and duration overriding any current phase information
     * If phase is null, then remain the previous phase.
     * If duration less than and equal to 0, then set the duration to be 0.
     *
     * @param newPhase Phase to be set.
     * @param duration Duration to be set.
     */
    public void setPhase​(Phase newPhase, int duration){
        if (newPhase != null){
            this.phase = newPhase;
        }

        if (duration < 0){
            this.duration = 0;
        }else{
            this.duration = duration;
        }
    }

    /**
     * Get the ghost phase
     *
     * @return The ghost phase
     */
    public Phase getPhase(){
        return this.phase;
    }

    /**
     * Retrieve the ghost information as formatted "PHASE:DURATION".
     *
     * @return Get the ghost information as formatted "PHASE:DURATION".
     */
    public String phaseInfo(){
        return this.phase + ":" + this.duration;
    }

    /**
     * Get the color from the ghost
     *
     * @return Get the color from the ghost
     */
    public abstract String getColour();

    /**
     * Get the ghost type(BLINKY, CLYDE, INKY or PINKY).
     *
     * @return The ghost type(BLINKY, CLYDE, INKY or PINKY).
     */
    public abstract GhostType getType();

    /**
     * Kill the ghost immediately.
     */
    public void kill(){
        this.isDead = true;
    }

    /**
     * Judge whether the ghost is dead.
     * @return True if ghost is dead, false otherwise.
     */
    public boolean isDead(){
        return this.isDead;
    }

    /**
     * Reset the ghost back to an original status.
     * original status:
     * A. ghost is alive.
     * B. ghost phase is SCATTER and duration is default duraion.
     * C. ghost direction is facing up.
     * D. ghost position is (0,0).
     */
    public void reset(){
        this.isDead = false;
        this.phase = Phase.SCATTER;
        this.duration = this.phase.getDuration();
        setDirection​(Direction.UP);
        setPosition​(new Position(0, 0));
    }

}
