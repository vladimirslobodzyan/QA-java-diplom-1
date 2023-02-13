import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;


@RunWith(Parameterized.class)
public class BurgerParametrizedTest {


    private String bunName;

    private String sauceName;

    private String fillingName;

    private float bunPrice;
    private float saucePrice;
    private float fillingPrice;

    private  float burgerPrice;




    public BurgerParametrizedTest(String bunName, String sauceName, String fillingName, float bunPrice, float saucePrice, float fillingPrice, float burgerPrice) {

        this.bunName = bunName;
        this.sauceName = sauceName;
        this.fillingName = fillingName;
        this.bunPrice = bunPrice;
        this.saucePrice = saucePrice;
        this.fillingPrice = fillingPrice;
        this.burgerPrice = burgerPrice;

    }


    @Before //создание бургера: булочка и три ингредиента
    public void createBurger() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
    }

    private Burger burger;
    Bun bun = Mockito.mock(Bun.class);

    Ingredient ingredientSauce = Mockito.mock(Ingredient.class);

    Ingredient ingredientFilling = Mockito.mock(Ingredient.class);



    @Parameterized.Parameters
    public static Object[][] setPriceData() {
        return new Object[][]{
                {"black bun", "chili sauce", "sausage",	300F, 300F,	300F, 1200F},
                {"white bun", "sour cream", "sausage", 100F, 200F, 100F, 500F},
                {"white bun", "chili sauce", "cutlet", 200F, 100F, 200F, 700F},
                {"white bun", "hot sauce", "dinosaur", 100F, 200F, 300F, 700F},
                {"white bun", "hot sauce", "dinosaur", 300F, 100F, 200F, 900F},
                {"red bun", "chili sauce", "dinosaur", 200F, 100F, 100F, 600F},
                {"red bun", "hot sauce", "cutlet", 300F, 200F, 200F, 1000F},
                {"red bun", "sour cream", "dinosaur", 100F, 100F,  300F, 600F},
                {"red bun", "hot sauce", "sausage", 200F, 200F, 100F, 700F},
                {"red bun", "sour cream","cutlet", 100F, 300F, 200F, 700F},
                {"black bun", "hot sauce", "dinosaur", 200F,  300F, 100F, 800F},
                {"black bun", "sour cream", "sausage", 100F, 100F, 200F, 500F},
                {"black bun", "hot sauce", "cutlet", 200F, 200F, 300F, 900F},
                {"black bun", "chili sauce", "cutlet", 100F, 200F, 200F, 600F},
                {"white bun", "sour cream", "cutlet", 300F, 200F, 100F, 900F},
                {"white bun", "hot sauce", "dinosaur", 100F, 300F, 200F, 700F},
                {"white bun", "sour cream", "cutlet", 200F, 100F, 300F, 800F},
                {"white bun", "chili sauce", "dinosaur", 100F, 200F, 100F, 500F},
                {"white bun", "hot sauce", "sausage", 200F,  100F, 200F, 700F},
        };
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(saucePrice);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(fillingPrice);

        Assert.assertEquals("Ошибка общей суммы бургера", burgerPrice, burger.getPrice(),0);
    }

    @Test
    public void getRecTest(){
        Mockito.when(ingredientSauce.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientFilling.getType()).thenReturn(FILLING);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);
        Mockito.when(ingredientSauce.getName()).thenReturn(sauceName);
        Mockito.when(ingredientFilling.getName()).thenReturn(fillingName);
        String expectedReceipt = "(====" + " " + bunName + " " + "====)\r\n" +
                "= sauce" + " " + sauceName + " " + "=\r\n" +
                "= filling" + " " + fillingName + " " + "=\r\n" +
                "(====" + " " + bunName + " " + "====)\r\n" + String.format("%nPrice: %f%n", burgerPrice);

        Assert.assertEquals("Ошибка печати рецепта", expectedReceipt, burger.getReceipt());
    }


}
