
import java.io.File;

public class file {
  public static void main(String[] args) {
    File myFile = new File("file.txt");
    if (myFile.delete()) {
      System.out.println("I have deleted : " + myFile.getName());
    } else {
      System.out.println("SOme problem occured to delete this file");
    }
  }
}
