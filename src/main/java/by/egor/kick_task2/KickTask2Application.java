package by.egor.kick_task2;

import by.egor.kick_task2.composite.TextComponent;
import by.egor.kick_task2.composite.TextComposite;
import by.egor.kick_task2.parser.*;
import by.egor.kick_task2.reader.MyFileReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KickTask2Application {

  public static void main(String[] args) {
    // 1. Тестовый текст (слова, знаки, кавычки)
    MyFileReader myFileReader = new MyFileReader();
    String input = new String();
    try {
    input = myFileReader.readAll("data/input");
    }
    catch (Exception e) {
      System.out.println(e);
    }


    System.out.println("📝 Исходный текст: \"" + input + "\"\n");

    // 2. Создаём парсеры
    AbstractTextParser textParser = new TextParser();
    AbstractTextParser paragraphParser = new ParagraphParser();
    AbstractTextParser sentenceParser = new SentenceParser();
    AbstractTextParser lexemeParser = new LexemeParser();
    AbstractTextParser wordParser = new WordParser();

    // 3. Собираем цепочку (от общего к частному)
    textParser.setNextParser(paragraphParser);
    paragraphParser.setNextParser(sentenceParser);
    sentenceParser.setNextParser(lexemeParser);
    lexemeParser.setNextParser(wordParser);

    // 4. Запускаем парсинг
    TextComposite result = textParser.parse(input);
    System.out.println(result.getCount());
    // 5. Выводим структуру дерева
    System.out.println("🌳 Структура дерева:");
    printTree(result, 0);

    // 6. Проверяем восстановление текста
    System.out.println("\n📄 Восстановленный текст: \"" + result.getText() + "\"");

    // 7. Сверка
    if (input.equals(result.getText())) {
      System.out.println("✅ Текст восстановлен ТОЧНО!");
    } else {
      System.out.println("⚠️ Есть отличия!");
    }

    // 8. Пример навигации: поиск знаков препинания
    System.out.println("\n🔍 Найденные знаки препинания:");
    findPunctuation(result);
  }

  // Рекурсивный вывод дерева с отступами
  private static void printTree(TextComponent node, int level) {
    String indent = "  ".repeat(level);
    String type = node.getType().toString();
    String text = node.getText();

    // Обрезаем длинный текст для красоты
    if (text.length() > 30) {
      text = text.substring(0, 30) + "...";
    }

    System.out.println(indent + type + ": \"" + text + "\"");

    // Если узел составной — рекурсивно печатаем детей
    if (node instanceof TextComposite) {
      for (TextComponent child : ((TextComposite) node).getChildren()) {
        printTree(child, level + 1);
      }
    }
  }

  // Поиск и вывод всех знаков препинания (листьев)
  private static void findPunctuation(TextComponent node) {
    // Если это лист Symbol и его текст — знак препинания
    if (!(node instanceof TextComposite) && node.getText().matches("[.!?，,;:'\"«»()\\[\\]—–-]")) {
      System.out.println("  - Символ: '" + node.getText() + "'");
    }
    // Рекурсивный обход детей
    if (node instanceof TextComposite) {
      for (TextComponent child : ((TextComposite) node).getChildren()) {
        findPunctuation(child);
      }
    }
  }
}
