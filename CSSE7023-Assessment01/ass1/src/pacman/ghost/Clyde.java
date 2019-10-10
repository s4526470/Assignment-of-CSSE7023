package pacman.ghost;

/**
 * A class represents ghost called Clyde.
 */
public class Clyde extends Ghost{

    /**
     * Creates a Clyde ghost with all the ghost attributes.
     */
    public Clyde(){
        super();
    }

    /**
     * Get the color from the Clyde ghost
     *
     * @return The color from the Clyde ghost
     */
    @Override
    public String getColour() {
        return "#e78c45";
    }

    /**
     * Get the type of the ghost
     *
     * @return The type of the ghost
     */
    @Override
    public GhostType getType() {
        return GhostType.CLYDE;
    }
}
