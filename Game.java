import java.util.Random;

class Game {
  public int number;

  public Game(int n) {
    number = n;
  }
  public Game() {
    number = generateNumber();
  }
  private static int generateNumber() {
    Random r = new Random();
    int[] numberS = new int[4];
    for(int i=0; i<4; i++) {
      numberS[i] = r.nextInt(10);
      for(int j=0; j<i; j++)
        if(numberS[j] == numberS[i]) {
          i--;
          break;
        }
    }
    int n = 0;
    for(int i=0; i<numberS.length; i++)
     n += numberS[i] * Math.pow(10, 3-i);
    return n;
  }
  private static int getPlace(int n, int k) {
    if( n % 10 == k )
      return 0;
    else if( (int) (n / 10) % 10 == k )
      return 1;
    else if( (int) (n / 100) % 10 == k )
      return 2;
    else if( (int) (n / 1000) % 10 == k )
      return 3;
    else
      return -1; 
  }
  public int getA(int guess) {
    int a = 0;
    for(int i=0; i<10; i++) {
      int x = getPlace(this.number, i);
      int y = getPlace(guess, i);
      if( x == -1 || y == -1 ) 
        continue;
      if( x != y )
        a ++;
    }
    return a;
  }
  public int getB(int guess) {
    int b = 0;
    for(int i=0; i<10; i++) {
      int x = getPlace(this.number, i);
      int y = getPlace(guess, i);
      if( x != -1 && x == y )
        b ++;
    }
    return b;
  }  
}
