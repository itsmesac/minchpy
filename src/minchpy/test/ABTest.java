package minchpy.test;

import minchpy.entity.ABState;
import minchpy.entity.ChessState;
import minchpy.util.AlphaBetaPruningAlgorithm;

public class ABTest {

    public static void main(String[] args) {
        ABState abState = new ABState(new ChessState());
        AlphaBetaPruningAlgorithm.alphaBetaSearch(new TestImpl(), abState);
    }

}
