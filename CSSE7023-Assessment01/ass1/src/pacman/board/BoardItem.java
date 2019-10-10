package pacman.board;

public enum BoardItem {
    /**
     * A nothing item
     */
    NONE,

    /**
     * A wall tile
     */
    WALL,

    /**
     * A dot
     */
    DOT,

    /**
     * A big dot
     */
    BIG_DOT,

    /**
     * A big dot spawn point
     */
    BIG_DOT_SPAWN,

    /**
     * A spawn point for GHOSTS
     */
    GHOST_SPAWN,

    /**
     * A spawn point for PACMAN
     */
    PACMAN_SPAWN;

    /**
     * Return the score relating to the different items.
     *
     * @return The score from different items.
     */
    public int getScore(){
        switch(this){
            case NONE: return 0;
            case WALL: return 0;
            case DOT: return 10;
            case BIG_DOT: return 15;
            case BIG_DOT_SPAWN: return 0;
            case GHOST_SPAWN: return 0;
            case PACMAN_SPAWN: return 0;
            default:
                throw new IllegalArgumentException("The BoardItem not exists");
        }
    }

    /**
     * Checks if the item is pathable
     *
     * @return whether the item is pathable.
     */
    public boolean getPathable(){
        switch(this){
            case NONE: return true;
            case WALL: return false;
            case DOT: return true;
            case BIG_DOT: return true;
            case BIG_DOT_SPAWN: return true;
            case GHOST_SPAWN: return true;
            case PACMAN_SPAWN: return true;
            default:
                throw new IllegalArgumentException("The BoardItem not exists");
        }
    }

    /**
     * Retrieve the character keys from the item
     *
     * @return The character keys from the item
     */
    public char getChar(){
        switch(this){
            case NONE: return '0';
            case WALL: return 'X';
            case DOT: return '1';
            case BIG_DOT: return 'B';
            case BIG_DOT_SPAWN: return 'b';
            case GHOST_SPAWN: return '$';
            case PACMAN_SPAWN: return 'P';
            default:
                throw new IllegalArgumentException("The BoardItem not exists");
        }


    }

    /**
     * Takes the character and return the relating item.
     *
     * @param key A key represents the board item
     * @return The corresponding character from the item.
     * @throws IllegalArgumentException
     * If the character is not part of the supported Items
     */
    public static BoardItem getItem​(char key) throws IllegalArgumentException{

        switch(key){
            case '0': return BoardItem.NONE;
            case 'X': return BoardItem.WALL;
            case '1': return BoardItem.DOT;
            case 'B': return BoardItem.BIG_DOT;
            case 'b': return BoardItem.BIG_DOT_SPAWN;
            case '$': return BoardItem.GHOST_SPAWN;
            case 'P': return BoardItem.PACMAN_SPAWN;
            default:
                throw new IllegalArgumentException("The key not exists");
        }
    }

}
