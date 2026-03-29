package by.egor.kick_task2.composite.impl;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextCompositeImpl implements TextComposite {

  private final ComponentType type;
  private final List<TextComponent> components = new ArrayList<>();

  public TextCompositeImpl(ComponentType type) {
    this.type = type;
  }

  @Override
  public void add(TextComponent component) {
    components.add(component);
  }

  @Override
  public List<TextComponent> getChildren() {
    return new ArrayList<>(components);
  }

  @Override
  public void setChildren(List<TextComponent> children) {
    components.clear();
    components.addAll(children);
  }

  @Override
  public int getChildCount() {
    return components.size();
  }

  @Override
  public ComponentType getType() {
    return type;
  }

  @Override
  public int getCount() {
    int count = 0;
    for (TextComponent component : components) {
      count += component.getCount();
    }
    return count;
  }

  @Override
  public String toString() {
    StringBuilder text = new StringBuilder();
    for (TextComponent component : components) {
      text.append(component.toString());
    }
    if(type == ComponentType.LEXEME) {
      text.append(" ");
    }
    if(type == ComponentType.PARAGRAPH ) {
      text.append("\n");
    }
    return text.toString();
  }
}
