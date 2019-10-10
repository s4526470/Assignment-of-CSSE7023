package pacman.ghost;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pacman.util.Direction;
import pacman.util.Position;

import static org.junit.Assert.*;

public class BlinkyTest {
    private Blinky blinky1;
    private Blinky blinky2;
    private Position position1;
    private Position position2;

    @Before
    public void setUp() throws Exception {
        blinky1 = new Blinky();
        position1 = new Position(0, 0);
        position2 = new Position(1, 1);
    }

    @After
    public void tearDown() throws Exception {
        blinky1 = null;
    }

    @Test
    public void testGetColour() {
        assertEquals("#d54e53", blinky1.getColour());
    }

    @Test
    public void testGetType() {
        assertEquals(GhostType.BLINKY, blinky1.getType());
    }

    @Test
    public void testKill(){
        assertFalse(blinky1.isDead());
        blinky1.kill();
        assertTrue(blinky1.isDead());
    }

    @Test
    public void testIsDead(){
        assertFalse(blinky1.isDead());
        blinky1.kill();
        assertTrue(blinky1.isDead());
    }

    @Test
    public void testRest(){
        blinky1.kill();
        blinky1.setPosition​(position2);
        blinky1.setDirection​(Direction.DOWN);
        blinky1.setPhase​(Phase.FRIGHTENED, 100);
        blinky1.reset();
        assertFalse(blinky1.isDead());
       assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), blinky1.phaseInfo());


    }

    @Test
    public void testSetPhase1(){
        assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), blinky1.phaseInfo());
        blinky1.setPhase​(Phase.FRIGHTENED, 1000);
        assertEquals(Phase.FRIGHTENED + ":" + 1000, blinky1.phaseInfo());
        blinky1.setPhase​(Phase.FRIGHTENED, -1);
        assertEquals(Phase.FRIGHTENED + ":" + 0, blinky1.phaseInfo());

    }

    @Test
    public void testGetPhase(){
        assertEquals(Phase.SCATTER, blinky1.getPhase());
        blinky1.setPhase​(Phase.FRIGHTENED, 1000);
        assertEquals(Phase.FRIGHTENED, blinky1.getPhase());
    }

    @Test
    public void testConstructor(){
        assertEquals(position1, blinky1.getPosition());
        assertEquals(Direction.UP, blinky1.getDirection());
        assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), blinky1.phaseInfo());
    }

}