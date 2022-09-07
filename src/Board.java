public class Board {
    private Cell[] a;

    public Board() {
        a = new Cell[9];
        for (int i = 0; i < 9; i++)
            a[i] = new Cell();
    }

    public boolean outOfBound(int x, int y) {
        return (x < 1 || y < 1 || x > 3 || y > 3);
    }
    public Cell getcell(int id) {
        return a[id];
    }
    public boolean have_winner() {
        boolean ok = false;
        String res = "";
        for (int i = 0; i < 3; i++) {
            if (a[i].getCellStatus().equals(a[i + 3].getCellStatus()) &&
                a[i].getCellStatus().equals(a[i + 6].getCellStatus()) &&
                !a[i].getCellStatus().equals(CellStatus.Empty)) {
                ok = true;
                res = a[i].getCellStatus().toString();
                break;
            }
            if (a[3 * i].getCellStatus().equals(a[3 * i + 1].getCellStatus()) &&
                a[3 * i].getCellStatus().equals(a[3 * i + 2].getCellStatus()) &&
                !a[3 * i].getCellStatus().equals(CellStatus.Empty)) {
                ok = true;
                res = a[3 * i].getCellStatus().toString();
                break;
            }
        }
        if (a[0].getCellStatus().equals(a[4].getCellStatus()) &&
                a[0].getCellStatus().equals(a[8].getCellStatus()) &&
                !a[0].getCellStatus().equals(CellStatus.Empty)) {
            ok = true;
            res = a[0].getCellStatus().toString();
        }
        if (a[2].getCellStatus().equals(a[4].getCellStatus()) &&
                a[2].getCellStatus().equals(a[6].getCellStatus()) &&
                !a[2].getCellStatus().equals(CellStatus.Empty)) {
            ok = true;
            res = a[2].getCellStatus().toString();
        }
        if (! ok) return false;
        System.out.println(res + " wins!");
        return true;
    }
    public void printBoard() {
        for (int r = 0; r < 3; r++) {
            for (int i = 0; i < 3; i++) {
                int id = r * 3  + i;
                if (a[id].getCellStatus() == CellStatus.X) {
                    System.out.print("[X]");
                }
                else if (a[id].getCellStatus() == CellStatus.O) {
                    System.out.print("[O]");
                } else System.out.print("[ ]");
            }
            System.out.println("");
        }
    }

    public CellStatus status(int x, int y) {
        return a[(x - 1) * 3 + y - 1].getCellStatus();
    }
}
