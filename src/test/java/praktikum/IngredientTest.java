package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"brown goo", 57.99F);
    @Test
    public void getPriceTest() {
        Float expected = 57.99F;
        Float actual = ingredient.getPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        String expected = "brown goo";
        String actual = ingredient.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();

        Assert.assertEquals(expected, actual);
    }
}