package model;

public class ItemCondition {

    private final int id;
    private final String name;

    public ItemCondition(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
