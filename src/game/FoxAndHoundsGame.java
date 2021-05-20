package game;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author valyis
 * This class implements the abstract methods of the abstract class GameSearch
 * according to the rules of the FOx-and-Hounds game.
 */
public class FoxAndHoundsGame extends GameSearch {

    /** This member is used to read in moves */
    static Scanner sc = new Scanner(System.in);
    /** This is the possible maximal depth of search, not the actual.*/
    static int MAXDEPTH = 4;
    
    /** There is no drawn position in this game.
     @param p  is a position
     * @return false always
     */
    @Override
    public boolean drawnPosition(Position p) {
        return false; 
    }

    /** This method gives back whether
     * some player has won the actual game. 
     * @param p is the postion
     * @param player is the player, true for fox and false for hounds
     * @return the condition if player has won the gane describes in position p
     */
    @Override
    public boolean wonPosition(Position p, boolean player) {
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        if (player) {
            for (int i=0;i<pos.N;i++) if (pos.matrix[0][i]=='f') return true;
            return false;
        } // the fox is reached the upper row
        else {
        for (int x=0;x<pos.N;x++)  for (int y=0;y<pos.N;y++)
        for (int dx=-1;dx<=1;dx+=2)         for (int dy=-1;dy<=1;dy+=2) 
            if (pos.matrix[x][y]=='f' && x+dx >= 0 && x+dx<pos.N && y+dy >= 0 && y+dy<pos.N && pos.matrix[x+dx][y+dy] == ' ' )  
                                                                                return false; //the fox can move, the hounds have not won yet
        return true; // the fox cannot move
        }
    }

    /** The heuristic function returns back which row is the fox in if the player is the fox 
     * and its reverse (N-h) if the hounds are on move
     */
    @Override
    public float positionEvaluation(Position p, boolean player) {
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        if (wonPosition(p,player)) return player?GameSearch.INFINITY:-GameSearch.INFINITY;
        for (int i=0;i<pos.N;i++)  for (int j=0;j<pos.N;j++) if (pos.matrix[i][j]=='f') return  (player? (float)pos.N-i-1 :-(float)(pos.N-i-1));
        return 0.0F;   // this row is unreachable in a normal run situation. THe fox is always on the table...
    }

    @Override
    public void printPosition(Position p) {
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        for (int i=0;i<pos.N;i++) {
            for (int j=0;j<pos.N;j++) {
                System.out.print(pos.matrix[i][j]!=' '?pos.matrix[i][j]:'-');
            }
                System.out.println("");
        }
    }

    /** This method constructs an array containing the result of all the possible moves in
     * position p if player is on the move.
     * @param p
     * @param player
     * @return 
     */
    @Override
    public Position[] possibleMoves(Position p, boolean player) {
        LinkedList<Position> children = new LinkedList<>();
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        Character actual = player?'f':'h';
        for (int x=0;x<pos.N;x++)  for (int y=0;y<pos.N;y++)
        for (int dx=-1;dx<=1;dx+=2)         for (int dy=-1;dy<=1;dy+=2) {
            if (pos.matrix[x][y]==actual && x+dx >= 0 && x+dx<pos.N && y+dy >= 0 && y+dy<pos.N && pos.matrix[x+dx][y+dy] == ' '
                    && (!player?dx>0:true))  {
                FoxAndHoundsPosition child = new FoxAndHoundsPosition();
                child.N = pos.N;
                child.matrix = new Character[pos.N][pos.N];
                for (int i=0;i<pos.N;i++)   for (int j=0;j<pos.N;j++) child.matrix[i][j] = pos.matrix[i][j];
                child.matrix[x][y]=' ';
                child.matrix[x+dx][y+dy] = actual;
                children.add(child);
            }
        }
        Position[] answer = new Position[children.size()];
        for (int i=0; i<answer.length; i++) answer[i] = children.get(i);
        return answer;

    }
    
    @Override
    public Position makeMove(Position p, boolean player, Move m) {
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        FoxAndHoundsMove move = (FoxAndHoundsMove) m;
        Character actual = (player?'f':'h');
        if (pos.matrix[move.fromx][move.fromy]==actual && move.tox >= 0 && move.tox<pos.N && move.toy >= 0 && move.toy<pos.N && 
                pos.matrix[move.tox][move.toy] == ' ' )  {
                FoxAndHoundsPosition answer = new FoxAndHoundsPosition();
                answer.N = pos.N;
                answer.matrix = new Character[pos.N][pos.N];
                for (int i=0;i<pos.N;i++)   for (int j=0;j<pos.N;j++) answer.matrix[i][j] = pos.matrix[i][j];
                answer.matrix[move.fromx][move.fromy]=' ';
                answer.matrix[move.tox][move.toy] = actual;
                return answer;
    }
        return pos;
    }
    @Override
    public boolean reachedMaxDepth(Position p, int depth) {
        return depth >= MAXDEPTH;
    }

    @Override
    public Move createMove(Position p, boolean player) {
        int a,b,c,d;
        FoxAndHoundsPosition pos = (FoxAndHoundsPosition) p;
        Character actual = (player?'f':'h');
        boolean moveOK = false;
        do {
        System.out.println("Write 4 nonnegative integers, fromx fromy tox toy, as a move:");
        a = sc.nextInt(); 
        b = sc.nextInt(); 
        c = sc.nextInt(); 
        d = sc.nextInt();
        if (a>= 0 && a<pos.N && b>= 0 && b<pos.N && c>= 0 && c<pos.N && d>= 0 && d<pos.N && 
                java.lang.Math.abs(a-c)==1 && java.lang.Math.abs(b-d)==1 &&
                pos.matrix[a][b]==actual &&  
                pos.matrix[c][d] == ' ' ) moveOK = true;
        }
        while (!moveOK);
        
        return new FoxAndHoundsMove(a,b,c,d);
    }

    public static void main(String[] a) {
        new FoxAndHoundsGame().playGame(new FoxAndHoundsPosition(),true);
        sc.close();
    }
    
}
