package by.egor.kick_task2.composite.impl;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.type.ComponentType;

public class Letter implements TextComponent {


  private final char letter;

  public Letter(char letter) {
    this.letter = letter;
  }

  @Override
  public String getText() {
    return String.valueOf(letter);
  }

  @Override
  public ComponentType getType() {
    return ComponentType.LETTER;
  }

  @Override
  public int getCount() {
    return 1;
  }

  @Override
  public String toString() {
    return getText();
  }

}
