package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    Bun bun;
    List<Ingredient> ingredients;
    String expectedString;

    public BurgerReceiptTest(Bun b, List<Ingredient> lI, String eS) {
        bun = b;
        ingredients = lI;
        expectedString = eS;
    }

    @Parameterized.Parameters(name = " Булки: {0} | Список ингредиентов: {1} | Ожидаемый чек: {2}")
    public static Object[][] getBurgerReceiptData() {
        return new Object[][]{
                {new Bun("БУЛОЧКА", 1.5F), new ArrayList<>(List.of(new Ingredient(SAUCE, "СОУС", 2.0F)
                        , new Ingredient(FILLING, "НАЧИНКА", 5.55F))), String.format(
                        "(==== БУЛОЧКА ====)%n"
                                + "= sauce СОУС =%n"
                                + "= filling НАЧИНКА =%n"
                                + "(==== БУЛОЧКА ====)%n"
                                + "%nPrice: 10,550000%n")},
                {new Bun("БУЛОЧКА", 1.5F), new ArrayList<>(List.of(new Ingredient(FILLING, "НАЧИНКА", 5.55F)
                        , new Ingredient(SAUCE, "СОУС", 2.0F))), String.format(
                        "(==== БУЛОЧКА ====)%n"
                                + "= filling НАЧИНКА =%n"
                                + "= sauce СОУС =%n"
                                + "(==== БУЛОЧКА ====)%n"
                                + "%nPrice: 10,550000%n")},
                {new Bun("булочка", 1.5F), new ArrayList<>(List.of(new Ingredient(SAUCE, "соус", 2.0F)
                        , new Ingredient(FILLING, "начинка", 5.55F))), String.format(
                        "(==== булочка ====)%n"
                                + "= sauce соус =%n"
                                + "= filling начинка =%n"
                                + "(==== булочка ====)%n"
                                + "%nPrice: 10,550000%n")},
                {new Bun("Булочка", 1.5F), new ArrayList<>(List.of(new Ingredient(SAUCE, "Соус", 2.0F)
                        , new Ingredient(FILLING, "Начинка", 5.55F))), String.format(
                        "(==== Булочка ====)%n"
                                + "= sauce Соус =%n"
                                + "= filling Начинка =%n"
                                + "(==== Булочка ====)%n"
                                + "%nPrice: 10,550000%n")},
        };
    }

    @Test
    public void getReceipt() {
        var burger = new Burger();
        burger.bun = bun;
        burger.ingredients = ingredients;
        assertEquals(expectedString, burger.getReceipt());
    }

}