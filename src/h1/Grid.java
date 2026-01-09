package h1;

public class Grid {

    private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        this.gridArray = new Cell[gridRows][gridCols];

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                this.gridArray[r][c] = new Cell(r, c);
            }
        }

        for (int i = 0; i < cells.length; i++) {
            Cell c = cells[i];
            int r = c.getIndexRow();
            int col = c.getIndexCol();

            if (r >= 0 && r < gridRows && col >= 0 && col < gridCols) {
                this.gridArray[r][col].setAlive(true);
            }
        }

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                this.gridArray[r][c].countLivingNeighbors(this.gridArray);
            }
        }
    }

    public void computeNextGen() {
        for (int r = 0; r < this.gridArray.length; r++) {
            for (int c = 0; c < this.gridArray[0].length; c++) {
                Cell cell = this.gridArray[r][c];
                cell.setAlive(cell.isAliveNextGen());
            }
        }

        for (int r = 0; r < this.gridArray.length; r++) {
            for (int c = 0; c < this.gridArray[0].length; c++) {
                this.gridArray[r][c].countLivingNeighbors(this.gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            this.computeNextGen();
        }
    }
}