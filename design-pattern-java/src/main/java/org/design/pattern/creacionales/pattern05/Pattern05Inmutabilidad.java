package org.design.pattern.creacionales.pattern05;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

public class Pattern05Inmutabilidad {

    static void main() {
        ConsoleUtil.initialize();

        var history = new CodeEditorHistory();

        var editorState = new CodeEditorState("console.log('Hola Mundo');", 2, false);
        history.save(editorState);

        ConsoleUtil.println("Estado inicial", Color.BLUE);
        editorState.displayState();

        editorState = editorState.copyWith(EditorStateRequest.builder()
            .content("console.log('Hola Mundo'); \nconsole.log('Nueva linea');")
            .cursorPosition(3)
            .unsavedChanges(true)
            .build());

        history.save(editorState);

        ConsoleUtil.println("Despues del primer cambio", Color.BLUE);
        editorState.displayState();

        ConsoleUtil.println("Despues de mover el cursor", Color.BLUE);
        editorState = editorState.copyWith(EditorStateRequest.builder()
            .cursorPosition(5)
            .build());

        history.save(editorState);
        editorState.displayState();

        ConsoleUtil.println("Despues del undo", Color.BLUE);
        editorState = history.undo();

        editorState.displayState();

        ConsoleUtil.println("Despues del redo", Color.BLUE);
        editorState = history.redo();

        editorState.displayState();

        ConsoleUtil.clean();
    }
}

record CodeEditorState(String content, Integer cursorPosition, boolean unsavedChanges) {

    public CodeEditorState copyWith(EditorStateRequest request) {
        String content = request.content() != null ? request.content() : this.content;
        Integer cursorPosition =
            request.cursorPosition() != null ? request.cursorPosition() : this.cursorPosition;
        boolean unsavedChanges =
            request.unsavedChanges() != null ? request.unsavedChanges() : this.unsavedChanges;

        return new CodeEditorState(content, cursorPosition, unsavedChanges);
    }

    public void displayState() {
        ConsoleUtil.println("\nEstado del editor", Color.GREEN);

        ConsoleUtil.println(String.format(
            """
                Contenido: %s
                Cursor Pos: %s
                Unsaved changes: %s
                """, content, cursorPosition, unsavedChanges
        ));
    }
}

class CodeEditorHistory {

    private final List<CodeEditorState> history = new ArrayList<>();
    private Integer currentIndex = -1;

    public void save(CodeEditorState state) {
        /* Insecure in java
        if (currentIndex < history.size() - 1) {
            history = history.subList(0, currentIndex + 1);
        }*/
        while (history.size() - 1 > currentIndex) {
            history.removeLast();
        }

        history.add(state);
        currentIndex++;
    }

    public CodeEditorState undo() {
        if (currentIndex <= 0) {
            return null;
        }

        currentIndex--;
        return history.get(currentIndex);
    }

    public CodeEditorState redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            return history.get(currentIndex);
        }

        return null;
    }
}

@Builder
record EditorStateRequest(String content, Integer cursorPosition, Boolean unsavedChanges) {

}