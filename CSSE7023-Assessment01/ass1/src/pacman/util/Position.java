package pacman.util;

/**
 * A class represents the entity's position
 */
public class Position{

    /**
     * x coordinate
     */
    private int x;

    /**
     * y coordinate
     */
    private int y;

    /**
     * Creates a position at given
     * x and y coordinates
     *
     * @param x Given x coordinate
     * @param y Given y coordinate
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieve the X axis location
     *
     * @return The x axis location
     */
    public int getX(){
        return this.x;
    }

    /**
     * Retrieve the Y axis location
     *
     * @return The y axis location
     */
    public int getY(){
        return this.y;
    }

    /**
     * Calculate the distance from this position and
     * other given position.
     *
     * @param other Given other position
     * @return The distance between two positions
     */
    public double distance (Position other){
        return Math.sqrt((other.y - this.y) * (other.y - this.y)
                + (other.x - this.x) * (other.x - this.x));
    }

    /**
     * Add two position together.
     *
     * @param other Given other position.
     * @return The result of adding two position together.
     */
    public Position add(Position other){
        return new Position(other.x + this.x, other.y + this.y);
    }

    /**
     * Multiply by the given factor on the x and y axises.
     *
     * @param factor Given factor to be multiplied.
     * @return The result of multiplying by the factor and position.
     */
    public Position multiply​(int factor){
        return new Position(this.x * factor, this.y * factor);

    }

    /**
     * Checks if two positions are equal.
     *
     * @param other The other given position
     * @return The result whether these two positions are equal.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Position)){
            return false;
        }else{
            return ((Position)other).x == this.x
                    && ((Position)other).y == this.y;
        }
    }

    /**
     * Computes the hash of the position.
     *
     * @return Hash of this position.
     */
    @Override
    public int hashCode(){

        return this.x * 5 + this.y * 61;
    }


}
