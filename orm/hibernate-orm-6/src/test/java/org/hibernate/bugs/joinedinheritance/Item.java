package org.hibernate.bugs.joinedinheritance;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Item")
public class Item  {

    @Id
    @GeneratedValue
    private Long id;

    private String externalId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="item")
    private List<ItemVersion> itemVersions;

    public Item(final String uuid) {
        this.externalId = uuid;
    }
}
