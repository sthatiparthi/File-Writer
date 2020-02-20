import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateFileWriter {

  public static void main(String[] args) throws Exception {
    if (args.length > 0) {
      final int BATCH_SIZE = 10000;
      final int x = Integer.valueOf(args[0]);
      File file = new File("./output.txt");
      FileWriter fileWriter = new FileWriter(file, true);
      PrintWriter writer = new PrintWriter(fileWriter);
      List<String> list = new ArrayList<>();
      for (int i = 0; i < x; i++) {
        list.add(generateUniqueString());
        if (BATCH_SIZE == list.size()) {
          writer.print(list);
          list.clear();
        }
      }
      writer.print(list);
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

