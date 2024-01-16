package org.hibernate.bugs.joinedinheritance;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
