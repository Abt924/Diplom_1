import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import org.junit.Test;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient cutlet;

    private Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);

        assertNotNull("Burger bun should be notNull", burger.bun);
        assertEquals("Bun should be the same bun as was set", bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(cutlet);

        assertTrue("Ingredient cutlet should be added",burger.ingredients.contains(cutlet));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);
        int count = burger.ingredients.size();
        int sauceIndex = burger.ingredients.indexOf(sauce);

        burger.removeIngredient(sauceIndex);
        assertFalse("Ingredient sauce should be removed", burger.ingredients.contains(sauce));
        assertEquals("Burger size should be decrease by one ingredient",
                count-1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);
        int count = burger.ingredients.size();

        int sauceIndex = burger.ingredients.indexOf(sauce);
        int newIndex = new Random().nextInt(burger.ingredients.size());
        burger.moveIngredient(sauceIndex,newIndex);

        assertEquals("Sauce expected on another index ",newIndex, burger.ingredients.indexOf(sauce));
        assertEquals("Size of burger should be the same", count, burger.ingredients.size());
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(sauce.getPrice()).thenReturn(10.5f);
        Mockito.when(cutlet.getPrice()).thenReturn(300f);

        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        assertEquals(burger.getPrice(), 810.5f, 0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Hot chilli");
        Mockito.when(sauce.getPrice()).thenReturn(10.5f);

        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getName()).thenReturn("cutlet");
        Mockito.when(cutlet.getPrice()).thenReturn(300f);

        String expReceipt = "(==== black bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce Hot chilli =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\nPrice: 810,500000\r\n";

        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        assertEquals("Receipt not as expected", expReceipt, burger.getReceipt());
    }







}
