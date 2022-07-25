package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    String bunName = "someBun";
    float bunPrice = 123.23F;

    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getNameConstructorParamNotChangedTest() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceConstructorParamNotChangedTest() {
        assertEquals(bunPrice, bun.getPrice(), 0.0F);
    }
}