package h1;

public class Cell {

    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }

                int checkRow = this.indexRow + r;
                int checkCol = this.indexCol + c;

                if (checkRow >= 0 && checkRow < gridArray.length && 
                    checkCol >= 0 && checkCol < gridArray[0].length) {
                    
                    if (gridArray[checkRow][checkCol].isAlive()) {
                        count++;
                    }
                }
            }
        }
        this.numLivingNeighbors = count;
        this.decideNextStatus();
    }

    private void decideNextStatus() {
        if (this.numLivingNeighbors == 3) {
            this.isAliveNextGen = true;
        } else if (this.numLivingNeighbors == 2 && this.alive) {
            this.isAliveNextGen = true;
        } else {
            this.isAliveNextGen = false;
        }
    }
}