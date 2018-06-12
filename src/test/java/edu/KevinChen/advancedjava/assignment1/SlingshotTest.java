package edu.KevinChen.advancedjava.assignment1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Junit Test for slingshot class
 *
 * @author Kevin Chen
  */

public class SlingshotTest {

    private String ammoType;
    private Integer ammoQuantity;

    @Before
    public void setup() {
        ammoType = "Rocks";
        ammoQuantity = 50;
    }

    @Test
    public void testSlingshot() {
        Slingshot slingshot = new Slingshot(ammoType, ammoQuantity);

        assertEquals("The ammo type is set", slingshot.getAmmoType(), ammoType);
        assertEquals("The ammo quantity is set", slingshot.getAmmoQuantity(), ammoQuantity);

    }

    @Test
    public void testShootSlingShot() {
        Slingshot slingshot = new Slingshot(ammoType, ammoQuantity);
        Integer afterShot = ammoQuantity - 1;
        slingshot.shootSlingShot();

        assertEquals("Ammo is deducted correctly", slingshot.getAmmoQuantity(), afterShot);

    }

    @Test
    public void testReloadSlingShot() {
        Slingshot slingshot = new Slingshot(ammoType, ammoQuantity);
        Integer afterReload = ammoQuantity + 5;
        slingshot.reloadSlingShot(5);

        assertEquals("Ammo is added correctly", slingshot.getAmmoQuantity(), afterReload);
    }

}