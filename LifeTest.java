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
    }


    @Test
    public void keepAliveCell() {
    }


    @Test
    public void destroyCrowdedCell() {
    }


}
