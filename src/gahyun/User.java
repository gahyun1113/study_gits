package gahyun;

public class User {

    private String name;
    private Todo todo;

    public User(String name, Todo todo) {
        this.name = name;
        this.todo = todo;
    }

    public String getName() {
        return name;
    }

    public Todo getTodo() {
        return todo;
    }

}
