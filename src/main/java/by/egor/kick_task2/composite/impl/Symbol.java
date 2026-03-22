package by.egor.kick_task2.composite.impl;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.type.ComponentType;

public class Symbol implements TextComponent {

  private final char symbol;

  public Symbol(char symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getText() {
    return String.valueOf(symbol);
  }

  @Override
  public ComponentType getType() {
    return ComponentType.SYMBOL;
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
