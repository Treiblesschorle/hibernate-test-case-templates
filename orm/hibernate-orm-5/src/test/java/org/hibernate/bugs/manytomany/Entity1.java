package org.hibernate.bugs.manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Entity1 {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(name = "join_table",
            joinColumns = @JoinColumn(name = "entity_1_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "entity_2_id", referencedColumnName = "id"))
    private Set<Entity2> relatedEntities2;

    public void setRelatedEntities2(final Set<Entity2> relatedEntities2) {
        this.relatedEntities2 = relatedEntities2;
    }
}
