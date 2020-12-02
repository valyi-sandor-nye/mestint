package business_logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/** 
 * A hound is a figure on the table. 
 * It has two coordinates, one for row (y) and one for column (x).
 * It can take only forwards steps.
 */

@XmlType
public class Hound implements Figure {
    private int x,
            y;
    public Hound(int yPos, int xPos) 
    {
        y = yPos;  x = xPos;
    }
       
    public int getX() {
        return x ;
    }

    public void setX(int a) {
        this.x = a;
    }
    public int getY() {
        return y;
    }

    public void setY(int a) {
        this.y = a;
    }

    @Override
    public String toString() {
        return "Hound{" + "y=" + y + ", x=" + x + '}';
    }
    
}
