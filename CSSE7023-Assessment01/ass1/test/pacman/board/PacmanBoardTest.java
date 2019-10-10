package pacman.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pacman.util.Position;

import static org.junit.Assert.*;

public class PacmanBoardTest {
    private PacmanBoard pacmanBoard1;
    private PacmanBoard pacmanBoardForNull;
    private BoardItem boardItemForNull;
    private Position position1;
    private Position position2;
    private Position position3;
    private Position position4;
    private Position position5;
    private Position position6;
    private Position positionForBound1;
    private Position positionForBound2;
    private Position invalidPosition1;
    private Position invalidPosition2;
    private Position invalidPosition3;
    private Position invalidPosition4;
    private Position positionForNull;


    @Before
    public void setUp() throws Exception {
        pacmanBoard1 = new PacmanBoard(5, 5);
        pacmanBoardForNull = null;
        boardItemForNull = null;
        positionForNull = null;
        position1 = new Position(1, 1);
        position2 = new Position(1, 2);
        position3 = new Position(1, 3);
        position4 = new Position(2, 2);
        position5 = new Position(2, 3);
        position6 = new Position(3, 3);
        positionForBound1 = new Position(0 ,0);
        positionForBound2 = new Position(4 ,4);
        invalidPosition1 = new Position(5, 2);
        invalidPosition2 = new Position(2, 5);
        invalidPosition3 = new Position(0, -1);
        invalidPosition4 = new Position(-1, 0);


    }

    @After
    public void tearDown() throws Exception {
        pacmanBoard1 = null;


    }

