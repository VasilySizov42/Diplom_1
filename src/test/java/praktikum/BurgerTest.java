package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BurgerTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setBunsTest() {
        var burger = new Burger();
        burger.setBuns(bun);
        Assert.assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        var burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertSame(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        var burger = new Burger();
        burger.addIngredient(ingredient);
        var expected = burger.ingredients.size() - 1;
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        var burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 2);
        Assert.assertNotSame(ingredient, burger.ingredients.get(0));
        Assert.assertSame(ingredient, burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(105.95F);
        Mockito.when(ingredient.getPrice()).thenReturn(55.95F);
        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        var actual = burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        Mockito.verifyNoMoreInteractions(bun);
        Mockito.verifyNoMoreInteractions(ingredient);
        var expected = 105.95F*2 + 55.95F;
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("atomic bun");
        Mockito.when(bun.getPrice()).thenReturn(105.95F);
        Mockito.when(ingredient.getName()).thenReturn("brown goo");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(55.95F);
        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        var actual = burger.getReceipt();
        Mockito.verify(bun, Mockito.times((2*1))).getName();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        Mockito.verifyNoMoreInteractions(bun);
        Mockito.verifyNoMoreInteractions(ingredient);
        Assert.assertNotNull(actual);
        Assert.assertTrue((actual instanceof String) && !actual.isEmpty() && !actual.isBlank());
    }
}