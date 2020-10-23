package business_logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {

    static int tableSize;
    Fox fox;
    List<Hound> hounds;
    Boolean isFoxOnMove;
    Character[][] matrix;
    List<Move> foxPossibleMoves = null;
    List<Move> houndsPossibleMoves = null;
    Boolean isFoxWinning = null;

    public List<Move> getFoxPossibleMoves() {
        return foxPossibleMoves;
    }

    public List<Move> getHoundsPossibleMoves() {
        return houndsPossibleMoves;
    }

    public Boolean isFoxOnMOve(){
        return isFoxOnMove;
    }
    
    public void setFoxOnMove (boolean b) {
        isFoxOnMove = b;
    }
    
    public static void setTableSize(int x) {
        tableSize = x;
    }

    public static Table getStarterTable(int size) {
        setTableSize(size);
        if (size <= 3) {
            return null;
        }
        Table answer = new Table();
        answer.matrix = new Character[tableSize][tableSize];
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                answer.matrix[i][j] = ' ';
            }
        }
        answer.fox = new Fox(size - 1, 0);
        answer.matrix[size - 1][0] = 'f';
        answer.hounds = new ArrayList<>();
        for (int i = 0; i < size / 2; i++) {
            answer.hounds.add(new Hound(0, 2 * i + 1));
            answer.matrix[0][2 * i + 1] = 'h';

        }
        return answer;
    }

    public void determineFoxPossibleMoves() {
        foxPossibleMoves = new ArrayList<>();
        for (Direction dir : Direction.values()) {
            int y = fox.getY() + dir.getRowStep();
            int x = fox.getX() + dir.getColStep();
            if (   y >= 0 && x>=0 && y<tableSize && x<tableSize &&
                    matrix[y][x].equals(' ')) {
                foxPossibleMoves.add(new Move(fox, dir));
            }
        }
    }

    public void determineHoundsPossibleMovesAndFoxWinning() {
        houndsPossibleMoves = new ArrayList<>();
        isFoxWinning = true;
        for (Hound hound : hounds) {
            for (Direction dir : Arrays.asList(Direction.SOUTHEAST, Direction.SOUTHWEST)) {
                if (hound.getY()<tableSize && matrix[hound.getY() + dir.getRowStep()][hound.getX() + dir.getColStep()].equals(' ')) {
                    houndsPossibleMoves.add(new Move(hound, dir));
                    isFoxWinning = false;
                }
                if (hound.getY()<tableSize && matrix[hound.getY() + dir.getRowStep()][hound.getX() + dir.getColStep()].equals('f')) {
                    houndsPossibleMoves.add(new Move(hound, dir));
                    isFoxWinning = false;
                }

            }
        }
    }

    public boolean winHounds() {
        if (foxPossibleMoves == null) {
            determineFoxPossibleMoves();
        }
        return !isFoxOnMove && foxPossibleMoves.isEmpty();
    }

    public boolean winFox() {
        if (houndsPossibleMoves == null) {
            determineHoundsPossibleMovesAndFoxWinning();
        }
        return isFoxOnMove && isFoxWinning;
    }

    public void makeMove(Move move) {
        Figure fig = move.getMover();
        int x = fig.getX(); int y = fig.getY();
        fig.setX(x+move.getDirection().getColStep());
        fig.setY(y+move.getDirection().getRowStep());      
        isFoxOnMove = !isFoxOnMove;
        matrix[y][x] = ' ';
        if (fig instanceof Fox) {
            matrix[fig.getY()][fig.getX()] = 'f'; // thes are the new values
        }
        else { // The mover is a hound
            matrix[fig.getY()][fig.getX()] = 'h'; // thes are the new values
        }
    }

    @Override
    public String toString() {
        int size = tableSize;
        char[][] tableAsCharArray = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tableAsCharArray[row][col] = '0';
            }
        }
        tableAsCharArray[fox.getY()][fox.getX()] = 'f';
        for (Hound h : hounds) {
            tableAsCharArray[h.getY()][h.getX()] = 'h';
        }
        StringBuilder sb = new StringBuilder("[\n");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sb.append(tableAsCharArray[row][col]+" ");
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
