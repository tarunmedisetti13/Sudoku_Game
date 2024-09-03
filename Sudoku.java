public class Sudoku {
    public static void main(String[] args) {
        char[][] board=new char[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                board[i][j]='.';
            }
        }
        display(board);
        generateSudoku(board);
        int i=0;
        display(board);
    }
    public static boolean generateSudoku(char[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    row=i;
                    col=j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        for (int i = 1; i <= board.length; i++) {
            char ch=(char) (i+'0');
            if (isSafe(board, row, col, ch)) {
                board[row][col]=ch;
                if (generateSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    static void display(char[][] board){
        for(char[] ch:board){
            for(char ele:ch){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
        static boolean isSafe(char[][] board,int row,int col,char num){
            for(int i=0;i< board.length;i++){
                if(board[row][i]==num){
                    return false;
                }
            }
            for (int i=0;i< board.length;i++){
                if(board[i][col]==num){
                    return false;
                }
            }
            int sqrt=(int)Math.sqrt(board.length);
            int rowStart=row-row%sqrt;
            int colStart=col-col%sqrt;
            //int i=0;
            for (int i=rowStart;i<rowStart+sqrt;i++){
                for (int j=colStart;j<colStart+sqrt;j++){
                    if(board[i][j]==num){
                        return false;
                    }
                }
            }
            return true;
        }

}
