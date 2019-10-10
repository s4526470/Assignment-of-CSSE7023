package pacman.hunter;

/**
 * A class represents speedy hunter.
 */
public class Speedy extends Hunter{

    /**
     * Creates a speedy hunter with all hunter attributes.
     */
    public Speedy(){
        super();
    }

    /**
     * Create a speedy hunter
     * who have copied some attributes from the other hunter.
     *
     * A. copies the other hunter's life status
     * B. copise the other hunter's special status
     * C. copies the duration of the other hunter
     * D. copies the other hunter's position and direction
     *
     * @param original THe other hunter
     */
    public Speedy(Hunter original){
        super(original);
    }


}
