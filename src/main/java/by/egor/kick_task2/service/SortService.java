package by.egor.kick_task2.service;

import by.egor.kick_task2.comparator.MyComparator;
import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SortService {

  public List<TextComponent> sortText (TextComposite composite) {
    List<TextComponent> sentences = collectSentences(composite);
    sentences.sort(MyComparator.BY_SENTENCES_COUNT);
    return sentences;
  }

  private List<TextComponent> collectSentences (TextComposite composite) {
    List<TextComponent> sentences = new ArrayList<>();
    for (TextComponent paragraph : composite.getChildren()) {
      for (TextComponent sentence : ((TextComposite)paragraph).getChildren()) {
        sentences.add(sentence);
      }
    }
    return sentences;
  }
}
