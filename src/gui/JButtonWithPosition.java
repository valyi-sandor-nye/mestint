package gui;

import javax.swing.Icon;
import javax.swing.JButton;

/** This class describes a button that 'knows' two coordinates. It exists 
 * for the sake of uniform handling of events occuring buttons on the table.
 *
 * @author valyis
 */


public class JButtonWithPosition extends JButton{
    int row; int col;

    public JButtonWithPosition(int x, int y) {
        super();
        row = x; col = y;
    }

    public JButtonWithPosition(String string) {
        super(string);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
     
    
}
