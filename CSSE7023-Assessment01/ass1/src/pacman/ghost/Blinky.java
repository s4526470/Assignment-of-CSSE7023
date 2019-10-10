package pacman.ghost;

/**
 * A class represents ghost called Blinky.
 */
public class Blinky extends Ghost {

    /**
     * Creates a Blinky ghost with all the ghost attributes.
     */
    public Blinky(){
        super();
    }

    /**
     * Get the color from the Blinky ghost
     *
     * @return The color from the Blinky ghost
     */
    @Override
    public String getColour() {
        return "#d54e53";
    }

    /**
     * Get the type of the ghost
     *
     * @return The type of the ghost
     */
    @Override
    public GhostType getType() {
        return GhostType.BLINKY;
    }
}
