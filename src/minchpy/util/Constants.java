package minchpy.util;

public class Constants {
    
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    
    public static final int MAX_FILES = 8;
    public static final int MAX_RANKS = 8;
    
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 7;
    
    public static final int A1 = (A * MAX_FILES) + 0;
    public static final int A2 = (A * MAX_FILES) + 1;
    public static final int A3 = (A * MAX_FILES) + 2;
    public static final int A4 = (A * MAX_FILES) + 3;
    public static final int A5 = (A * MAX_FILES) + 4;
    public static final int A6 = (A * MAX_FILES) + 5;
    public static final int A7 = (A * MAX_FILES) + 6;
    public static final int A8 = (A * MAX_FILES) + 7;
    
    public static final int B1 = (B * MAX_FILES) + 0;
    public static final int B2 = (B * MAX_FILES) + 1;
    public static final int B3 = (B * MAX_FILES) + 2;
    public static final int B4 = (B * MAX_FILES) + 3;
    public static final int B5 = (B * MAX_FILES) + 4;
    public static final int B6 = (B * MAX_FILES) + 5;
    public static final int B7 = (B * MAX_FILES) + 6;
    public static final int B8 = (B * MAX_FILES) + 7;
    
    public static final int C1 = (C * MAX_FILES) + 0;
    public static final int C2 = (C * MAX_FILES) + 1;
    public static final int C3 = (C * MAX_FILES) + 2;
    public static final int C4 = (C * MAX_FILES) + 3;
    public static final int C5 = (C * MAX_FILES) + 4;
    public static final int C6 = (C * MAX_FILES) + 5;
    public static final int C7 = (C * MAX_FILES) + 6;
    public static final int C8 = (C * MAX_FILES) + 7;
    
    public static final int D1 = (D * MAX_FILES) + 0;
    public static final int D2 = (D * MAX_FILES) + 1;
    public static final int D3 = (D * MAX_FILES) + 2;
    public static final int D4 = (D * MAX_FILES) + 3;
    public static final int D5 = (D * MAX_FILES) + 4;
    public static final int D6 = (D * MAX_FILES) + 5;
    public static final int D7 = (D * MAX_FILES) + 6;
    public static final int D8 = (D * MAX_FILES) + 7;
    
    public static final int E1 = (E * MAX_FILES) + 0;
    public static final int E2 = (E * MAX_FILES) + 1;
    public static final int E3 = (E * MAX_FILES) + 2;
    public static final int E4 = (E * MAX_FILES) + 3;
    public static final int E5 = (E * MAX_FILES) + 4;
    public static final int E6 = (E * MAX_FILES) + 5;
    public static final int E7 = (E * MAX_FILES) + 6;
    public static final int E8 = (E * MAX_FILES) + 7;
    
    public static final int F1 = (F * MAX_FILES) + 0;
    public static final int F2 = (F * MAX_FILES) + 1;
    public static final int F3 = (F * MAX_FILES) + 2;
    public static final int F4 = (F * MAX_FILES) + 3;
    public static final int F5 = (F * MAX_FILES) + 4;
    public static final int F6 = (F * MAX_FILES) + 5;
    public static final int F7 = (F * MAX_FILES) + 6;
    public static final int F8 = (F * MAX_FILES) + 7;
    
    public static final int G1 = (G * MAX_FILES) + 0;
    public static final int G2 = (G * MAX_FILES) + 1;
    public static final int G3 = (G * MAX_FILES) + 2;
    public static final int G4 = (G * MAX_FILES) + 3;
    public static final int G5 = (G * MAX_FILES) + 4;
    public static final int G6 = (G * MAX_FILES) + 5;
    public static final int G7 = (G * MAX_FILES) + 6;
    public static final int G8 = (G * MAX_FILES) + 7;
    
    public static final int H1 = (H * MAX_FILES) + 0;
    public static final int H2 = (H * MAX_FILES) + 1;
    public static final int H3 = (H * MAX_FILES) + 2;
    public static final int H4 = (H * MAX_FILES) + 3;
    public static final int H5 = (H * MAX_FILES) + 4;
    public static final int H6 = (H * MAX_FILES) + 5;
    public static final int H7 = (H * MAX_FILES) + 6;
    public static final int H8 = (H * MAX_FILES) + 7;
    
    public static final int[] TOP_DIRECTION = {1, 0};
    public static final int[] BOTTOM_DIRECTION = {-1, 0};
    public static final int[] LEFT_DIRECTION = {0, -1};
    public static final int[] RIGHT_DIRECTION = {0, 1};
    
    public static final int[] TOP_RIGHT_DIRECTION = {1, 1};
    public static final int[] TOP_LEFT_DIRECTION = {1, -1};
    public static final int[] BOTTOM_RIGHT_DIRECTION = {-1, 1};
    public static final int[] BOTTOM_LEFT_DIRECTION = {-1, -1};
    
    public static final int[] KNIGHT_TOP_RIGHT_DIRECTION_1 = {2, 1};
    public static final int[] KNIGHT_TOP_RIGHT_DIRECTION_2 = {1, 2};
    public static final int[] KNIGHT_TOP_LEFT_DIRECTION_1 = {2, -1};
    public static final int[] KNIGHT_TOP_LEFT_DIRECTION_2 = {1, -2};
    public static final int[] KNIGHT_BOTTOM_RIGHT_DIRECTION_1 = {-2, 1};
    public static final int[] KNIGHT_BOTTOM_RIGHT_DIRECTION_2 = {-1, 2};
    public static final int[] KNIGHT_BOTTOM_LEFT_DIRECTION_1 = {-2, -1};
    public static final int[] KNIGHT_BOTTOM_LEFT_DIRECTION_2 = {-1, -2};

    public static final int X = 0;
    public static final int Y = 1;
    
    public static final int EVAL_KING     = 999999;
    public static final int EVAL_QUEEN     = 9;
    public static final int EVAL_ROOK     = 5;
    public static final int EVAL_BISHOP = 3;
    public static final int EVAL_KNIGHT = 3;
    public static final int EVAL_PAWN     = 1;
    
    public static final String BOOK_TXT = "book.txt";
    public static final int NUMBER_OF_ENTRIES_IN_BOOK_TXT = 385;
}
