import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
  private int GEN = 1;

    @Test
    public void createNewCell() {
       // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        System.out.println("\nTesting: -create new cell");
        printGeneration(l);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        printGeneration(l);

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
       assertTrue(l.isAlive(1,1));
    }


    @Test
    public void destroyLonelyCell() {
      // Arrange: vier lebende Zellen
        Life l = new Life();
        l.nukeAll();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);
        l.setAlive(4, 1);

        System.out.println("\nTesting: -destroy lonely cell");
        printGeneration(l);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        printGeneration(l);

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
       assertFalse(l.isAlive(4,1));
    }


    @Test
    public void keepAliveCell() {
      // Arrange: vier lebende Zellen
        Life l = new Life();
        l.nukeAll();
        l.setAlive(2,3);
        l.setAlive(3, 2);
        l.setAlive(3, 3);

        System.out.println("\nTesting: -keep alive cell");
        printGeneration(l);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        printGeneration(l);

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(l.isAlive(2,3));
        assertTrue(l.isAlive(3,2));
        assertTrue(l.isAlive(3,3));

    }


    @Test
    public void destroyCrowdedCell() {
    // Arrange: vier lebende Zellen
        Life l = new Life();
        l.nukeAll();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(1, 0);
        l.setAlive(1, 1);
        l.setAlive(2, 0);
        l.setAlive(2, 1);

        System.out.println("\nTesting: -destroy crowded cell");
        printGeneration(l);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        printGeneration(l);

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertFalse(l.isAlive(1,0));
        assertFalse(l.isAlive(1,1));

    }

    public void printGeneration(Life l){
      System.out.println("Generation " + GEN + "\n");
        String XO;
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++){
            int n = l.getNeighbors(x,y);
            if (l.isAlive(x,y))
              XO = "X";
            else 
              XO = "O";
            System.out.print(XO + " ");
          }
        System.out.println("\n");
        }
      GEN++;
    }
}
