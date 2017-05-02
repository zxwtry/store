package code02_UserDefinedTypeHandler.po;

public enum Sex {
    MALE(1, "男"), FEMALE(2, "女");
    private int id;
    private String name;
    private Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Sex getSex(int id) {
        if (id == 1) return Sex.MALE;
        return id == 2 ? Sex.FEMALE : null;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
