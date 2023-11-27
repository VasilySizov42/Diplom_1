package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.constants.Constants.BUN_TESTING_DATA;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    Bun bun;

    @Parameterized.Parameters(name = "Тест булки. Тестовые данные: название-{0} цена-{1}")
    public static Object[][] params() {
        return BUN_TESTING_DATA;
    }
    @Test
    public void getNameTest() {
        bun = new Bun(bunName, bunPrice);
        String expected = bunName;
        String actual = bun.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        bun = new Bun(bunName, bunPrice);
        Float expected = bunPrice;
        Float actual = bun.getPrice();

        Assert.assertEquals(expected, actual);
    }
}