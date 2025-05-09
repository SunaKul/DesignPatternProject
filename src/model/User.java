package model;

import memento.UsernameMemento;
import java.util.Stack;

public abstract class User {
    protected String username;
    protected Stack<UsernameMemento> history = new Stack<>();
    protected Stack<UsernameMemento> redoStack = new Stack<>();

    public User(String username) {
        this.username = username;
        saveUsernameToHistory();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        saveUsernameToHistory();
        this.username = newUsername;
        redoStack.clear();
    }

    private void saveUsernameToHistory() {
        if (history.size() == 3) history.remove(0);
        history.push(new UsernameMemento(username));
    }

    public void undoUsername() {
        if (!history.isEmpty()) {
            redoStack.push(new UsernameMemento(username));
            this.username = history.pop().getSavedUsername();
        }
    }

    public void redoUsername() {
        if (!redoStack.isEmpty()) {
            history.push(new UsernameMemento(username));
            this.username = redoStack.pop().getSavedUsername();
        }
    }
    
    public void printUsernameHistory() {
        System.out.println("Username history:");
        for (UsernameMemento memento : history) {
            System.out.println("- " + memento.getSavedUsername());
        }
    }


    public abstract void displayUserType();
}
