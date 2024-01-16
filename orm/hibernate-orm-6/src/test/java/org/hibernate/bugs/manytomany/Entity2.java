package org.hibernate.bugs.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Entity2 {

    @Id
    @GeneratedValue
    private Long id;

    private String naturalId;

    public Entity2(final String naturalId) {
        this.naturalId = naturalId;
    }
}
