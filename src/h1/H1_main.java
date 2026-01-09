package h1;

public class H1_main {

    public static void main(String[] args) {
        
        // 1. DAS SETUP
        // Wir bauen das Beispiel aus dem PDF nach (4 Zeilen, 5 Spalten).
        // Lebende Zellen laut PDF-Bild:
        // Zeile 0: .....1 -> (0, 4)
        // Zeile 1: .1...  -> (1, 1)
        // Zeile 2: ..11.  -> (2, 2), (2, 3)
        // Zeile 3: .11..  -> (3, 1), (3, 2)
        
        Cell[] startZellen = {
            new Cell(0, 4),
            new Cell(1, 1),
            new Cell(2, 2),
            new Cell(2, 3),
            new Cell(3, 1),
            new Cell(3, 2)
        };

        // Gitter erstellen (4 Zeilen, 5 Spalten)
        Grid meinSpiel = new Grid(startZellen, 4, 5);
        
        System.out.println("--- START (Generation 0) ---");
        printGrid(meinSpiel);

        // 2. TEST: Generation 1
        System.out.println("\n--- Generation 1 ---");
        meinSpiel.computeNextGen();
        printGrid(meinSpiel);
        
        // Lösung laut PDF prüfen:
        // 00000
        // 00110
        // 00010
        // 01110
        
        // 3. TEST: Generation 2 (noch einen Schritt weiter)
        System.out.println("\n--- Generation 2 ---");
        meinSpiel.computeNextGen();
        printGrid(meinSpiel);
        
        // Lösung laut PDF prüfen:
        // 00000
        // 00110
        // 01001
        // 00110
    }

    // Hilfsmethode, um das Feld auf der Konsole sichtbar zu machen
    // (Damit du Nullen und Einsen siehst)
    public static void printGrid(Grid g) {
        Cell[][] feld = g.getGridArray();
        
        for (int r = 0; r < feld.length; r++) {
            for (int c = 0; c < feld[0].length; c++) {
                if (feld[r][c].isAlive()) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println(); // Zeilenumbruch nach jeder Zeile
        }
    }
}