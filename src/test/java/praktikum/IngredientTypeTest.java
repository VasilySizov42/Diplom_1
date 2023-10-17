package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void values() {
        IngredientType[] expected = {IngredientType.SAUCE, IngredientType.FILLING};
        assertEquals(expected, IngredientType.values());
    }

    @Test
    public void valueOfSauce() {
        var expected = IngredientType.SAUCE;
        assertEquals(expected, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfFilling() {
        var expected = IngredientType.FILLING;
        assertEquals(expected, IngredientType.valueOf("FILLING"));
    }

}