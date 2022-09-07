public class Cell {
    private CellStatus cellStatus;

    public Cell() {
        cellStatus =  CellStatus.Empty;
    }

    public CellStatus getCellStatus() {
        return this.cellStatus;
    }

    public void changeX() {
        this.cellStatus = CellStatus.X;
    }

    public void changeO() {
        this.cellStatus = CellStatus.O;
    }
}
