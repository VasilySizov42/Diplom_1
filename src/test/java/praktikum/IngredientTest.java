package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.constants.Constants.INGREDIENT_TESTING_DATA;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    public IngredientTest(IngredientType ingredientType,
                          String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }
    Ingredient ingredient;

    @Parameterized.Parameters(name = "Тест ингредиента. Тестовые данные: тип-{0} название-{1} цена-{2}")
    public static Object[][] params() {
        return INGREDIENT_TESTING_DATA;
    }
    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Float expected = ingredientPrice;
        Float actual = ingredient.getPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String expected = ingredientName;
        String actual = ingredient.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType expected = ingredientType;
        IngredientType actual = ingredient.getType();

        Assert.assertEquals(expected, actual);
    }
}