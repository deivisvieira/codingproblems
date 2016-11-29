package br.com.cloudapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by manuele on 28/11/16.
 */
@Entity
public class RunInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

}
