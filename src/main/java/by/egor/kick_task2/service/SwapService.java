package by.egor.kick_task2.service;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;
import java.util.Collections;
import java.util.List;

public class SwapService {

  public TextComposite swapLexem(TextComposite textComposite) {
    for (TextComponent paragraph : textComposite.getChildren()) {
      for (TextComponent sentence : ((TextComposite) paragraph).getChildren()) {
        List<TextComponent> lexemes = ((TextComposite) sentence).getChildren();
                Collections.swap(lexemes,0,lexemes.size()-1);
        ((TextComposite) sentence).setChildren(lexemes);
      }
    }
    return textComposite;
  }

}
