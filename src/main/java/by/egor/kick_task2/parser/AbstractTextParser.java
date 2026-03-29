package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;

public abstract class AbstractTextParser {

  protected AbstractTextParser nextParser;

  public void setNextParser(AbstractTextParser nextParser ) {
    this.nextParser = nextParser;
  }

  public abstract TextComposite parse(String text);
}
