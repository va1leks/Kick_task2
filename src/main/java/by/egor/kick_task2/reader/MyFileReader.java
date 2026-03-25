package by.egor.kick_task2.reader;

import by.egor.kick_task2.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileReader {

  Logger logger = LoggerFactory.getLogger(MyFileReader.class);

  public String readAll(String filePath) throws MyException {
    try {
      String content = Files.readString(Paths.get(filePath));
      logger.info(content);
      content = content.replaceAll("[ \\t]+", " ");

      return content.trim();
    } catch (IOException e) {
      throw new MyException(e);
    }
  }
}
