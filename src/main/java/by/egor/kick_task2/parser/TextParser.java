package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;


public class TextParser extends AbstractTextParser {

   private final ComponentType type;
   private final String COMMON_REGEX;

  public TextParser(ComponentType type, String commonParagraphRegex) {
    this.type = type;
    COMMON_REGEX = commonParagraphRegex;
  }

  @Override
  public TextComposite parse(String text) {
    TextComposite textResult = new TextCompositeImpl(type);
    String[] lines = text.split(COMMON_REGEX);

    for (String line : lines) {
      if (line.trim().isEmpty()) {
        continue;
      }
      textResult.add(nextParser.parse(line));
    }
    return textResult;
  }
}
