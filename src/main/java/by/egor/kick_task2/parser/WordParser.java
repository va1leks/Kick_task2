package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.Symbol;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;

public class WordParser extends AbstractTextParser {

  @Override
  public TextComposite parse(String text) {
    TextComposite word = new TextCompositeImpl(ComponentType.WORD);
    for (char ch : text.toCharArray()) {
      word.add(new Symbol(ch));
    }
    return word;
  }
}
