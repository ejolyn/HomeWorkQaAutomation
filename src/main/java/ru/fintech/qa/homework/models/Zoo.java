package ru.fintech.qa.homework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }


    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Zoo)) {
            return false;
        }
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }
}
