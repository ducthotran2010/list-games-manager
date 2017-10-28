package Games;

public class Menu {
  Menu() {
    System.out.println();
    System.out.println("#########################| LIST GAMES MANANGER |########################");
    System.out.println("Functions to manage list games:");
    System.out.println("1 - Add a game.");
    System.out.println("2 - Remove a game.");
    System.out.println("3 - Modify a game.");
    System.out.println("4 - Search games.");
    System.out.println("5 - Sort list games and display it.");
    System.out.println("6 - Display list games.");
    System.out.println("7 - Save to file 'ListGames.txt'.");
    System.out.println("8 - EXIT!");
  }

  static class Notification {
    static void HeadTable() {
      System.out.println("LIST OF GAME");
      System.out.printf("Form:<%30s | %15s | %4s | %6s>\n", "NAME", "PUBLISHER", "YEAR", "VOTE");
      System.out.println("------------------------------------------------------------------------");
    }
    static void Success(String Operator) {
      System.out.println(Operator + " successfully!");
    }
    static void NotFound() {
      System.out.println("Not found!");
    }
    static void ExistedGame() {
      System.out.println("Existed game!");
    }
    static void SearchGameMenu() {
      System.out.println("    | SEARCH GAMES IN LIST");
      System.out.println("    |");
      System.out.println("    | 1. Search by name.");
      System.out.println("    | 2. Search by publisher.");
      System.out.println("    | 3. Search by year of publishing.");
      System.out.println("    | 4. Search by vote.");
      System.out.println("    |");
    }
    static void SortListFirstTable() {
      System.out.println("    | SORT LIST GAME");
      System.out.println("    |");
      System.out.println("    | 1. Sort by name.");
      System.out.println("    | 2. Sort by publisher.");
      System.out.println("    | 3. Sort by year of publishing.");
      System.out.println("    | 4. Sort by vote.");
      System.out.println("    |");
    }
    static void SortListSecondTable() {
      System.out.println("    |");
      System.out.println("    | TYPE SORT");
      System.out.println("    | 0. Ascending");
      System.out.println("    | 1. Descending");
      System.out.println("    |");
    }
    static void Header(String Operator) {
      System.out.println("    | " + Operator);
    }
  }
}
