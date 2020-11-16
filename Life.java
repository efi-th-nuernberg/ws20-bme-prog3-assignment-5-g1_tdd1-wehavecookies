import java.util.ArrayList;

public class Life implements ILife {
  public static boolean[][] Alive = new boolean[5][5];

  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();

  }


  public Life() {
    nukeAll();
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
    // TODO Auto-generated method stub

  }

  @Override
  public void setAlive(int x, int y) {
     Alive[x][y] = true;
  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isAlive(int x, int y) {
    // TODO Auto-generated method stub
    return Alive[x][y];
  }

  @Override
  public ILife nextGeneration() {
    // TODO Auto-generated method stub
    for (int y = 0; y < 5; y++)
      for (int x = 0; x < 5; x++)
      if (isAlive(x,y))
      {
        //check is still alive
          //Mit weniger als 2 Nachbarn stirbt die Zelle
          //Mit mehr als 3 Nachbarn stirbt die Zelle
      } else {
        //check if now alive
          //rule 1: 3 neighbors
        int neighbors = 0;
        for (int i = 0; i<3; i++)
          for (int j = 0; j<3; j++)
          if (x+i-1 >= 0 && x+i-1 <= 4 && y+j-1 >= 0 && y+j-1 <= 4)
            if(isAlive(x+i-1, y+j-1))
              neighbors++;
        if(neighbors>=3)
          setAlive(x,y);
            
        
      }
    return nGen;
  }
}

// -cp .:./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar org.junit.runner.JUnitCore