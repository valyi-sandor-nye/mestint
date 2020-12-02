package business_logic;

/**
 * The possible moves of the fox. The hounds are allowed to move only southwards.
 * The numbers of the directions expresses the displacement in vertical and horizontal direction, resp.
 * @author valyis
 */

public enum Direction {
    NORTHWEST(-1,-1), NORTHEAST(-1,1),SOUTHWEST(1,-1),SOUTHEAST(1,1);
    final private int rowStep; final private int colStep;
    public int getRowStep() {return rowStep;}
    public int getColStep() {return colStep;}
    private Direction(int a1, int a2) {rowStep=a1; colStep=a2;}
   
}
