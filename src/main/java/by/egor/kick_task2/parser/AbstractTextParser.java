package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;

public abstract class AbstractTextParser {

  protected AbstractTextParser nextParser;

  public AbstractTextParser setNextParser(AbstractTextParser nextParser ) {
    this.nextParser = nextParser;
    return nextParser;
  }

  public abstract TextComposite parse(String text);

  protected TextComposite passToNextParser(String text) {
    return nextParser.parse(text);
  }

}
