package h2;

public class Spielstein {

    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld aktuellesFeld = this.brett.getBrett()[currentRow][currentCol];
        char richtung = aktuellesFeld.getDirection();
        int maxIndex = this.brett.getDim() - 1;

        if (richtung == 'U' && currentRow == 0) {
            return true;
        }
        if (richtung == 'D' && currentRow == maxIndex) {
            return true;
        }
        if (richtung == 'L' && currentCol == 0) {
            return true;
        }
        if (richtung == 'R' && currentCol == maxIndex) {
            return true;
        }

        return false;
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld aktuellesFeld = this.brett.getBrett()[currentRow][currentCol];

            if (aktuellesFeld.isBoese()) {
                continue;
            }

            if (this.movesOut()) {
                continue;
            }

            char richtung = aktuellesFeld.getDirection();

            if (richtung == 'U') {
                this.currentRow--;
            } else if (richtung == 'D') {
                this.currentRow++;
            } else if (richtung == 'L') {
                this.currentCol--;
            } else if (richtung == 'R') {
                this.currentCol++;
            }
        }
    }
}