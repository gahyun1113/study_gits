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

    public void setName(String name) {
        this.name = name;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
