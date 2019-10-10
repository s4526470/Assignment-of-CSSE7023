package pacman.score;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard1;
    private ScoreBoard scoreBoard2;
    private List<String> list1;
    private List<String> list2;
    private Map<String ,Integer> Map1;
    private Map<String ,Integer> invalidMap1;
    private Map<String ,Integer> invalidMap2;
    private Map<String ,Integer> invalidMap3;

    @Before
    public void setUp() throws Exception {
        scoreBoard1 = new ScoreBoard();
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        invalidMap1 = new HashMap<String, Integer>();
        invalidMap2 = new HashMap<String, Integer>();
        invalidMap2 = new HashMap<String, Integer>();
    }

    @After
    public void tearDown() throws Exception {
        scoreBoard1 = null;
    }

    @Test
    public void testConstructor(){
        assertTrue(scoreBoard1.getEntriesByName().isEmpty());
        assertTrue(scoreBoard1.getEntriesByScore().isEmpty());
        assertEquals(0, scoreBoard1.getScore());
    }

    @Test
    public void testGetEntriesByName() {
        scoreBoard1.setScore​("a", 20);
        scoreBoard1.setScore​("b", 30);
        scoreBoard1.setScore​("4", 10);
        scoreBoard1.setScore​("5", 50);
        scoreBoard1.setScore​("X", 40);
        scoreBoard1.setScore​("Y", 15);

        list1.add("4 : 10");
        list1.add("5 : 50");
        list1.add("X : 40");
        list1.add("Y : 15");
        list1.add("a : 20");
        list1.add("b : 30");

        assertEquals(list1, scoreBoard1.getEntriesByName());

    }

    @Test
    public void testGetEntriesByScore() {
        scoreBoard1.setScore​("a", 20);
        scoreBoard1.setScore​("b", 30);
        scoreBoard1.setScore​("4", 10);
        scoreBoard1.setScore​("5", 50);
        scoreBoard1.setScore​("X", 40);
        scoreBoard1.setScore​("Y", 15);

        list1.add("5 : 50");
        list1.add("X : 40");
        list1.add("b : 30");
        list1.add("a : 20");
        list1.add("Y : 15");
        list1.add("4 : 10");

        assertEquals(list1, scoreBoard1.getEntriesByScore());

    }


    @Test
    public void testSetScore(){
        scoreBoard1.setScore​(null, 100);
        assertTrue(scoreBoard1.getEntriesByScore().isEmpty());
        assertTrue(scoreBoard1.getEntriesByName().isEmpty());

        scoreBoard1.setScore​("A)d", 100);
        assertTrue(scoreBoard1.getEntriesByScore().isEmpty());
        assertTrue(scoreBoard1.getEntriesByName().isEmpty());

        scoreBoard1.setScore​("Ad", -1);
        assertTrue(scoreBoard1.getEntriesByScore().isEmpty());
        assertTrue(scoreBoard1.getEntriesByName().isEmpty());

        scoreBoard1.setScore​("Ad", 100);
        assertEquals("Ad : 100", scoreBoard1.getEntriesByName().get(0));
        assertEquals("Ad : 100", scoreBoard1.getEntriesByScore().get(0));

        scoreBoard1.setScore​("Ad", 10);
        assertEquals("Ad : 10", scoreBoard1.getEntriesByName().get(0));
        assertEquals("Ad : 10", scoreBoard1.getEntriesByScore().get(0));


    }

    @Test
    public void testSetScores() {

        scoreBoard1.setScore​("Bc", 30);
        invalidMap1.put("**", 100);
        invalidMap1.put(null, 20);
        invalidMap1.put("Ce", -10);
        invalidMap1.put("Ad", 50);
        list1.add("Ad : 50");
        list1.add("Bc : 30");
        scoreBoard1.setScores(invalidMap1);
        assertEquals(list1, scoreBoard1.getEntriesByName());
        assertEquals(list1, scoreBoard1.getEntriesByScore());

        invalidMap1.put("Bc", 40);
        list1.remove(1);
        list1.add("Bc : 40");
        scoreBoard1.setScores(invalidMap1);
        assertEquals(list1, scoreBoard1.getEntriesByName());
        assertEquals(list1, scoreBoard1.getEntriesByScore());

        invalidMap1 = null;
        scoreBoard1.setScores(invalidMap1);
        assertEquals(list1, scoreBoard1.getEntriesByName());
        assertEquals(list1, scoreBoard1.getEntriesByScore());

    }

    @Test
    public void testIncreaseScore(){
        scoreBoard1.increaseScore​(5);
        assertEquals(5, scoreBoard1.getScore());
    }

    @Test
    public void testGetScore() {
        scoreBoard1.increaseScore​(5);
        assertEquals(5, scoreBoard1.getScore());
    }

    @Test
    public void testReset() {
        scoreBoard1.increaseScore​(5);
        scoreBoard1.reset();
        assertEquals(0, scoreBoard1.getScore());
    }


}