package minchpy.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpeningMoves {

    private static OpeningMoves instance = null;

    private String movesPlayed;

    public static OpeningMoves getInstance() {
        if (instance == null) {
            instance = new OpeningMoves();
            instance.movesPlayed = "";
        }
        return instance;
    }

    public void logMove(String move) {
        movesPlayed += move + " ";
    }

    public String getRandomNextMovesStringBasedOnMovesPlayed() {
        String moves = null;
        List<String> movesStringList = new ArrayList<String>();
        String line = null;
        try {
            FileReader fileReader = new FileReader(
                    URLDecoder.decode(this.getClass().getResource(Constants.BOOK_TXT).getFile(), "utf-8"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //If computer plays the first move
            if(movesPlayed == null) { 
                int rand = (new Random()).nextInt(Constants.NUMBER_OF_ENTRIES_IN_BOOK_TXT);
                int lineCount = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    if(lineCount == rand) {
                        moves = line;
                        break;
                    }
                    lineCount++;
                }
            } else { 
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.startsWith(movesPlayed)) {
                        movesStringList.add(line);
                    }
                }
                if (movesStringList.size() > 0) {
                    int rand = (new Random()).nextInt(movesStringList.size());
                    moves = movesStringList.get(rand);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '");
        } catch (IOException ex) {
            System.out.println("Error reading file '");
        }
        return moves;
    }

    public String getNextOpeningMove() {
        String movesString = getRandomNextMovesStringBasedOnMovesPlayed();
        String nextMove = null;
        for (String word : movesString.split(" ")) {
            if (!movesPlayed.contains(word)) {
                nextMove = word;
                break;
            }
        }
        return nextMove;
    }

}
