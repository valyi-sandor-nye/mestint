package play_on_terminal;

import business_logic.Move;
import business_logic.Table;

import java.util.Scanner;

public class Main {
    public Move readHumanMoveFromKeyboard(){ return null;}

    public void aPairOfMoves(){}

    public static void main(String[] args) {
        Table t = Table.getStarterTable(8);
        System.out.println(t);
        t.setFoxOnMove(true);
        t.determineFoxPossibleMoves();
        System.out.println("Ebből az állásból ennyi fox-lépés van:"+t.getFoxPossibleMoves().size());
        t.makeMove(t.getFoxPossibleMoves().stream().findFirst().orElse(null));
        System.out.println(t);
        t.setFoxOnMove(true);
        t.determineFoxPossibleMoves();
        t.makeMove(t.getFoxPossibleMoves().stream().findFirst().orElse(null));
        
        }

    
}
