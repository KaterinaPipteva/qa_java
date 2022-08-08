package com.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;

    private String sex;
    private boolean hasManeExpected;

    public LionTest(String sex, boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Object[] testDataForLionConstructor() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void haseManeExpectedReturnHasMane() throws Exception {
        //arrange //act
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        //assert
        assertEquals(hasManeExpected, actual);
    }


@Test
    public void getKittensReturnNumberOfKittens() throws Exception{
        Lion lion = new Lion(sex, feline);
        int expectedNumberOfKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualNumberOfKittens = lion.getKittens();
        assertEquals(expectedNumberOfKittens, actualNumberOfKittens);
}

@Test
    public void getFoodReturnListOfPreditorFood() throws Exception{
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedLionFood = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualLionFood = lion.getFood();
        assertEquals(expectedLionFood, actualLionFood);

}




}
