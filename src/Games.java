import java.util.Scanner;

public class Games {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play tictactoe!");
        Board board = new Board();
        int turn = 1;
        int cnt = 0;
        String[] tmp = {"0", "X"};
        board.printBoard();
        while (true) {
            System.out.println(tmp[turn] + " turn:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (board.outOfBound(x, y)) {
                System.out.println("Your coordinates are out of bound!");
                continue;
            }
            if (turn == 1) {
                if (! board.status(x, y).equals(CellStatus.Empty)) {
                    System.out.println("Cannot play in this cell!");
                    continue;
                } else {
                    board.getcell((x - 1) * 3 + y - 1).changeX();
                }
            } else {
                if (! board.status(x, y).equals(CellStatus.Empty)) {
                    System.out.println("Cannot play in this cell!");
                    continue;
                } else {
                    board.getcell((x - 1) * 3 + y - 1).changeO();
                }
            }
            board.printBoard();
            if (board.have_winner()) {
                System.out.println("Exit!");
                break;
            }

            turn = 1 - turn;
            cnt++;

            if (cnt == 9) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
