package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;

public class ParagraphParser extends AbstractTextParser {

  private static final String PARAGRAPH_REGEX = "(?<=[.!?])\\s*";

  @Override
  public TextComposite parse(String text) {
    TextComposite paragraph = new TextCompositeImpl(ComponentType.PARAGRAPH);

    String[] sentences = text.split(PARAGRAPH_REGEX);
    for (String s : sentences) {
      if (s.trim().isEmpty()) {
        continue;
      }
        paragraph.add(nextParser.parse(s));
    }
    return paragraph;
  }
}
