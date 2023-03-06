package puzzles;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import search.AbstractState;
import search.State;


/** State space representation of the Queen N problem in the Java framework of Mr. Luger
 *
 * @author valyis
 */
public class QueenN extends AbstractState {

	int[] partialTable = {0,0,0,0,0,0,0,0};
        int N = partialTable.length;
        int lastFilled =0;

    /**
     * Constructs a new empty state.
     */
    public QueenN() {
    }

    /**
     * Constructs a child state from a parent state
     */
    public QueenN(QueenN parent, int[] partialTable ) {
        super(parent);
        N = partialTable.length;
        this.partialTable = Arrays.copyOf(partialTable, partialTable.length);
        int row=0; while (row< N && partialTable[row]>0) row++;
        lastFilled = row;
    }



    /**
     * Returns a set of all possible moves from this state.
     */
    public Iterable<State> getPossibleMoves() {
        Set<State> moves = new HashSet<State>();
        for (int row = 1; row<= N; row++)
            if (isPossibleChild(row)) {
                int [] newPartialTable = Arrays.copyOf(partialTable, N);
                newPartialTable[lastFilled]=row;
                QueenN ujTabla =  new QueenN(this, newPartialTable);
                moves.add(ujTabla);
            }
        return moves;
    }

    private boolean isPossibleChild(int i) {
        boolean noCollision = true;
        for (int row = 0; row< lastFilled; row++)
            if (partialTable[row]==i || java.lang.Math.abs(partialTable[row]-i)== lastFilled -row )
                noCollision = false;
        return noCollision;
    }

    /**
     * The solution is specified as a table where there is a row for each column
     * every row that its joint position is populated by a queen.
     * @return true if this state is a solution
     */
    public boolean isSolution() {
        return lastFilled == N;

    }


    /**
     * Returns a heuristic approximation of the number of moves required
     * to solve this problem from this state.  This is implemented as
     * the number of queen collisions.
     */
    public double getHeuristic() {
        int sum = 0;
        for (int row = 0; row< lastFilled; row++)
           for (int col = row+1; col< lastFilled; col++)
              sum+= (partialTable[col]== partialTable[row] ||
                      java.lang.Math.abs(partialTable[col]- partialTable[row])== (col-row) )
                      ?1:0;

        return (double)sum;
    }
    /**
     * Compares whether two states are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o==null || !(o instanceof QueenN))
            return false;
        QueenN q8 = (QueenN)o;
        boolean foundDifference = false;
        for (int row = 0; row< lastFilled; row++)
              if(partialTable[row]!=q8.partialTable[row]) foundDifference = true;

        return !foundDifference;
    }

@Override
    public int hashCode() {
        int sum = 0;
        int power = 1;
        for (int row= 0; row < N; row++) {
            sum += power*partialTable[row];
            power *= N;
        }
        return sum;
    }


    /**
     * Returns a string representation of this state
     */
   @Override
    public String toString() {
       java.lang.StringBuilder s = new StringBuilder("\n[");
        for (int row = 0; row< N; row++) {
             s.append(partialTable[row]+(row+1< N ?",":""));
        }
       s.append("]\n-------------");
       return s.toString();
   }
}
