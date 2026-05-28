package org.design.pattern.creacionales.pattern04;

import lombok.Getter;
import lombok.Setter;
import org.design.pattern.util.ConsoleUtil;

public class Pattern04Prototype {

    static void main() {
        ConsoleUtil.initialize();

        Document document1 = new Document("Cotización", "500 dolares", "Mauro");
        ConsoleUtil.println(document1.toString());
        document1.displayInfo();

        Document document2 = document1.cloneDocument();
        document2.setTitle("Nueva cotización");
        ConsoleUtil.println(document2.toString());
        document2.displayInfo();

        ConsoleUtil.clean();
    }
}

@Getter
@Setter
class Document {

    public String title;
    public String author;
    private String content;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Document cloneDocument() {
        return new Document(title, content, author);
    }

    public void displayInfo() {
        ConsoleUtil.println(String.format(
            """
                Title: %s
                Content: %s
                Author: %s
                """, title, content, author
        ));
    }
}
