package business_logic;

import javax.xml.bind.annotation.XmlType;

/** 
 * A fox is a figure on the table. 
 * It has two coordinates, one for row (y) and one for column (x).
 */

@XmlType
public class Fox implements Figure{

    private int  y,x;
    public Fox(int yPos, int xPos) {
        x = xPos; y = yPos;
    }
    public int getX() {
        return x;
    }

    public void setX(int xPosition) {
        this.x = xPosition;
    }

    public int getY() {
        return y;
    }

    public void setY(int yPosition) {
        this.y = yPosition;
    }

    @Override
    public String toString() {
        return "Fox{" + "y=" + y + ", x=" + x + '}';
    }
    
} // end class Fox
