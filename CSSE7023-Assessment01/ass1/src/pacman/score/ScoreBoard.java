package pacman.score;

import java.util.*;

/**
 * A class represents the board of score
 */
public class ScoreBoard {
    /**
     * The current score for the scorer.
     */
    private int currentScore;

    /**
     * The score board for store the
     * scorer's name and scorer's score
     */
    private Map<String, Integer> scoresBoard;

    /**
     * Creates a score board and let the current score be 0
     */
    public ScoreBoard(){
        this.currentScore = 0;
        this.scoresBoard = new HashMap<String, Integer>();
    }

    /**
     * Get all scorers' name and score formatted as "NAME : VALUE".
     * Stores entries order by Name in lexicographic order.
     *
     * @return List of scores formatted as "NAME : VALUE"
     * when the score board is not empty.
     */
    public List<String> getEntriesByName(){
        Map<String, Integer> scoresWithOrder = new TreeMap<>(this.scoresBoard);
        List<String> getEntriesByName = new ArrayList<String>();

        for (Map.Entry<String, Integer> entry : scoresWithOrder.entrySet()){
            getEntriesByName.add(entry.getKey() + " : " + entry.getValue());
        }

        return getEntriesByName;
    }

    /**
     * Get all scorers' name and score formatted as "NAME : VALUE".
     * Stores entries order by score in descending order.
     *
     * @return List of scores fomatted as "NAME : VALUE"
     * When the score board is not empty.
     */
    public List<String> getEntriesByScore(){
        List<String> getEntriesByScore = new ArrayList<String>();
        if (this.scoresBoard.size() == 0){
            return getEntriesByScore;
        }

        String[] scorerNames = new String[this.scoresBoard.size()];
        int[] playerScores = new int[this.scoresBoard.size()];
        int pointer = 0;


        for (Map.Entry<String, Integer> entry : scoresBoard.entrySet()){
            scorerNames[pointer] = entry.getKey();
            playerScores[pointer] = entry.getValue();
            pointer++;
        }

        // Stores entries order by score in descending order
        for (int i = 0; i < scoresBoard.size() - 1; i++){
            for (int j = 0; j < scoresBoard.size() - 1; j++){
                if (playerScores[j] < playerScores[j + 1]){
                    int temp1 = playerScores[j];
                    playerScores[j] = playerScores[j + 1];
                    playerScores[j + 1] = temp1;

                    String temp2 = scorerNames[j];
                    scorerNames[j] = scorerNames[j + 1];
                    scorerNames[j + 1] = temp2;
                }
            }
        }

        for (int i = 0; i < playerScores.length; i++) {
            getEntriesByScore.add(scorerNames[i] + " : " + playerScores[i]);
        }

        return getEntriesByScore;
    }

    /**
     * Sets the valid name and score to the score board.
     * valid setting format:
     * A. Name is not null
     * B. Name only contains 'A' ~ 'Z', 'a' ~ 'z' and '0' ~ '9' characters.
     * C. Score must be greater than and equal to 0.
     *
     * @param name The scorer's name
     * @param score The scorer's score
     */
    public void setScore​(String name, int score){

        // Judge whether the scores's name is valid.
        if (this.isValidName(name, score)){
            this.scoresBoard.put(name, score);
        }

    }

    /**
     * Sets the pairs of name and score in score board.
     * valid setting format:
     * A. Name is not null
     * B. Name only contains 'A' ~ 'Z', 'a' ~ 'z' and '0' ~ '9' characters.
     * C. Score must be greater than and equal to 0.
     * the score will be set and override any stored score for the given name,
     * otherwise it will be skipped.
     *
     * @param scores The entries of name and score, except the null value.
     */
    public void setScores(Map<String, Integer> scores){
        if (scores != null){
            for (Map.Entry<String, Integer> entry : scores.entrySet()){
                if (this.isValidName(entry.getKey(), entry.getValue())){
                    this.scoresBoard.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /**
     * Increase the addition score to the current score.
     * Increases the score if the given additional score is greater than 0.
     * If the additional score is less than or equal to 0, then does not change.
     *
     * @param additional The additional score
     */
    public void increaseScore​(int additional){
        if (additional > 0){
            this.currentScore += additional;
        }
    }

    /**
     * Get the current score
     *
     * @return The current score
     */
    public int getScore(){
        return this.currentScore;
    }

    /**
     * Set the current to 0
     */
    public void reset(){
        this.currentScore = 0;
    }

    /**
     * Help method to judge whether the name and score is valid.
     *
     * @param name The scorer's name.
     * @param score The scorer's score.
     * @return The result of the judgement.
     */
    private boolean isValidName(String name, int score){
        boolean isValidName = true;
        List<Character> validNameList = new ArrayList<Character>();

        // ASCII for '0' ~ '9'
        for (int i = 48; i <= 57; i++) {
            validNameList.add((char)i);
        }

        // ASCII for 'A' ~ 'Z'
        for (int i = 65; i <= 90; i++) {
            validNameList.add((char)i);
        }

        // ASCII for 'a' ~ 'z'
        for (int i = 97; i<= 122; i++) {
            validNameList.add((char)i);
        }

        if (name != null && score >= 0){
            for (int i = 0; i < name.length(); i++){
                if (!validNameList.contains(name.charAt(i))){
                    isValidName = false;
                }
            }
        }else{
            isValidName = false;
        }

        return isValidName;
    }
}
