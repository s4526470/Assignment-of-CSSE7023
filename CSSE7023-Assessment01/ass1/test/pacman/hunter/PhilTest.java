package pacman.hunter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pacman.ghost.Blinky;
import pacman.ghost.Ghost;
import pacman.ghost.Phase;
import pacman.util.Direction;
import pacman.util.Position;

import static org.junit.Assert.*;

public class PhilTest {

    private Phil h1;
    private Phil h2;
    private Ghost g1;
    private Position position1;
    private Position position2;

    @Before
    public void setUp() throws Exception {
        h1 = new Phil();
        position1 = new Position(1, 1);
        position2 = new Position(0, 0);
    }

    @After
    public void tearDown() throws Exception {
        h1 = null;
    }

    @Test
    public void testConstructor1(){
        h2 = new Phil();
        h2.setPosition​(position1);
        h2.setDirection​(Direction.DOWN);
        g1 = new Blinky();
        g1.setPosition​(position1);
        h2.hit​(g1);
        h1 = new Phil(h2);
        assertTrue(h1.isDead());
        assertFalse(h1.isSpecialActive());
        assertEquals(0, h1.getSpecialDurationRemaining());
        assertEquals(position1, h1.getPosition());
        assertEquals(Direction.DOWN, h1.getDirection());

    }

    @Test
    public void testConstructor2(){
        h2 = new Phil();
        h2.setPosition​(position1);
        h2.setDirection​(Direction.DOWN);
        h2.activateSpecial​(10);
        g1 = new Blinky();
        g1.setPosition​(position1);
        h2.hit​(g1);
        assertFalse(g1.isDead());
        h1 = new Phil(h2);
        assertTrue(h1.isDead());
        assertFalse(h1.isSpecialActive());
        assertEquals(10, h1.getSpecialDurationRemaining());
        assertEquals(position1, h1.getPosition());
        assertEquals(Direction.DOWN, h1.getDirection());
    }


    @Test
    public void testHit1(){
        h1 = new Phil();
        h1.setPosition​(position1);
        g1 = new Blinky();
        g1.setPosition​(position1);
        g1.setPhase​(Phase.FRIGHTENED, 10);
        h1.hit​(g1);
        assertFalse(h1.isDead());
        assertTrue(g1.isDead());
    }

    @Test
    public void testHit2(){
        h1 = new Phil();
        h1.setPosition​(position1);
        g1 = new Blinky();
        g1.setPosition​(position1);
        g1.setPhase​(Phase.CHASE, 10);
        h1.hit​(g1);
        assertTrue(h1.isDead());
        assertFalse(g1.isDead());
    }

    @Test
    public void testHit3(){
        h1 = new Phil();
        h1.setPosition​(position1);
        h1.activateSpecial​(10);
        g1 = new Blinky();
        g1.setPosition​(position1);
        g1.setPhase​(Phase.CHASE, 10);
        h1.hit​(g1);
        assertTrue(h1.isDead());
        assertFalse(g1.isDead());
    }

    @Test
    public void testHit4(){
        h1 = new Phil();
        h1.setPosition​(position1);
        h1.activateSpecial​(10);
        g1 = new Blinky();
        g1.setPosition​(position1);
        g1.setPhase​(Phase.FRIGHTENED, 10);
        h1.hit​(g1);
        assertFalse(h1.isDead());
        assertTrue(g1.isDead());
    }


    @Test
    public void testReset(){
        h1 = new Phil();
        h1.setPosition​(position1);
        h1.activateSpecial​(10);
        g1 = new Blinky();
        g1.setPosition​(position1);
        g1.setPhase​(Phase.CHASE, 10);
        h1.hit​(g1);
        h1.reset();
        assertFalse(h1.isDead());
        assertFalse(h1.isSpecialActive());
        assertEquals(0, h1.getSpecialDurationRemaining());
        assertEquals(Direction.UP, h1.getDirection());
        assertEquals(position2, h1.getPosition());
    }

    @Test
    public void testActivateSpecial1(){
        h1 = new Phil();
        h1.activateSpecial​(10);
        assertEquals(10 ,h1.getSpecialDurationRemaining());
        h1.activateSpecial​(5);
        assertEquals(10, h1.getSpecialDurationRemaining());

    }

    @Test
    public void testActivateSpecial2(){
        h1 = new Phil();
        h1.activateSpecial​(-2);
        assertFalse(h1.isSpecialActive());

        h1.activateSpecial​(0);
        assertFalse(h1.isSpecialActive());

    }

    @Test
    public void testRemaining(){
        h1 = new Phil();
        h1.activateSpecial​(-2);
        assertEquals(0, h1.getSpecialDurationRemaining());

        h1.activateSpecial​(0);
        assertEquals(0, h1.getSpecialDurationRemaining());

        h1.activateSpecial​(5);
        assertEquals(5, h1.getSpecialDurationRemaining());
    }

    @Test
    public void testIsSpecialActive(){
        h1 = new Phil();
        h1.activateSpecial​(10);
        assertFalse(h1.isSpecialActive());
    }
}