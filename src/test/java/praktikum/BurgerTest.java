package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class BurgerTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setBunsTest() {
        var burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        var burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
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
    }
}