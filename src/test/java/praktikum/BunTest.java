package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("atomic bun", 100.55F);
    @Test
    public void getNameTest() {
        String expected = "atomic bun";
        String actual = bun.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Float expected = 100.55F;
        Float actual = bun.getPrice();

        Assert.assertEquals(expected, actual);
    }
}