/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import search.AbstractState;
import search.State;
import puzzles.Negyzet;
/**
 *
 * @author valyis
 */


public class Kirako extends AbstractState {

    ArrayList<Negyzet> bal = new ArrayList<>();
    ArrayList<Negyzet> jobb  = new ArrayList<>();
    
    public Kirako() {
        bal.add(0,Negyzet.A); 
        jobb.add(0,Negyzet.B); 
        jobb.add(1,Negyzet.C);
    }
                   
    public Kirako(Kirako ős, boolean balrol, boolean alulrol) {
       super(ős); 
       for (Negyzet n : ős.bal) {bal.add(n);}
       for (Negyzet n : ős.jobb) {jobb.add(n);}      
       if (balrol && bal.size()>0) {
          Negyzet m = bal.get(0);
          bal.remove(0);
          if (alulrol) jobb.add(jobb.size(),m);
          else         jobb.add(0,m);
       }
       if (!balrol && jobb.size()>0) {
          Negyzet m = jobb.get(0);
          jobb.remove(0);
          if (alulrol) bal.add(bal.size(),m);
          else         bal.add(0,m);
       }
    }
    
    @Override
    public Iterable<State> getPossibleMoves() {
        ArrayList<State> moves = new ArrayList<State>();
            if (bal.size()>0) {
                moves.add(new Kirako(this,true,true));
                if (jobb.size()>0) 
                    moves.add(new Kirako(this,true,false));
               }
            if (jobb.size()>0) {
                moves.add(new Kirako(this,false,true));
                if (bal.size()>0) 
                    moves.add(new Kirako(this,false,false));
               }
        return moves;
    }

    @Override
    public boolean isSolution() {
       return bal.size()==0 && jobb.size()>=3 && jobb.get(0)==Negyzet.C &&
              jobb.get(1)==Negyzet.B  && jobb.get(2)==Negyzet.A
               ;
    }

    @Override
    public double getHeuristic() {
        return 1.0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o==null || !(o instanceof Kirako)) return false;
        else {
         Kirako k = (Kirako)o;
         if (bal.size() != k.bal.size()) return false;         
         if (jobb.size() != k.jobb.size()) return false;         
         boolean talaltElterest = false;
         for (int i=0; i<bal.size();i++) if(bal.get(i)!= k.bal.get(i))
             talaltElterest=true;
         for (int i=0; i<jobb.size();i++) if(jobb.get(i)!= k.jobb.get(i))
             talaltElterest=true;
         return !talaltElterest;
     }

    }
    
    @Override public String toString() {
    return "("+bal.toString()+'|'+jobb.toString()+")";
    }
}
