package praktikum.constants;

import praktikum.IngredientType;

public class Constants {
    public static final float BUN_0_PRISE = 100;
    public static final String BUN_1_NAME = "white bun";
    public static final float BUN_1_PRISE = 200;
    public static final IngredientType SAUCE_TYPE = IngredientType.SAUCE;
    public static final float SAUCE_1_PRISE = 200;
    public static final IngredientType FILLING_TYPE = IngredientType.FILLING;
    public static final String FILLING_2_NAME = "sausage";
    public static final float FILLING_2_PRISE = 300;
    public static final Object[][] BUN_TESTING_DATA = new Object[][] {
            {"", -100},
            {" ", -.01f},
            {"s", 0},
            {"su", .01f},
            {"super bun", 100},
    };
    public static final Object[][] INGREDIENT_TESTING_DATA = new Object[][] {
            {SAUCE_TYPE, "", -100},
            {SAUCE_TYPE, " ", -.01f},
            {SAUCE_TYPE, "s", 0},
            {FILLING_TYPE, "su", .01f},
            {FILLING_TYPE, "super bun", 100},
    };

}
