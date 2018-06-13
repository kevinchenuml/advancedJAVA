package edu.KevinChen.advancedjava.assignment1;

/**
 * A class that creates a slingshot
 *
 * @author Kevin Chen
 */

public class Slingshot {

    private String ammoType;
    private Integer ammoQuantity;

    /**
     *
     * @param ammoType is the type of ammo the slingshot is using
     * @param ammoQuantity is the numbers of shots you have to sling
     */

    public Slingshot (String ammoType, Integer ammoQuantity) {
        this.ammoType = ammoType;
        this.ammoQuantity = ammoQuantity;
    }

    /**
     *
     * @return the ammo type
     */

    public String getAmmoType() {
        return ammoType;
    }

    /**
     *
     * @return the ammo quantity
     */

    public Integer getAmmoQuantity() {
        return ammoQuantity;
    }

    public void setAmmoQuantity(Integer ammoQuantity) {
        this.ammoQuantity = ammoQuantity;
    }

    public void shootSlingShot () {
        Integer ammoQty = getAmmoQuantity() - 1;
        setAmmoQuantity(ammoQty);
    }

    public void reloadSlingShot (Integer reloadQty) {
        Integer newAmmoQty = getAmmoQuantity() + reloadQty;
        setAmmoQuantity(newAmmoQty);
    }
}
