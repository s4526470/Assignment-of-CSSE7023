package pacman.hunter;

/**
 * A class represents phil hunter.
 */
public class Phil extends Hunter{

    /**
     * Creates a phil hunter with all hunter attributes.
     */
    public Phil(){
        super();

    }

    /**
     * Create a phil hunter
     * who have copied some attributes from the other hunter.
     *
     * A. copies the other hunter's life status
     * B. copise the other hunter's special status
     * C. copies the duration of the other hunter
     * D. copies the other hunter's position and direction
     *
     * @param original THe other hunter
     */
    public Phil(Hunter original){
        super(original);
    }

    /**
     * Phil does not have a special.
     * @return Always false.
     */
    @Override
    public boolean isSpecialActive(){

        return false;
    }

}
