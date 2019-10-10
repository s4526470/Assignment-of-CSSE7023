package pacman.board;

import pacman.util.Position;

/**
 * A class represents the board of Pac Man Game
 */
public class PacmanBoard {

    /**
     * The height of pacman board
     */
    private int height;

    /**
     * The width of pacman board
     */
    private int width;

    /**
     * The 2D Array for storing the item.
     */
    private BoardItem[][] pacmanBoard;

    /**
     * Get the width and height and create a board
     * which is filled with BoardItem.NONE
     * except one block wide board wall(BoardItem.WALL) around the whole board.
     *
     * @param width The width of the board.
     * @param height The height of the board.
     * @throws IllegalArgumentException
     * If the height or width less than or equal to 0.
     */
    public PacmanBoard(int width, int height) throws IllegalArgumentException{
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("invalid width or height");
        }

        this.height = height;
        this.width = width;
        this.pacmanBoard = new BoardItem[this.height][this.width];

        // Put the BoardItem.WALL in the pacman board
        for (int i = 0; i < this.height; i++) {
            pacmanBoard[i][0] = BoardItem.WALL;
            pacmanBoard[i][width - 1] = BoardItem.WALL;
        }

        for(int i = 0; i < this.width; i++) {
            pacmanBoard[0][i] = BoardItem.WALL;
            pacmanBoard[height - 1][i] = BoardItem.WALL;
        }

