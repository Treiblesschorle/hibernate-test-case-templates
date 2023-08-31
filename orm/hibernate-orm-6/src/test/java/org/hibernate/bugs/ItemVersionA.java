package org.hibernate.bugs;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

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
