package tasks;

public class PlainTextTask extends Task {

    public static final String TEXT = "Message with plain text and no more";

    @Override
    protected void prepare () {
        body = TEXT;
    }

}
