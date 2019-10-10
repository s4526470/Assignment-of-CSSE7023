package pacman.game;

import pacman.util.Direction;
import pacman.util.Position;

/**
 * A very general class represents the entities of the game.
 */
public abstract class Entity implements Moveable{

    /**
     * The entities' position
     */
    private Position position;

    /**
     * The entities' direction
     */
    private Direction direction;

    /**
     * Create an entity with the position is (0,0)
     * and the facing up direction.
     */
    public Entity(){
        this.position = new Position(0, 0);
        this.direction = Direction.UP;
    }

    /**
     * Create an entity with the customized position
     * and direction.
     *
     * @param position The position to be set for the entity.
     * @param direction The direction to be set for the entity
     */
    public Entity(Position position, Direction direction){
        if (position == null){
            this.position = new Position(0, 0);
        }else{
            this.position = position;
        }

        if (direction == null){
            this.direction = Direction.UP;
        }else{
            this.direction = direction;
        }
    }

    /**
     * Get the entities' position
     *
     * @return The entities' position
     */
    public Position getPosition(){
        return this.position;
    }

    /**
     * Set the position of the entity.
     * If position is null, the position is not set.
     *
     * @param position The position to be set for the entity.
     */
    public void setPosition​(Position position){
        if (position != null){
            this.position = position;
        }
    }

    /**
     * Get the direction that this Moveable is facing.
     *
     * @return The direction that this moveable is facing.
     */
    public Direction getDirection(){
        return this.direction;
    }

    /**
     * Set the direction of the entity.
     * If the direction is null, the previous direction is remained.
     *
     * @param direction The direction to be set.
     */
    public void setDirection​(Direction direction){
        if (direction != null){
            this.direction = direction;
        }

    }

}
