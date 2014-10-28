package eu.vitaliy.springxmlauthoring;

import eu.vitaliy.springcache.BardzoWolnyComponent;
import eu.vitaliy.springcache.Logger;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.fest.assertions.Assertions.*;

import java.util.Date;
import java.util.List;

@ContextConfiguration("classpath:/META-INF/application-context-springcache-root.xml")
public class SpringCacheTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BardzoWolnyComponent bardzoWolnyComponent;

    @Logger
    private Log log;

    @Test
    public void barszoWolnaMetodaTest() {
        wykonajTestow(5, "klucz1", "uzytkownik1", new Date(), true);
        wykonajTestow(3, "klucz1", "uzytkownik1", new Date(), true);
    }

    @Test
    public void barszoWolnaMetodaInvalidateTest() {
        wykonajTestow(1, "klucz1", "uzytkownik1", new Date(), false);
        wykonajTestow(1, "klucz2", "uzytkownik2", new Date(), false);
        bardzoWolnyComponent.dodajNoweDane("klucz1");
        wykonajTestow(1, "klucz1", "uzytkownik1", new Date(), false);
        wykonajTestow(1, "klucz2", "uzytkownik2", new Date(), false);
    }


    private void wykonajTestow(int liczbaUruchomien, String klucz, String uzytkownik, Date dataDostepu, boolean invaliduj) {
        long poczatek = System.nanoTime();
        for(int i=0;i<liczbaUruchomien;i++) {
            if(invaliduj && i % 2 == 0) {
                bardzoWolnyComponent.dodajNoweDane(klucz);
            }

            long poczatekUruchomenia = System.nanoTime();
            List<String> wynik = bardzoWolnyComponent.barszoWolnaMetoda(klucz, uzytkownik, dataDostepu);
            assertThat(wynik).hasSize(BardzoWolnyComponent.ROZMIAR_LISTY);
            log.info("Uruchomienie #"+(i+1) + " :" + ((System.nanoTime()-poczatekUruchomenia)/1000000000d)+ "s");
        }

        log.info(liczbaUruchomien + " uruchomien za "+((System.nanoTime() - poczatek)/1000000000d)+"s");
    }


}
