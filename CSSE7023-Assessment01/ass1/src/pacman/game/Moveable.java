package pacman.game;

import pacman.util.Direction;
import pacman.util.Position;

/**
 * An interface that can move with a current position and a direction.
 */
public interface Moveable {

    /**
     * Set the position to the entity.
     * If the position is null, then this position will not be set.
     *
     * @param position The position to be set
     */
    void setPosition​(Position position);

    /**
     * Get the position from the entity.
     *
     * @return The position from the entity.
     */
    Position getPosition();

    /**
     * Set the direction to the entity.
     * If the direction is null, then this direction will not be set.
     *
     * @param direction  The direction to be set
     */
    void setDirection​(Direction direction);

    /**
     * Get the direction from the entity.
     *
     * @return The direction from the entity.
     */
    Direction getDirection();

}
