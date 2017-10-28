package Games;

public class MyGame extends Game {

  public MyGame(String name, int yop) {
    this.name = name;
    this.yop = yop;
  }

  public MyGame(String name, int yop, String publisher) {
    this.name = name;
    this.yop = yop;
    this.publisher = publisher;
  }

  public MyGame(String name, int yop, int vote) {
    this.name = name;
    this.yop = yop;
    this.vote = vote;
  }

  public MyGame(String name, int yop, String publisher, int vote) {
    this.name = name;
    this.publisher = publisher;
    this.yop = yop;
    this.vote = vote;
  }

  @Override
  // Return a string with form: < name | yop | publisher | vote >
  public String toString() {
    return (vote == 0) ?
      String.format("<%30s | %15s | %4d | UNKNOWN>", this.name, this.publisher, this.yop, this.vote) :
      String.format("<%30s | %15s | %4d | %7d>", this.name, this.publisher, this.yop, this.vote);
  }

}
