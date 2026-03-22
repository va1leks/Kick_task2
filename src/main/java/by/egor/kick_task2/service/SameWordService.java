package by.egor.kick_task2.service;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.type.ComponentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class SameWordService {

  Logger logger = LoggerFactory.getLogger(SameWordService.class);

  public int countSentencesWithDuplicates (TextComposite text) {
    int count = 0;
    for (TextComponent paragraph : text.getChildren()){
      for (TextComponent sentence : ((TextComposite)paragraph).getChildren()){
        if (hasDuplicates(sentence)){
          count++;
        }
      }
    }
    return count;
  }

  private boolean hasDuplicates (TextComponent sentence) {
    Set<String> words = new HashSet<>();
    for(TextComponent lexem : ((TextComposite)sentence).getChildren()) {
      for (TextComponent word : ((TextComposite) lexem).getChildren()) {
        if (word.getType() == ComponentType.WORD) {
          String wordText = word.getText().toLowerCase();
          if (!words.add(wordText)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
