package com.example;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnListOfFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyReturnFelineFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutArgumentReturnOne() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithArgumentReturnArgument() {
        Feline feline = new Feline();
        //в этом тесте конечно тоже можно было применить параметризацию, но решила применить ее для Lion класса
        int expected = 33;
        int argument = 33;
        int actual = feline.getKittens(argument);
        assertEquals(expected, actual);
    }
}
