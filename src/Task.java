import java.util.ArrayList;

public class Task {

    String name;
    String description;
    boolean completion;

    Task(String name, String description, boolean completion) {
        this.name = name;
        this.description = description;
        this.completion = completion;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    boolean getCompletion() {
        return this.completion;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setCompletion(boolean completion) {
        this.completion = completion;
    }

    @Override
    public String toString() {
        return "teste" + name + description + completion;
    }
}
