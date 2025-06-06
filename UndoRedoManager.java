import java.util.Stack;

public class UndoRedoManager {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void record(String action) {
        undoStack.push(action);
        redoStack.clear();
    }

    public String undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            return "Undo: " + action;
        }
        return "Nothing to undo.";
    }

    public String redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            return "Redo: " + action;
        }
        return "Nothing to redo.";
    }
}