    @Test
    public void testConstructor1(){
        int height = pacmanBoard1.getHeight();
        int width = pacmanBoard1.getWidth();

        for (int m = 0; m < height; m++){
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(m , 0)));
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(m , width - 1)));
        }

        for (int m = 0; m < width; m++){
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(0 , m)));
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(height - 1 , m)));
        }

        for (int m = 1; m < height - 1; m++){
            for (int n = 1; n < width - 1; n++){
                assertEquals(BoardItem.NONE,
                        pacmanBoard1.getEntry​(new Position(m, n)));
            }
        }

    }

    @Test
    public void testConstructor2(){
        pacmanBoard1.setEntry​(position1, BoardItem.BIG_DOT);
        PacmanBoard pacmanBoardForTest = new PacmanBoard(pacmanBoard1);
        assertEquals(5, pacmanBoardForTest.getHeight());
        assertEquals(5, pacmanBoardForTest.getWidth());
        assertEquals(BoardItem.BIG_DOT, pacmanBoardForTest.getEntry​(position1));

        pacmanBoard1.reset();
        assertEquals(BoardItem.BIG_DOT, pacmanBoardForTest.getEntry​(position1));

    }

    @Test
    public void testGetWidth() {
        assertEquals(5, pacmanBoard1.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(5, pacmanBoard1.getHeight());
    }

    @Test
    public void testSetEntry(){
        pacmanBoard1.setEntry​(position6, BoardItem.PACMAN_SPAWN);
        pacmanBoard1.setEntry​(position4, BoardItem.PACMAN_SPAWN);
        assertEquals(BoardItem.NONE, pacmanBoard1.getEntry​(position6));
        assertEquals(BoardItem.PACMAN_SPAWN, pacmanBoard1.getEntry​(position4));

        pacmanBoard1.setEntry​(position1, BoardItem.GHOST_SPAWN);
        pacmanBoard1.setEntry​(position2, BoardItem.GHOST_SPAWN);
        assertEquals(BoardItem.NONE, pacmanBoard1.getEntry​(position1));
        assertEquals(BoardItem.GHOST_SPAWN, pacmanBoard1.getEntry​(position2));

        pacmanBoard1.setEntry​(position5, BoardItem.BIG_DOT);
        assertEquals(BoardItem.BIG_DOT, pacmanBoard1.getEntry​(position5));
    }


    @Test
    public void testGetEntry(){
        assertEquals(BoardItem.WALL, pacmanBoard1.getEntry​(positionForBound2));
        assertEquals(BoardItem.NONE, pacmanBoard1.getEntry​(position1));
        pacmanBoard1.setEntry​(position6, BoardItem.GHOST_SPAWN);
        assertEquals(BoardItem.GHOST_SPAWN, pacmanBoard1.getEntry​(position6));
    }


    @Test
    public void testEatDot(){
        pacmanBoard1.setEntry​(position6, BoardItem.DOT);
        assertEquals(BoardItem.DOT, pacmanBoard1.eatDot​(position6));
        assertEquals(BoardItem.NONE, pacmanBoard1.getEntry​(position6));

        pacmanBoard1.setEntry​(position4, BoardItem.BIG_DOT);
        assertEquals(BoardItem.BIG_DOT_SPAWN, pacmanBoard1.eatDot​(position4));

        pacmanBoard1.setEntry​(position1, BoardItem.PACMAN_SPAWN);
        assertEquals(BoardItem.PACMAN_SPAWN, pacmanBoard1.eatDot​(position1));

        pacmanBoard1.setEntry​(position2, BoardItem.GHOST_SPAWN);
        assertEquals(BoardItem.GHOST_SPAWN, pacmanBoard1.eatDot​(position2));

        pacmanBoard1.setEntry​(position3, BoardItem.BIG_DOT_SPAWN);
        assertEquals(BoardItem.BIG_DOT_SPAWN, pacmanBoard1.eatDot​(position3));

        assertEquals(BoardItem.NONE, pacmanBoard1.eatDot​(position5));
        assertEquals(BoardItem.WALL, pacmanBoard1.eatDot​(positionForBound1));

    }

    @Test
    public void testGetGhostSpawn() {
        pacmanBoard1.setEntry​(position6, BoardItem.GHOST_SPAWN);
        assertEquals(position6, pacmanBoard1.getGhostSpawn());

        pacmanBoard1.setEntry​(position6, BoardItem.NONE);
        assertEquals(null, pacmanBoard1.getGhostSpawn());
    }

    @Test
    public void testGetPacmanSpawn() {
        pacmanBoard1.setEntry​(position6, BoardItem.PACMAN_SPAWN);
        assertEquals(position6, pacmanBoard1.getPacmanSpawn());

        pacmanBoard1.setEntry​(position6, BoardItem.NONE);
        assertEquals(null, pacmanBoard1.getPacmanSpawn());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pacmanBoard1.isEmpty());
        pacmanBoard1.setEntry​(position4, BoardItem.GHOST_SPAWN);
        assertTrue(pacmanBoard1.isEmpty());
        pacmanBoard1.setEntry​(position1, BoardItem.DOT);
        assertFalse(pacmanBoard1.isEmpty());
        pacmanBoard1.setEntry​(position3, BoardItem.BIG_DOT);
        assertFalse(pacmanBoard1.isEmpty());
    }

    @Test
    public void testReset() {
        pacmanBoard1.setEntry​(position1, BoardItem.PACMAN_SPAWN);
        pacmanBoard1.setEntry​(position2, BoardItem.GHOST_SPAWN);
        pacmanBoard1.setEntry​(position3, BoardItem.BIG_DOT_SPAWN);
        pacmanBoard1.reset();
        assertEquals(BoardItem.WALL,
                pacmanBoard1.getEntry​(new Position(0, 0)));
        assertEquals(BoardItem.BIG_DOT, pacmanBoard1.getEntry​(position3));
        assertEquals(BoardItem.GHOST_SPAWN, pacmanBoard1.getEntry​(position2));
        assertEquals(BoardItem.PACMAN_SPAWN, pacmanBoard1.getEntry​(position1));

        for (int m = 2; m < 4; m++){
            for (int n = 1; n < 4; n++){
                assertEquals(BoardItem.DOT,
                        pacmanBoard1.getEntry​(new Position(m, n)));
            }
        }

        int width = pacmanBoard1.getWidth();
        int height = pacmanBoard1.getHeight();
        for (int m = 0; m < height; m++){
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(m , 0)));
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(m , width - 1)));
        }

        for (int m = 0; m < width; m++){
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(0 , m)));
            assertEquals(BoardItem.WALL,
                    pacmanBoard1.getEntry​(new Position(height - 1 , m)));
        }

    }

    @Test
    public void testIndexOutOfBoundExceptionForSetEntry(){
        try{
            pacmanBoard1.setEntry​(invalidPosition2, BoardItem.GHOST_SPAWN);
            fail("expected exception of setEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.setEntry​(invalidPosition1, BoardItem.GHOST_SPAWN);
            fail("expected exception of setEntry method was not occured");

        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.setEntry​(invalidPosition3, BoardItem.PACMAN_SPAWN);
            fail("expected exception of setEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.setEntry​(invalidPosition4, BoardItem.PACMAN_SPAWN);
            fail("expected exception of setEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

    }

    @Test
    public void testIndexOutOfBoundExceptionForGetEntry(){
        try{
            pacmanBoard1.getEntry​(invalidPosition2);
            fail("expected exception of getEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.getEntry​(invalidPosition1);
            fail("expected exception of getEntry method was not occured");

        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.getEntry​(invalidPosition3);
            fail("expected exception of getEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.getEntry​(invalidPosition4);
            fail("expected exception of getEntry method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }
    }

    @Test
    public void testIndexOutOfBoundExceptionForEatDog(){
        try{
            pacmanBoard1.eatDot​(invalidPosition2);
            fail("expected exception of eatDot method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.eatDot​(invalidPosition1);
            fail("expected exception of eatDot method was not occured");

        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.eatDot​(invalidPosition3);
            fail("expected exception of eatDot method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }

        try{
            pacmanBoard1.eatDot​(invalidPosition4);
            fail("expected exception of eatDot method was not occured");
        }catch(IndexOutOfBoundsException ex){

        }
    }

    @Test
    public void testIllegalArgumentException(){
        try{
            pacmanBoard1 = new PacmanBoard(-1, 1);
            fail("expected exception of constructor was not occured");
        }catch(IllegalArgumentException ex){

        }

        try{
            pacmanBoard1 = new PacmanBoard(1, -1);
            fail("expected exception of constructor was not occured");
        }catch(IllegalArgumentException ex){

        }

        try{
            pacmanBoard1 = new PacmanBoard(1, 0);
            fail("expected exception of constructor was not occured");
        }catch(IllegalArgumentException ex){

        }

        try{
            pacmanBoard1 = new PacmanBoard(0, 1);
            fail("expected exception of constructor was not occured");
        }catch(IllegalArgumentException ex){

        }
    }

    @Test
    public void testNullPointerExceptionForConstructor(){
        try{
            pacmanBoard1 = new PacmanBoard(pacmanBoardForNull);
            fail("expected exception of constructor was not occured");
        }catch(NullPointerException ex){

        }

    }

    @Test
    public void testNullPointerExceptionForSetEntry(){
        try{
            pacmanBoard1.setEntry​(positionForNull, BoardItem.NONE);
            fail("expected exception of setEntry method was not occured");
        }catch(NullPointerException ex){

        }

        try{
            pacmanBoard1.setEntry​(position1, boardItemForNull);
            fail("expected exception of setEntry method was not occured");
        }catch(NullPointerException ex){

        }


    }

    @Test
    public void testNullPointerExceptionForGetEntry(){
        try{
            pacmanBoard1.getEntry​(positionForNull);
            fail("expected exception of getEntry method was not occured");
        }catch(NullPointerException ex){

        }
    }

    @Test
    public void testNullPointerExceptionForEatDot(){
        try{
            pacmanBoard1.eatDot​(positionForNull);
            fail("expected exception of eatDot method was not occured");
        }catch(NullPointerException ex){

        }
    }
}