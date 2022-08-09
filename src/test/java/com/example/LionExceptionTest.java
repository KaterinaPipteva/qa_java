package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {
    @Mock
    Feline feline;

    //Комментарий для ревьюера:
    //Не поняла почему старая реализация не подходила, у меня старый тест падает, если выставить
    //коректные данные, например, "Самка" в параметр sex. И тест проходит, если выставить некорректный параметр

    //Старый тест закомментировала (знаю что лучше его убрать совсем)
   /* @Test(expected = Exception.class)
    public void lionConstructorGetException() throws Exception{
        try {
            Lion lion = new Lion("Самка", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }*/

    //но перепишу по вашему совету тест с assertTrows (с ним, конечно, тест стал более аккуратным)

    @Test
    public void lionConstructorGetException() {
        Exception exception = assertThrows(Exception.class, () -> { Lion lion = new Lion("Интерсекс", feline);});
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
    }
}
