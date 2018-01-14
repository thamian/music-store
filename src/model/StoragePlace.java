package model;

public class StoragePlace {

    private final int id;
    private final String name;

    public StoragePlace(int id, String name) {
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
