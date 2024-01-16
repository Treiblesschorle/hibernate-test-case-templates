package org.hibernate.bugs.joinedinheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ItemVersionB")
public class ItemVersionB extends ItemVersion {

    private Double number;

    public ItemVersionB(final Item item, final Double number) {
        super(item);
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }
}
