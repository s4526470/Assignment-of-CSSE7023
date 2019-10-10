package pacman.ghost;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pacman.util.Direction;
import pacman.util.Position;

import static org.junit.Assert.*;

public class PinkyTest {
    private Pinky ghose1;
    private Pinky ghose2;
    private Position position1;
    private Position position2;

    @Before
    public void setUp() throws Exception {
        ghose1 = new Pinky();
        position1 = new Position(0, 0);
        position2 = new Position(1, 1);
    }

    @After
    public void tearDown() throws Exception {
        ghose1 = null;
    }

    @Test
    public void testGetColour() {
        assertEquals("#c397d8", ghose1.getColour());
    }

    @Test
    public void testGetType() {
        assertEquals(GhostType.PINKY, ghose1.getType());
    }

    @Test
    public void testKill(){
        assertFalse(ghose1.isDead());
        ghose1.kill();
        assertTrue(ghose1.isDead());
    }

    @Test
    public void testIsDead(){
        assertFalse(ghose1.isDead());
        ghose1.kill();
        assertTrue(ghose1.isDead());
    }

    @Test
    public void testRest(){
        ghose1.kill();
        ghose1.setPosition​(position2);
        ghose1.setDirection​(Direction.DOWN);
        ghose1.setPhase​(Phase.FRIGHTENED, 100);
        ghose1.reset();
        assertFalse(ghose1.isDead());
        assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), ghose1.phaseInfo());


    }

    @Test
    public void testSetPhase1(){
        assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), ghose1.phaseInfo());
        ghose1.setPhase​(Phase.FRIGHTENED, 1000);
        assertEquals(Phase.FRIGHTENED + ":" + 1000, ghose1.phaseInfo());
        ghose1.setPhase​(Phase.FRIGHTENED, -1);
        assertEquals(Phase.FRIGHTENED + ":" + 0, ghose1.phaseInfo());

    }

    @Test
    public void testGetPhase(){
        assertEquals(Phase.SCATTER, ghose1.getPhase());
        ghose1.setPhase​(Phase.FRIGHTENED, 1000);
        assertEquals(Phase.FRIGHTENED, ghose1.getPhase());
    }

    @Test
    public void testConstructor(){
        assertEquals(position1, ghose1.getPosition());
        assertEquals(Direction.UP, ghose1.getDirection());
        assertEquals(Phase.SCATTER + ":" + Phase.SCATTER.getDuration(), ghose1.phaseInfo());
    }


}