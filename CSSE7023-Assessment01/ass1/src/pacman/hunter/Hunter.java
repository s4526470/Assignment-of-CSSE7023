package pacman.hunter;

import pacman.game.Entity;
import pacman.ghost.Ghost;
import pacman.ghost.Phase;
import pacman.util.Direction;
import pacman.util.Position;

/**
 * A abstract class represents hunter in pacman game
 */
public abstract class Hunter extends Entity {

    /**
     * The hunter's status
     * alive or dead.
     */
    private boolean isDead;

    /**
     * The status of the hunter special
     */
    private boolean useSpecialBefore;

    /**
     * The duration of the hunter special
     */
    private int duration;

    /**
     * Create an alive hunter who has not used special yet.
     * The hunter's special does not be activated
     * The hunter's position is (0,0) and direction is facing up.
     *
     */
    public Hunter(){
        this.isDead = false;
        this.useSpecialBefore = false;
        this.duration = 0;
        setPosition​(new Position(0,0));
        setDirection​(Direction.UP);
    }

    /**
     * Create a hunter who have copied some attributes from the other hunter.
     * A. copies the other hunter's life status
     * B. copise the other hunter's special status
     * C. copies the duration of the other hunter
     * D. copies the other hunter's position and direction
     *
     * @param original THe other hunter
     */
    public Hunter(Hunter original){

        this.isDead = original.isDead();
        this.useSpecialBefore = original.useSpecialBefore;
        this.duration = original.getSpecialDurationRemaining();
        setPosition​(original.getPosition());
        setDirection​(original.getDirection());
    }

    /**
     * Tells if the hunter is dead
     * @return True if dead, false otherwise.
     */
    public boolean isDead(){
        return this.isDead;
    }


    /**
     * Activates the hunter special if hunter has not used the special already.
     * If the hunter have used special, Do not change the duration of special.
     * If not, activate the hunter's special and set the duration.
     * If duration is less than and equal to 0,
     * then does not activate the special.
     *
     * @param duration The given duration to set
     */
    public void activateSpecial​(int duration){

        if (this.useSpecialBefore == false ){
            if (duration > 0){
                this.useSpecialBefore = true;
                this.duration = duration;
            }
        }
    }

    /**
     * Get the remaining duration of special from hunter.
     *
     * @return the remaining duration of special from hunter
     */
    public int getSpecialDurationRemaining(){
        return this.duration;
    }

    /**
     * Check if the special is currently activated.
     *
     * @return true if the duration is greater than 0, false otherwise.
     */
    public boolean isSpecialActive(){
        if (this.duration > 0){
            return true;
        }
        return false;
    }

    /**
     * Checks if the hunter and ghost in same position firstly.
     * If the hunter and ghost in same position and
     * the ghost is Phase.FRIGHTENED, then the ghost is killed.
     * Otherwise, The hunter is killed.
     *
     * @param ghost The ghost that wanted to be hit.
     * @throws NullPointerException If the ghost is null.
     */
    public void hit​(Ghost ghost) throws NullPointerException{
        if (ghost == null){
            throw new NullPointerException("Does not exist ghost");
        }
        if (ghost.getPosition().equals(this.getPosition())){
            if(ghost.getPhase() == Phase.FRIGHTENED){
                ghost.kill();
            }else{
                this.isDead = true;
            }

        }

    }

    /**
     * Reset the ghost to be original status.
     * A.An alive hunter has not used special yet
     * B.The hunter's special does not be activated
     * C.The hunter's position is (0,0) and direction is facing up.
     *
     */
    public void reset(){
        this.isDead = false;
        this.useSpecialBefore = false;
        this.duration = 0;
        setDirection​(Direction.UP);
        setPosition​(new Position(0,0));
    }

}
