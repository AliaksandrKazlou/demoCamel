package tasks;

import entity.Person;

public class SimpleObjectOnQueue extends Task {

    @Override
    protected void prepare () {
        body = new Person("Andrei",33);
    }
}
