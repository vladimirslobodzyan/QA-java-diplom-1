import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.MockitoAnnotations;

import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {


    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void initMockito() {
        MockitoAnnotations.openMocks(this);
    }


    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"black bun", 100F},
                {"white bun", 200F},
                {"red bun", 300F}
        };
    }

    @Test
    public void testGetName() throws Exception {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Невалидное значение name", name, bun.getName());
    }

    @Test
    public void testGetPrice() throws Exception {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Невалидное значение зкшсу", price, bun.getPrice(), 0F);
    }
}


