package org.hibernate.bugs.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
