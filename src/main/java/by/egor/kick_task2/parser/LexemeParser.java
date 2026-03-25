package by.egor.kick_task2.parser;

import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.composite.impl.Symbol;
import by.egor.kick_task2.composite.impl.TextCompositeImpl;
import by.egor.kick_task2.type.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {

  private static final String WORD_PUNCTUATION_REGEX = "([\\p{L}\\p{N}-]+)|([.!?，,;:'\"«»()\\[\\]]+)";
  private static final String PUNCTUATION_REGEX = "[.!?，,;:'\"«»()\\[\\]]+";
  @Override
  public TextComposite parse(String text) {
    TextComposite lexeme = new TextCompositeImpl(ComponentType.LEXEME);

    Pattern pattern = Pattern.compile(WORD_PUNCTUATION_REGEX);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      String token = matcher.group();
      if (token == null || token.isEmpty()) {
        continue;
      }
      if (token.matches(PUNCTUATION_REGEX)) {
        for (char ch : token.toCharArray()) {
          lexeme.add(new Symbol(ch));
        }
      }
      else {
        lexeme.add(nextParser.parse(token));
      }
    }
    return lexeme;
  }
}
