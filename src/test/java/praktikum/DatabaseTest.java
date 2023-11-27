package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsTest() {
        Assert.assertFalse(database.availableBuns().isEmpty());
    }
    @Test
    public void bunsSizeTest() {
        Assert.assertEquals(3, database.availableBuns().size());
    }
    @Test
    public void availableIngredientsTest() {
        Assert.assertFalse(database.availableIngredients().isEmpty());
    }
    @Test
    public void ingredientsSizeTest() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }
}
