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
public class IngredientTest {
    private final int ingredientNumber;
    private final IngredientType expIngredientType;
    private final String expIngredientName;
    private final float expIngredientPrice;
    public IngredientTest(int ingredientNumber, IngredientType expIngredientType, String expIngredientName, float expIngredientPrice) {
        this.ingredientNumber = ingredientNumber;
        this.expIngredientType = expIngredientType;
        this.expIngredientName = expIngredientName;
        this.expIngredientPrice = expIngredientPrice;
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Spy
    Database database = new Database();
    Ingredient ingredient;

    @Parameterized.Parameters(name = "Тест ингредиента. Тестовые данные: номер в базе-{0} тип-{1} название-{2} цена-{3}")
    public static Object[][] params() {
        return new Object[][] {
                { 0, SAUCE_TYPE, SAUCE_0_NAME, SAUCE_0_PRISE},
                { 1, SAUCE_TYPE, SAUCE_1_NAME, SAUCE_1_PRISE},
                { 2, SAUCE_TYPE, SAUCE_2_NAME, SAUCE_2_PRISE},
                { 3, FILLING_TYPE, FILLING_0_NAME, FILLING_0_PRISE},
                { 4, FILLING_TYPE, FILLING_1_NAME, FILLING_1_PRISE},
                { 5, FILLING_TYPE, FILLING_2_NAME, FILLING_2_PRISE},
        };
    }
    @Test
    public void getPriceTest() {
        ingredient = database.availableIngredients().get(ingredientNumber);

        Float expected = expIngredientPrice;
        Float actual = ingredient.getPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        ingredient = database.availableIngredients().get(ingredientNumber);
        Mockito.verify(database, Mockito.times(1)).availableIngredients();
        Mockito.verifyNoMoreInteractions(database);
        String expected = expIngredientName;
        String actual = ingredient.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        ingredient = database.availableIngredients().get(ingredientNumber);
        Mockito.verify(database, Mockito.times(1)).availableIngredients();
        Mockito.verifyNoMoreInteractions(database);
        IngredientType expected = expIngredientType;
        IngredientType actual = ingredient.getType();

        Assert.assertEquals(expected, actual);
    }
}