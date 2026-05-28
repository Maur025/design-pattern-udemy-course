package org.design.pattern.creacionales.pattern04;

import lombok.Getter;
import lombok.Setter;
import org.design.pattern.util.ConsoleUtil;

interface PrototypeExample<T> {

    T copy();
}

public class Pattern04PrototypeJavaStyle {

    static void main() {
        ConsoleUtil.initialize();

        OtherDocument document1 = new OtherDocument("Cotización", "500 dolares", "Mauro");
        ConsoleUtil.println(document1.toString());
        document1.displayInfo();

        OtherDocument document2 = document1.copy();
        document2.setTitle("Nueva cotización");
        ConsoleUtil.println(document2.toString());
        document2.displayInfo();

        ConsoleUtil.clean();
    }
}

@Getter
@Setter
class OtherDocument implements PrototypeExample<OtherDocument> {

    public String title;
    public String author;
    private String content;

    public OtherDocument(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public OtherDocument(OtherDocument otherDocument) {
        this.title = otherDocument.title;
        this.content = otherDocument.content;
        this.author = otherDocument.author;
    }

    @Override
    public OtherDocument copy() {
        return new OtherDocument(this);
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