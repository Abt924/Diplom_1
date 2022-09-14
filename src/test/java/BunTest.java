import org.junit.Before;
import praktikum.Bun;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BunTest {
    final String expectedName = "red bun";
    final float expectedPrice = 10.0f;


    @Test
    public void createBunTest() {
        Bun bun = new Bun(expectedName, expectedPrice);

        assertNotNull("new bun instance should be notNull", bun);
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(expectedName, expectedPrice);

        assertEquals("Name should be as in constructor args", expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(expectedName, expectedPrice);

        assertEquals("Price should be as in constructor args", expectedPrice, bun.getPrice(), 0);
    }


}
