import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {

    @Test
    public void createNewCell() {
       // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        System.out.println("Generation 1:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }
        System.out.println("\n");

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        System.out.println("Generation 2:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
      // Arrange: vier lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);
        l.setAlive(4, 1);

        System.out.println("Generation 3:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }
        System.out.println("\n");

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        System.out.println("Generation 4:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertFalse(nextGen.isAlive(4, 1));
    }


    @Test
    public void keepAliveCell() {
      // Arrange: vier lebende Zellen
        Life l = new Life();
        l.setAlive(2,3);
        l.setAlive(3, 2);
        l.setAlive(3, 3);

        System.out.println("Generation 5:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }
        System.out.println("\n");

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        System.out.println("Generation 6:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(2, 3));

    }


    @Test
    public void destroyCrowdedCell() {
    // Arrange: vier lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(1, 0);
        l.setAlive(1, 1);
        l.setAlive(2, 0);
        l.setAlive(2, 1);

        System.out.println("Generation 7:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }
        System.out.println("\n");

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        System.out.println("Generation 8:\n");
        for (int y = 0; y < 5; y++)
        {
          System.out.print("Zeile: " + y + " || ");
          for (int x = 0; x < 5; x++)
             System.out.print(x + " " + l.isAlive(x,y) + " ");
          System.out.println("\n");
        }

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertFalse(nextGen.isAlive(0, 1));

    }


}
