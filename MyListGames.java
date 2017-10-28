package Games;
import java.util.*;

public class MyListGames {
  int size = 0;
  private int limit;
  private List<MyGame> list;
  // private MyGame[] list; why no list - no dynamic size
  // private TreeSet<MyGame> set; why no treeset - can resort

  MyListGames(int limit) {
    list = new ArrayList<MyGame>();
    this.limit = limit;
  }

  public static Boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  void add(String name, int yop, String publisher, int vote) {
    if (size + 1 > limit)
      throw new ArithmeticException("List is full");
    else {
      ++size;
      if (isEmpty(publisher) && vote == 0)
      this.addGame(name, yop);
      else if (isEmpty(publisher))
      this.addGame(name, yop, vote);
      else if (vote == 0)
      this.addGame(name, yop, publisher);
      else this.addGame(name, yop, publisher, vote);
    }
  }
  void addGame(String name, int yop) { list.add(new MyGame(name, yop)); }
  void addGame(String name, int yop, int vote) { list.add(new MyGame(name, yop, vote));}
  void addGame(String name, int yop, String publisher) { list.add(new MyGame(name, yop, publisher)); }
  void addGame(String name, int yop, String publisher, int vote) { list.add(new MyGame(name, yop, publisher, vote)); }

  Boolean isExistYop(int yop) {
    for (Game thisGame: list)
      if (thisGame.yop == yop)
        return true;
    return false;
  }
  Boolean isExistVote(int vote) {
    for (Game thisGame: list)
      if (thisGame.vote == vote)
        return true;
    return false;
  }
  Boolean isExistName(String name) {
    for (Game thisGame: list)
      if (thisGame.name.equals(name))
        return true;
    return false;
  }
  Boolean isExistPublisher(String publisher) {
    if (isEmpty(publisher)) { publisher = "UNKNOWN"; }
    for (Game thisGame: list)
      if (thisGame.publisher.equals(publisher))
        return true;
    return false;
  }


  void remove(String name) {
    --size;
    Iterator<MyGame> itr = list.iterator();
    while(itr.hasNext()) {
      MyGame thisGame = itr.next();
      if (thisGame.name.equals(name)) {
        itr.remove();
        break;
      }
    }
  }


  void modify(String name, int yop, String publisher, int vote) {
    for (Game thisGame: list)
      if (thisGame.name.equals(name)) {
        thisGame.yop = yop;
        thisGame.vote = vote;
        thisGame.publisher = (isEmpty(publisher)) ? "UNKNOWN" : publisher;
        return;
      }
  }


  void searchByName(String name) {
    int i = 0;
    for (Game thisGame: list) {
      if (thisGame.name.equals(name))
        System.out.println(++i + "th: " + thisGame.toString());
    }
  }
  void searchByYop(int yop) {
    int i = 0;
    for (Game thisGame: list) {
      if (thisGame.yop == yop)
        System.out.println(++i + "th: " + thisGame.toString());
    }
  }
  void searchByVote(int vote) {
    int i = 0;
    for (Game thisGame: list) {
      if (thisGame.vote == vote)
        System.out.println(++i + "th: " + thisGame.toString());
    }
  }
  void searchByPublisher(String publisher) {
    if (isEmpty(publisher)) { publisher = "UNKNOWN"; }
    int i = 0;
    for (Game thisGame: list) {
      if (thisGame.publisher.equals(publisher))
        System.out.println(++i + "th: " + thisGame.toString());
    }
  }

  void sortAs(int option) { if (option == 1) Collections.reverse(list); }
  void sortByYop() { Collections.sort(list, Game.compByYop); }
  void sortByName() { Collections.sort(list, Game.compByName); }
  void sortByPublisher() { Collections.sort(list, Game.compByPublisher); }
  void sortByVote() { Collections.sort(list, Game.compByVote); }

  void printList() {
    int i = 0;
    for (Game thisGame: list) {
      System.out.println(++i + "th: " + thisGame.toString());
    }
  }
}
