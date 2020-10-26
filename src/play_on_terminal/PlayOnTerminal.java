
package play_on_terminal;

import business_logic.Direction;
import business_logic.Fox;
import business_logic.Hound;
import business_logic.Move;
import business_logic.Table;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author valyis
 */
public class PlayOnTerminal {

    static final Logger logger = Logger.getLogger(PlayOnTerminal.class.getName());
    static int size = -1;
    static Table table = null;
    static Boolean humanPlaysWithFox = null; 
    static Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] a) {
            readInSizeAndSide();
            editing();
            System.out.println("A szerkeszett tábla: "+table);
            playing();
        }


    public static void readInSizeAndSide() {
        System.out.print("Add meg a pálya méretét pozitív egész számként (4 és 12 között): ");
        String read = null;
        while (size<=0) {
            try {
                read = scanner.nextLine();
                size = Integer.parseInt(read);
            } catch(NumberFormatException ex) {logger.warning("nem egész szám az input"); 
            System.out.print("\nMég 1x. Add meg a pálya méretét pozitív egész számként (4 és 12 között): ");}
            if (!(size <=12 && size>=4)) {        
                System.out.print("\nMég 1x. Add meg a pálya méretét pozitív egész számként (4 és 12 között): ");
            }
        System.out.print("\nAdd meg, a rókával (f) vagy az üldöző kutyákkal (h) szeretnél lenni (kilépés a játékból: x) : ");
        boolean player_determined = false; 
        read = null;
        while (!player_determined) {
               char c = scanner.nextLine().charAt(0);
                if (Arrays.asList('f','h','x','F','H','X').contains(c)) {
                    player_determined=true;
                    switch (Character.toLowerCase(c)) {
                        case ('f'): humanPlaysWithFox = true; break;
                        case ('h'): humanPlaysWithFox = false; break;
                        case ('x'): humanPlaysWithFox = null; break;
                    }
                } else {
                    System.out.println("Még 1x. A rókával (f) vagy az üldöző kutyákkal (h) szeretnél lenni (kilépés a játékból: x) : ");
                
                }
                    
            }
        }
    }
    
    public static void editing() {
        Table table = Table.getStarterTable(size);
        System.out.println("A pályaszerkesztés következik. \n"+
                "Hogyan kívánod szerkeszteni, üres pályából felpakolgatva (u)\n"+
                "vagy a kezdőpályából lépésekkel(k)"+"vagy kérsz egy véletlen pályát? (v)\n"+"x-szel kiléphetsz(x)");
        Character userInput = ' ';
        while (!Arrays.asList('u','k','v','x').contains(Character.toLowerCase(userInput))) {
            System.out.println("u/k/v/x: ");
            userInput = scanner.nextLine().charAt(0);
        }  
        switch (Character.toLowerCase(userInput)) {

            case 'u': {
                editingFromEmptyTable(); break;
            } 
            case 'k': {
                editingFromStartingPosition(); break;
            }
            case 'v': {
                setRandomTable();
            }
            default: System.exit(0);
                
            }
        }
    
    public static void editingFromEmptyTable() {
        table = Table.getEmptyTable(size);  
        System.out.println("Add be a róka y és x koordinátáját, 0-tól kezdődik: ");
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        table.addFox(new Fox(y,x));
        for (int i=1; i<=4; i++) {
            System.out.println("Add be a(z) "+i+". kutya y és x koordinátáját, 0-tól kezdődik: ");
            y = scanner.nextInt(); x = scanner.nextInt();
            table.addHound(new Hound(y,x));            
        }
    }

    public static void editingFromStartingPosition() {
        boolean exit = false;
        Character c;
        Hound activeHound = null;
        table = Table.getStarterTable(size);
        System.out.println("A tábla kezdő állása: "+table);
        c = 'a';
        while (Arrays.asList('a','d','q','e','x').contains(Character.toLowerCase(c))) {
        System.out.println("Adj be a róka egy lépését: a/d/q/e, p - kilépés a szerkesztésből");
        c = scanner.nextLine().charAt(0);
        switch (Character.toLowerCase(c)) {
            case 'a': table.doMove(new Move(table.getFox(),Direction.SOUTHWEST)); break;
            case 'd': table.doMove(new Move(table.getFox(),Direction.SOUTHEAST)); break;
            case 'q': table.doMove(new Move(table.getFox(),Direction.NORTHWEST)); break;
            case 'e': table.doMove(new Move(table.getFox(),Direction.NORTHEAST)); break;
            case 'p': exit = true; break;
            default: break;
            }
        if (exit) return;
        System.out.println("A tábla jelen állása: "+table); //DEBUG
       
        boolean isHoundFound = false;
        while (!isHoundFound) {
        System.out.println("Add meg, melyik kutya lépjen sor/oszlop");
        int y = scanner.nextInt(); int x = scanner.nextInt();
        activeHound = table.getHound(y, x);
        if (activeHound == null)  {
            System.out.println("Nincs ott kutya");            
            } else isHoundFound=true;
        }
        System.out.println("Adj be a kutya egy lépését: a/d/q/e, p - kilépés a szerkesztésből");
        
        scanner.nextLine(); // a nextInt() után beveszi az újsor-karaktert
        c = scanner.nextLine().charAt(0);
        switch (Character.toLowerCase(c)) {
            case 'a': table.doMove(new Move(activeHound,Direction.SOUTHWEST)); break;
            case 'd': table.doMove(new Move(activeHound,Direction.SOUTHEAST)); break;
            case 'q': table.doMove(new Move(activeHound,Direction.NORTHWEST)); break;
            case 'e': table.doMove(new Move(activeHound,Direction.NORTHEAST)); break;
            case 'p': exit = true; break;
            default: break;
            }
        if (exit) return;
        System.out.println("A tábla jelen állása: "+table); //DEBUG
        
        }
    }

    private static void setRandomTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    
               
    public static void playing() {
        System.out.println("A játék ezen a pályán indul: ");
        if (humanPlaysWithFox) {
            playWithFox();
        
        }
        else {
            playWithHounds();
        }
        
    }
    
    private static Direction directionByChar(Character c){
        switch (Character.toLowerCase(c.charValue())  ) { 
            case 'a': return Direction.SOUTHWEST;
            case 'q': return Direction.NORTHWEST;
            case 'd': return Direction.SOUTHEAST;
            case 'e': return Direction.NORTHEAST;
            default: return null;
        }
    }

    public static void playWithFox() {
        char c = ' ';
        while (true) {
            if (table.winFox()) {System.out.println("Nyertél"); return;}
            if (table.winHounds()) {System.out.println("Vesztettél"); return; }
            System.out.println("Lépés: a/d/q/e, kilépés: x ");
            while(!Arrays.asList('a','d','q','e','x').contains(c = Character.toLowerCase(scanner.nextLine().charAt(0)))) {}
            if (c == 'x') return;
            table.doMove(new Move(table.getFox(),directionByChar(c)));
            table.doARandomHoundMove();
            System.out.println("A tábla jelen állása: "+table); 
        }
    }

    private static void playWithHounds() {
        char c = ' ';
        Hound activeHound = null;
        boolean exit = false;
        while (true) {
            if (table.winFox()) {System.out.println("Vesztettél"); return;}
            if (table.winHounds()) {System.out.println("Nyertél"); return; }
            boolean isHoundFound = false;
            while (!isHoundFound) {
                System.out.println("Add meg, melyik kutya lépjen sor/oszlop. Kilépés: -1-et adj be.");
                int y = scanner.nextInt(); int x = scanner.nextInt();
                if (y == -1) System.exit(0);
                activeHound = table.getHound(y, x);
                if (activeHound == null)  {
                    System.out.println("Nincs ott kutya");            
                    } else isHoundFound=true;
                }
        System.out.println("Adj be a kutya egy lépését: a/d, x - kilépés a szerkesztésből");
        
        scanner.nextLine(); // a nextInt() után beveszi az újsor-karaktert
        c = scanner.nextLine().charAt(0);
        switch (Character.toLowerCase(c)) {
            case 'a': table.doMove(new Move(activeHound,Direction.SOUTHWEST)); break;
            case 'd': table.doMove(new Move(activeHound,Direction.SOUTHEAST)); break;
            case 'x': exit = true; break;
            default: break;
            }
        if (exit) return;
        table.doARandomFoxMove();
        System.out.println("A tábla jelen állása: "+table); //DEBUG
     
        }
    }
        

}
    

