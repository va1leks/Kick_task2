package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;

public class SentenceParser extends AbstractTextParser {

  private static final String SENTENCE_REGEX = "\\s+";

  @Override
  public TextComposite parse(String text) {
    TextComposite sentenceResult = new TextCompositeImpl(ComponentType.SENTENCE);
    String[] lines = text.split(SENTENCE_REGEX);

    for (String line : lines) {
      if (line.trim().isEmpty()) {
        continue;
      }
      TextComposite result = nextParser.parse(line);
      sentenceResult.add(result);
    }
    return sentenceResult;
  }
}
