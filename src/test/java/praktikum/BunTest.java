package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private String bunName;
    private float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                //валидные имя и цена булочки
                {"Bulochka", 200},

                //валидная цена и вариации потенциально невалидного имени булочки
                {"200", 200},
                {" Bulochka", 200},
                {"Bulochka ", 200},
                {"Bul ka ", 200},
                {"Хлеб", 200},
                {"", 200},
                {" ", 200},
                {"!.%", 200},

                //валидное имя и вариации потенциально невалидной цены булочки
                {"Bulochka", 0}, //ноль
                {"Bulochka", -2000}, //отрицательное число
                {"Bulochka", 2/3F}, //дробное число со слешом
                {"Bulochka", 1.123456789F}, //дробное число с точкой
                {"Bulochka", 299999999999999999999999999999999999999F}, //число около максимальной границы float
                {"Bulochka", 0.0000000000000000000000000000000000000000000015F}, //число около минимальной границы float
        };
    }
    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), Settings.DELTA);
    }
}