        // Put the BoardItem.NONE to the pacman board
        for (int i =1; i < this.height - 1; i++) {
            for (int j = 1; j < this.width - 1; j++) {
                pacmanBoard[i][j] = BoardItem.NONE;
            }
        }


    }

    /**
     * Make a deep copy for the existed PacmanBoard.
     *
     * @param other The existed PacmanBoard.
     * @throws NullPointerException If the existed PacmanBoard is null.
     */
    public PacmanBoard(PacmanBoard other) throws NullPointerException{
        if (other == null){
            throw new NullPointerException("copy is null");
        }
        this.height = other.getHeight();
        this.width = other.getWidth();
        this.pacmanBoard = new BoardItem[this.height][this.width];

        // deep copy for existed PacmanBoard
        for (int i = 0; i < pacmanBoard.length; i++){
            for (int j = 0; j < pacmanBoard[i].length; j++){
                pacmanBoard[i][j] = other.getEntry​(new Position(i, j));
            }
        }
    }

    /**
     * Return the width of current PacmanBoard
     *
     * @return the width of current PacmanBoard
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Return the height of current PacmanBoard
     *
     * @return the height of current PacmanBoard
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * Sets a tile on the board to item. If the item to be
     * set is a BoardItem.PACMAN_SPAWN but BoardItem.PACMAN_SPAWN
     * has already existed. Then let the old BoardItem.PACMAN_SPAWN
     * be BoardItem.NONE.
     *
     * Sets a tile on the board to item. If the item to be
     * set is a BoardItem.GHOST_SPAWN but BoardItem.GHOST_SPAWN
     * has already existed. Then let the old BoardItem.GHOST_SPAWN
     * be BoardItem.NONE.
     *
     * @param position The location that will be set.
     * @param item The item that will be set.
     * @throws IndexOutOfBoundsException If the position out of the board bound.
     * @throws NullPointerException If the position or item is null.
     */
    public void setEntry​(Position position, BoardItem item)
            throws IndexOutOfBoundsException, NullPointerException{
        boolean xCoordinateOutOfBound
                = position.getX() < 0 || position.getX() > this.width - 1;

        boolean yCoordinateOutOfBound
                = position.getY() < 0 || position.getY() > this.height - 1;

        if (xCoordinateOutOfBound || yCoordinateOutOfBound){
            throw new IndexOutOfBoundsException("Position out of bound");
        }

        if (position == null || item == null){
            throw new NullPointerException("Position or item is null");
        }

        // Judge whether the PACMAN_SPAWN has existed
        // and then put it in the board
        if (item == BoardItem.PACMAN_SPAWN){
            for (int i = 0; i < this.pacmanBoard.length; i++){
                for (int j = 0; j < this.pacmanBoard[i].length; j++){
                    if (this.pacmanBoard[i][j] == BoardItem.PACMAN_SPAWN){
                        this.pacmanBoard[i][j] = BoardItem.NONE;
                    }
                }
            }
            this.pacmanBoard[position.getX()][position.getY()] = item;

        // Judge whether the GHOST_SPAWN has existed
        // and then put it in the board
        }else if (item == BoardItem.GHOST_SPAWN){
            for (int i = 0; i < this.pacmanBoard.length; i++){
                for (int j = 0; j < this.pacmanBoard[i].length; j++){
                    if (this.pacmanBoard[i][j] == BoardItem.GHOST_SPAWN){
                        this.pacmanBoard[i][j] = BoardItem.NONE;
                    }
                }
            }
            this.pacmanBoard[position.getX()][position.getY()] = item;
        }else{
            this.pacmanBoard[position.getX()][position.getY()] = item;
        }

    }

    /**
     * Return the item from the specific position.
     *
     * @param position The target item's position.
     * @return The item from the specific position.
     * @throws IndexOutOfBoundsException If the position out of the board bound.
     * @throws NullPointerException If position is null.
     */
    public BoardItem getEntry​(Position position)
            throws IndexOutOfBoundsException, NullPointerException{
        boolean xCoordinateOutOfBound
                = position.getX() < 0 || position.getX() > this.width - 1;

        boolean yCoordinateOutOfBound
                = position.getY() < 0 || position.getY() > this.height - 1;

        if (xCoordinateOutOfBound || yCoordinateOutOfBound){
            throw new IndexOutOfBoundsException("position out of bound");
        }

        if (position == null){
            throw new NullPointerException("position is null");
        }
        return this.pacmanBoard[position.getX()][position.getY()];
    }

    /**
     * Eats the dot from the board and return the item which was eaten.
     * If the BoardItem.DOT is eaten, it is replaced with BoardItem.NONE.
     * If the BoardItem.BIG_DOT is eaten,
     * then it is replaced with a BoardItem.BIG_DOT_SPAWN.
     *
     * The other cases do nothing and return the item.
     *
     * @param position The item's(to be eaten) position
     * @return The item to be eaten
     * @throws IndexOutOfBoundsException If the position out of the board bound.
     * @throws NullPointerException If the position is null.
     */
    public BoardItem eatDot​(Position position)
            throws IndexOutOfBoundsException, NullPointerException{
        boolean xCoordinateOutOfBound
                = position.getX() < 0 || position.getX() > this.width - 1;

        boolean yCoordinateOutOfBound
                = position.getY() < 0 || position.getY() > this.height - 1;

        if (xCoordinateOutOfBound || yCoordinateOutOfBound){
            throw new IndexOutOfBoundsException("position out of bound");
        }

        if (position == null){
            throw new NullPointerException("position is null");
        }

        if (this.pacmanBoard[position.getX()][position.getY()]
                == BoardItem.DOT){
            this.pacmanBoard[position.getX()][position.getY()] = BoardItem.NONE;
            return BoardItem.DOT;
        }else if (this.pacmanBoard[position.getX()][position.getY()]
                == BoardItem.BIG_DOT){
            this.pacmanBoard[position.getX()][position.getY()]
                    = BoardItem.BIG_DOT_SPAWN;
            return BoardItem.BIG_DOT_SPAWN;
        }else{
            return this.pacmanBoard[position.getX()][position.getY()];
        }
    }

    /**
     * Get the position of ghost spawn.
     * If it does not exists ghost spawn, then return null.
     *
     * @return The position of ghost spawn.
     */
    public Position getGhostSpawn(){
        for (int i = 0; i < this.pacmanBoard.length; i++){
            for (int j = 0; j < this.pacmanBoard[i].length; j++){
                if (this.pacmanBoard[i][j] == BoardItem.GHOST_SPAWN){
                    return new Position(i, j);
                }
            }
        }

        return null;
    }

    /**
     * Get the position of pacman spawn.
     * If it does not exists pacman spawn, then return null.
     *
     * @return The position of pacman spawn.
     */
    public Position getPacmanSpawn(){
        for (int i = 0; i < this.pacmanBoard.length; i++){
            for (int j = 0; j < this.pacmanBoard[i].length; j++){
                if (this.pacmanBoard[i][j] == BoardItem.PACMAN_SPAWN){
                    return new Position(i, j);
                }
            }
        }

        return null;
    }

    /**
     * Check if the board has pickup items.
     *
     * @return True if the board dose not have DOT's or BIG_DOT's.
     */
    public boolean isEmpty(){
        for (int i = 0; i < this.pacmanBoard.length; i++){
            for (int j = 0; j < this.pacmanBoard[i].length; j++){
                if (this.pacmanBoard[i][j] == BoardItem.DOT
                        || this.pacmanBoard[i][j] == BoardItem.BIG_DOT){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  Reset the board to place a DOT in every position that
     *  has no item and respawns BIG_DOT's in the BIG_DOT_SPAWN locations.
     *  Let the walls, pacman spawns and ghost spawns in original place.
     */
    public void reset(){

        // reset the wall in original place.
        for (int i = 0; i < this.height; i++) {
            pacmanBoard[i][0] = BoardItem.WALL;
            pacmanBoard[i][width - 1] = BoardItem.WALL;
        }

        for(int i = 0; i < this.width; i++) {
            pacmanBoard[0][i] = BoardItem.WALL;
            pacmanBoard[height - 1][i] = BoardItem.WALL;
        }

        // Put DOT in every position and put BIG_DOT's
        // in the BIG_DOT_SPAWN location.
        for (int i =1; i < this.height - 1; i++) {
            for (int j = 1; j < this.width - 1; j++) {
                if (pacmanBoard[i][j] == BoardItem.BIG_DOT_SPAWN){
                    pacmanBoard[i][j] = BoardItem.BIG_DOT;
                }

                if (pacmanBoard[i][j] == BoardItem.PACMAN_SPAWN
                        || pacmanBoard[i][j] == BoardItem.GHOST_SPAWN){

                }else if (pacmanBoard[i][j] == BoardItem.NONE){
                    pacmanBoard[i][j] = BoardItem.DOT;
                }

            }
        }
    }

}
