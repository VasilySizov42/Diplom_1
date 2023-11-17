package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static praktikum.constants.Constants.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final int bunNumber;
    private final String expBunName;
    private final float expBunPrice;
    public BunTest(int bunNumber, String expBunName, float expBunPrice) {
        this.bunNumber = bunNumber;
        this.expBunName = expBunName;
        this.expBunPrice = expBunPrice;
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Spy
    Database database = new Database();
    Bun bun;

    @Parameterized.Parameters(name = "Тест булки. Тестовые данные: номер в базе-{0} название-{1} цена-{2}")
    public static Object[][] params() {
        return new Object[][] {
                { 0, BUN_0_NAME, BUN_0_PRISE},
                { 1, BUN_1_NAME, BUN_1_PRISE},
                { 2, BUN_2_NAME, BUN_2_PRISE},
        };
    }
    @Test
    public void getNameTest() {
        bun = database.availableBuns().get(bunNumber);
        Mockito.verify(database, Mockito.times(1)).availableBuns();
        Mockito.verifyNoMoreInteractions(database);
        String expected = expBunName;
        String actual = bun.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        bun = database.availableBuns().get(bunNumber);
        Mockito.verify(database, Mockito.times(1)).availableBuns();
        Mockito.verifyNoMoreInteractions(database);
        Float expected = expBunPrice;
        Float actual = bun.getPrice();

        Assert.assertEquals(expected, actual);
    }
}