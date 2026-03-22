package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;


public class TextParser extends AbstractTextParser {

  private static final String TEXT_REGEX = "\n";

  @Override
  public TextComposite parse(String text) {
    TextComposite textResult = new TextCompositeImpl(ComponentType.TEXT);
    String[] lines = text.split(TEXT_REGEX);

    for (String line : lines) {
      if (line.trim().isEmpty()) {
        continue;
      }
      TextComposite paragraphResult = nextParser.parse(line);
      textResult.add(paragraphResult);
    }
    return textResult;
  }
}
