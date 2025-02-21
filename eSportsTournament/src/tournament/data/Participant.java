package tournament.data;

public abstract class Participant {
    protected String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String playerName) {
        name = playerName;
    }

    @Override
    public String toString() {
        return name;
    }
}
