package game;

/**
 * @author valyis
 * The position describes the actual state of a fox-and-hounds game.
 */
public class FoxAndHoundsPosition extends Position{
    public int N;
    public Character[][] matrix;

    // this is initializer code
         {N=8; matrix = new Character[][] {{'h',' ','h',' ','h',' ','h',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '},
                                           {' ','f',' ',' ',' ',' ',' ',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '},
                                           {' ',' ',' ',' ',' ',' ',' ',' '}}; }  

    
    public void setN(int N) {
        this.N = N;
    }

    public void setMatrix(Character[][] inputmatrix) {
        setN(inputmatrix.length);
        matrix = new Character[inputmatrix.length][inputmatrix[0].length];
        for (int row=0; row<N; row++) for (int col=0; col<N; col++) 
        this.matrix[row][col] = inputmatrix[row][col];
    }
    
    @Override
    public boolean equals (Object o) {
        if (o == null || !(o instanceof FoxAndHoundsPosition))
            {return false;}
        else {
            FoxAndHoundsPosition fop = (FoxAndHoundsPosition)o;
            if (this.N != fop.N) return false;
            for (int row=0; row<N;row++) for (int col=0; col<N;col++) {
                if (this.matrix[row][col] != fop.matrix[row][col])  return false;
            }
            return true;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new  StringBuilder("Pos:\n");
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) 
                sb.append(this.matrix[row][col]==' '?'-':matrix[row][col]);
        sb.append("\n");
        }
        return sb.toString();
        
    }
}
