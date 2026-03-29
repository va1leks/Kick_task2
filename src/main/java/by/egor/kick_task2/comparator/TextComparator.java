package by.egor.kick_task2.comparator;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;

import java.util.Comparator;

public enum TextComparator implements Comparator<TextComponent> {

  BY_SENTENCES_COUNT {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
      return Integer.compare(((TextComposite)o1).getChildCount(), ((TextComposite)o2).getChildCount());

    }
  }
}
