package pacman.hunter;

import pacman.ghost.Ghost;

/**
 * A class represents hungry hunter.
 */
public class Hungry extends Hunter {

    /**
     * Creates a hungry hunter with all hunter attributes.
     */
    public Hungry(){
        super();

    }

    /**
     * Create a hungry hunter
     * who have copied some attributes from the other hunter.
     *
     * A. copies the other hunter's life status
     * B. copise the other hunter's special status
     * C. copies the duration of the other hunter
     * D. copies the other hunter's position and direction
     *
     * @param original THe other hunter
     */
    public Hungry(Hunter original){
        super(original);
    }

    /**
     * If hungry special is activated and hungry hunter and ghost
     * stay in the same position, then the ghost is dead.
     * Otherwise, the hungry hunter act like the normal hunter.
     *
     * @param ghost The ghost that wanted to be hit.
     */
    @Override
    public void hit​(Ghost ghost){
        if (ghost == null){
            throw new NullPointerException("not exist ghost");
        }
        if (this.isSpecialActive()){
            if (ghost.getPosition().equals(this.getPosition())){
                ghost.kill();
            }
        }else{
            super.hit​(ghost);
        }

    }

}
