package memento;

public class UsernameMemento {
    private final String savedUsername;

    public UsernameMemento(String savedUsername) {
        this.savedUsername = savedUsername;
    }

    public String getSavedUsername() {
        return savedUsername;
    }
}
