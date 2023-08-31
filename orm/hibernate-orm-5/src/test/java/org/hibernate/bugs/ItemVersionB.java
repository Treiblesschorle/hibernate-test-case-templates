package org.hibernate.bugs;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
