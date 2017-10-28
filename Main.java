package Games;
import java.util.*;
import java.io.*;

public class Main {

  private MyListGames SetGames = new MyListGames(100);

  static Scanner scanf = new Scanner(System.in);
  public static int readIntWithException(String DisplayText) {
    int number = 0;
    Boolean isError = true;
    do {
      System.out.print(DisplayText);
      try {
        number = Integer.parseInt(scanf.nextLine());
        isError = false;
      } catch(Exception e) {};
    } while (isError);
    return number;
  }

  public static Boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  private static int getYop() {
    int num = 0;
    System.out.println("    |");
    do
    num = readIntWithException("    | Enter year of publishing [1900; 2017]: ");
    while (num < 1900 || 2017 < num);
    return num;
  }
  private static int getVote() {
    int num = 0;
    System.out.println("    |");
    do
    num = readIntWithException("    | Enter vote of game [1; 5] _ Leave it '0' if unknown: ");
    while (num < 0 || 5 < num);
    return num;
  }
  private static String getName() {
    String str = "";
    System.out.println("    |");
    do {
      System.out.print("    | Enter name of game: ");
      str = scanf.nextLine();
    } while (isEmpty(str));
    return str;
  }
  private static String getPublisher() {
    String str = "";
    System.out.println("    |");
    System.out.print("    | Enter publisher _ Press ENTER if unknown: ");
    str = scanf.nextLine();
    return str;
  }


  void addGame() {
    Menu.Notification.Header("ADD GAME");
    String name = getName();

    if (SetGames.isExistName(name)) {
      Menu.Notification.ExistedGame();
      return;
    }

    String publisher = getPublisher();
    int yop = getYop();
    int vote = getVote();

    SetGames.add(name, yop, publisher, vote);
    Menu.Notification.Success("Added");
  }

  // require an atributes: key = [name] to remove
  void removeGame() {
    Menu.Notification.Header("REMOVE GAME");
    String name = getName();

    if (SetGames.isExistName(name)) {
      SetGames.remove(name);
      Menu.Notification.Success("Removed");
    } else
    Menu.Notification.NotFound();
  }


  // require atributes: key = [name] to modify
  void modifyGame() {
    Menu.Notification.Header("MODIFY GAME");
    String name = getName();

    if (SetGames.isExistName(name)) {
      String publisher = getPublisher();
      int yop = getYop();
      int vote = getVote();
      SetGames.modify(name, yop, publisher, vote);
      Menu.Notification.Success("Modified");

    } else
    Menu.Notification.NotFound();
  }


  void searchGame() {
    int choice;
    Menu.Notification.SearchGameMenu();
    do {
      choice = readIntWithException("    | Your choice: ");
    } while (choice < 1 || 4 < choice);

    switch (choice) {
      case 1:
      String name = getName();
      if (SetGames.isExistName(name)) {
        Menu.Notification.HeadTable();
        SetGames.searchByName(name);
      }
      else
        Menu.Notification.NotFound();
      break;

      case 2:
      String publisher = getPublisher();
      if (SetGames.isExistPublisher(publisher)) {
        Menu.Notification.HeadTable();
        SetGames.searchByPublisher(publisher);
      }
      else
      Menu.Notification.NotFound();
      break;

      case 3:
      int yop = getYop();
      if (SetGames.isExistYop(yop)) {
        Menu.Notification.HeadTable();
        SetGames.searchByYop(yop);
      }
      else
        Menu.Notification.NotFound();
      break;

      case 4:
      int vote = getVote();
      if (SetGames.isExistVote(vote)) {
        Menu.Notification.HeadTable();
        SetGames.searchByVote(vote);
      }
      else
        Menu.Notification.NotFound();
      break;
    }
  }

  void sortList() {
    int sortby = 0, sortas = 0;
    Menu.Notification.SortListFirstTable();
    do
    sortby = readIntWithException("    | Your choice: ");
    while (sortby < 1 || 4 < sortby);

    Menu.Notification.SortListSecondTable();
    do
    sortas = readIntWithException("    | Your choice: ");
    while (sortas < 0 || 1 < sortas);

    switch (sortby) {
      case 1: SetGames.sortByName(); break;
      case 2: SetGames.sortByPublisher(); break;
      case 3: SetGames.sortByYop(); break;
      case 4: SetGames.sortByVote(); break;
    }
    SetGames.sortAs(sortas);
    Menu.Notification.Success("Sorted");
    displayList();
  }

  void displayList() {
    if (SetGames.size == 0) {
      System.out.println("There is no game in list!");
      return;
    }
    Menu.Notification.HeadTable();
    SetGames.printList();
  }

  void printFile(String FileName) {
    try {
      PrintStream stdout = System.out;
      PrintStream writer = new PrintStream(new FileOutputStream(FileName));
      System.setOut(writer);
      displayList();
      writer.close();
      System.setOut(stdout);
      Menu.Notification.Success("File is printed");
    } catch(IOException e) {System.out.println(e);}
  }

  public static void main(String[] args) {
    int choice = 0;
    Main Manager = new Main();
    do {
      new Menu();
      do
      choice = readIntWithException("Your choice [1; 8]: ");
      while (choice < 1 || 8 < choice);
      switch (choice) {
        case 1: Manager.addGame(); break;
        case 2: Manager.removeGame(); break;
        case 3: Manager.modifyGame(); break;
        case 4: Manager.searchGame(); break;
        case 5: Manager.sortList(); break;
        case 6: Manager.displayList(); break;
        case 7: Manager.printFile("ListGames.txt"); break;
        case 8: System.exit(0);
      };
    } while (true);

  }
}
