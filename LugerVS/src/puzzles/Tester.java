/**
 * 
 */
package puzzles;

import java.util.List;

import puzzles.QueenN;
import search.AbstractSolver;
import search.BreadthFirstSolver;
import search.DepthFirstSolver;
import search.BestFirstSolver;
import search.State;

/**
 * @author Marcello
 */

public class Tester {
	
	private static void trySolver(State initialState, AbstractSolver solver) {
		System.out.println("Solving with "+solver);
		List<State> solution = solver.solve(initialState);
		System.out.println("  States visited: "+solver.getVisitedStateCount());
		System.out.println("  Solution:");
		if (solution == null) {
			System.out.println("    None found.");
		} else {
			for (State s : solution)
				System.out.println("    "+s);
			System.out.println("   "+solution.size()+" states(s)");
		}
	}
	private static void trySolvers(State initialState) {
		//trySolver(initialState, new DepthFirstSolver());
		trySolver(initialState, new BreadthFirstSolver());
		//trySolver(initialState, new BestFirstSolver());
	}
	public static void main(String[] args) {
//		System.out.println("---------------------------------------------------------------");
		trySolvers(new QueenN());
		System.out.println("---------------------------------------------------------------");
		// trySolvers(new Kirako());
	}
}
