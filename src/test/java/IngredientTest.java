import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expType;
    private final String expName;
    private final float expPrice;

    public IngredientTest(IngredientType type, String name, float price) {
        this.expType = type;
        this.expName = name;
        this.expPrice = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        return new Object[][]{{IngredientType.SAUCE, "hot sauce", 100}, {IngredientType.FILLING, "cutlet", 300}, {IngredientType.FILLING, "cutlet", 300.10f},};// передали тестовые данные
    }

    @Test
    public void createIngredient() {
        Ingredient ingredient = new Ingredient(expType, expName, expPrice);
        assertNotNull("new Ingredient instance should be created but Null", ingredient);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(expType, expName, expPrice);

        assertEquals("Ingredient Price should be as in constructor args", expPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(expType, expName, expPrice);

        assertEquals("Ingredient Name should be as in constructor args", expName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(expType, expName, expPrice);

        assertEquals("Ingredient Type should be as in constructor args", expType, ingredient.getType());
    }
}
