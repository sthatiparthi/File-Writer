import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateFileWriter {

  public static void main(String[] args) throws Exception {
    if (args.length > 0) {
      int x = Integer.valueOf(args[0]);
      File file = new File("./output.txt");
      FileWriter fileWriter = new FileWriter(file, true);
      PrintWriter writer = new PrintWriter(fileWriter);
      for (int i = 0; i < x; i++) {
        writer.println(generateUniqueString());
      }
      writer.close();
    }
  }

  private static String generateUniqueString() {

    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 100;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    return generatedString;

  }

}

