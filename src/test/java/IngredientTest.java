import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100F},
                {SAUCE, "sour cream", 200F},
                {SAUCE, "chili sauce", 300F},
                {FILLING, "cutlet", 100F},
                {FILLING, "dinosaur", 200F},
                {FILLING, "sausage", 300F},
        };
    }

    @Before
    public void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetName() throws Exception {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Невалидное значение name", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() throws Exception {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Невалидное значение price", price, ingredient.getPrice(), 0F);
    }

    @Test
    public void testGetType() throws Exception {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Невалидное значение type", type, ingredient.getType());
    }
}
