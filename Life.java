import java.util.ArrayList;

public class Life implements ILife {
  public static boolean[][] Alive = new boolean[5][5];
  public static int[][] Neighbors = new int[5][5];

  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();

  }


  public Life() {
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
           setAlive(x, y);
  }


  @Override
  public void nukeAll() {
    for (int y = 0; y < 5; y++)
      for (int x = 0; x < 5; x++)
      setDead(x,y);
  }

  @Override
  public void setAlive(int x, int y) {
     Alive[x][y] = true;
  }

  @Override
  public void setDead(int x, int y) {
    Alive[x][y] = false;
  }

  @Override
  public boolean isAlive(int x, int y) {
    return Alive[x][y];
  }

  @Override
  public ILife nextGeneration() {

    // Generiert neue Generation
    ILife nGen = new Life();

    // 4 Fälle müssen für die nächste Generation gecheckt werden 
    // Fall 1: Eine neue Zelle entsteht wenn genau 3 Nachbarn vorhanden sind
    // Fall 2: Eine Zelle stirbt wenn weniger als 2 Nachbarn vorhanden sind
    // Fall 3: Eine Zelle überlebt wenn 2 oder 3 Nachbarn vorhanden sind
    // Fall 4: Eine Zelle stirbt wenn mehr als 3 Nachbarn vorhanden sind

    calculateNeighbors();

    for (int y = 0; y < 5; y++)
      for (int x = 0; x < 5; x++)
      {
        int currentneighbors = Neighbors[x][y];
        if (isAlive(x,y))
        {
          //check is still alive
            // Checke Fall 2, 3 und 4
            if(currentneighbors < 2 || currentneighbors > 3){
              setDead(x, y);
            }
        //check if now alive
        // Checke Fall 1
        } else if (currentneighbors == 3){
            setAlive(x, y);
        }
      }
    return nGen;
  }

 public int getNeighbors(int x, int y){
   return(Neighbors[x][y]);
 }

  public void calculateNeighbors(){
    // Berechnen der Nachbarn für jede einzelne Zelle
    // Code von Erik übernommen
    for (int y = 0; y < 5; y++)
      for (int x = 0; x < 5; x++){
        int neighbors = 0;
        for (int i = 0; i<3; i++)
          for (int j = 0; j<3; j++)
            if (x+i-1 >= 0 && x+i-1 <= 4 && y+j-1 >= 0 && y+j-1 <= 4)
                if(isAlive(x+i-1, y+j-1))
                  neighbors++;
                  if (isAlive(x,y))
                    Neighbors[x][y] = neighbors-1;
                  else
                    Neighbors[x][y] = neighbors;
        }
  }

}