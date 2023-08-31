package org.hibernate.bugs;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ItemVersionA")
public class ItemVersionA extends ItemVersion {

    private String description;

    public ItemVersionA(final Item item, final String description) {
        super(item);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
