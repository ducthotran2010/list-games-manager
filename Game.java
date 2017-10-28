package Games;
import java.util.*;
import java.lang.Comparable;

public class Game implements Comparable{
  int yop = 0, vote = 0;
  String name = "NULL", publisher = "UNKNOWN";

  @Override
  public int compareTo(Object SecondGame) {
    return ((Game) this).name.compareTo(((Game) SecondGame).name);
  }

  public static Comparator compByName = new Comparator() {
    @Override
    public int compare(Object FirstGame, Object SecondGame) {
      return ((Game) FirstGame).name.compareTo(((Game) SecondGame).name);
    }
  };

  public static Comparator compByPublisher = new Comparator() {
    @Override
    public int compare(Object FirstGame, Object SecondGame) {
      return ((Game) FirstGame).publisher.compareTo(((Game) SecondGame).publisher);
    }
  };

  public static Comparator compByVote = new Comparator() {
    @Override
    public int compare(Object FirstGame, Object SecondGame) {
      Integer First = ((Game) FirstGame).vote;
      Integer Second = ((Game) SecondGame).vote;
      return First.compareTo(Second);
    }
  };

  public static Comparator compByYop = new Comparator() {
    @Override
    public int compare(Object FirstGame, Object SecondGame) {
      Integer First = ((Game) FirstGame).yop;
      Integer Second = ((Game) SecondGame).yop;
      return First.compareTo(Second);
    }
  };
}
