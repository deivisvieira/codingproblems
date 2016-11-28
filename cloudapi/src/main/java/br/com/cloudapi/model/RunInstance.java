package br.com.cloudapi.model;

/**
 * Created by manuele on 28/11/16.
 */
public class RunInstance {

    private final long id;
    private final String content;

    public RunInstance(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
