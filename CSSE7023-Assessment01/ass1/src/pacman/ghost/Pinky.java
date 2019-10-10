package pacman.ghost;

/**
 * A class represents ghost called Pinky.
 */
public class Pinky extends Ghost{

    /**
     * Creates a Pinky ghost with all the ghost attributes.
     */
    public Pinky(){
        super();
    }

    /**
     * Get the color from the Pinky ghost
     *
     * @return The color from the Pinky ghost
     */
    @Override
    public String getColour() {
        return "#c397d8";
    }

    /**
     * Get the type of the ghost
     *
     * @return The type of the ghost
     */
    @Override
    public GhostType getType() {
        return GhostType.PINKY;
    }


}
