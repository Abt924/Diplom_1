import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceTypeExist() {
        assertEquals("type SAUCE should exist", "SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTypeExist() {
        assertEquals("type FILLING should exist", "FILLING", IngredientType.FILLING.toString());
    }

}
