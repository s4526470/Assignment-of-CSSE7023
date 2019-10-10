package pacman.hunter;

import pacman.ghost.Ghost;
import pacman.ghost.GhostType;
import pacman.ghost.Phase;

/**
 * A class represents Phasey hunter.
 */
public class Phasey extends Hunter {

    /**
     * Creates a phasey hunter with all hunter attributes.
     */
    public Phasey(){
        super();

    }

    /**
     * Create a phasey hunter
     * who have copied some attributes from the other hunter.
     *
     * A. copies the other hunter's life status
     * B. copise the other hunter's special status
     * C. copies the duration of the other hunter
     * D. copies the other hunter's position and direction
     *
     * @param original THe other hunter
     */
    public Phasey(Hunter original){
        super(original);

    }

    /**
     * If phasey's special is active and if a ghost is not Phase.FRIGHTENED
     * then we travel through the ghost without killing them or them killing us.
     * Otherwise, the phasey hunter act like the normal hunter.
     *
     * @param ghost The ghost that wanted to be hit.
     */
    @Override
    public void hit​(Ghost ghost){
        if (ghost == null){
            throw new NullPointerException("Does not exist ghost");
        }
        if (this.isSpecialActive()){
            if (ghost.getPosition().equals(this.getPosition())
                    && ghost.getPhase() == Phase.FRIGHTENED){
                ghost.kill();
            }
        }else{
            super.hit​(ghost);
        }
    }
}
