package pacman.ghost;

/**
 * A class represents ghost called Inky.
 */
public class Inky extends Ghost{

    /**
     * Creates a Inky ghost with all the ghost attributes.
     */
    public Inky(){
        super();
    }

    /**
     * Get the color from the Inky ghost
     *
     * @return The color from the Inky ghost
     */
    @Override
    public String getColour() {
        return "#7aa6da";
    }

    /**
     * Get the type of the ghost
     *
     * @return The type of the ghost
     */
    @Override
    public GhostType getType() {
        return GhostType.INKY;
    }
}
