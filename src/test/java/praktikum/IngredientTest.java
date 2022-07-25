package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class IngredientTest {

    String name = "someName";
    float price = 123.83F;

    IngredientType ingredientType = FILLING;

    Ingredient ingredient = new Ingredient(ingredientType, name, price);


    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(), 0.0F);
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeFillingNotChangedFromConstructorTest() {
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getTypeSauceNotChangedFromConstructorTest() {
        var ingredientType = SAUCE;
        var ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}