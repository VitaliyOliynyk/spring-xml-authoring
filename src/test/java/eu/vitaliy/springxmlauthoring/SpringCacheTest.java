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
        wykonajTestow(5, "klucz1", "uzytkownik1", new Date());
        wykonajTestow(3, "klucz1", "uzytkownik1", new Date());
    }

    private void wykonajTestow(int liczbaUruchomien, String klucz, String uzytkownik, Date dataDostepu) {
        long poczatek = System.nanoTime();

        for(int i=0;i<liczbaUruchomien;i++) {
            long poczatekUruchomenia = System.nanoTime();
            List<String> wynik = bardzoWolnyComponent.barszoWolnaMetoda(klucz, uzytkownik, dataDostepu);
            assertThat(wynik).hasSize(BardzoWolnyComponent.ROZMIAR_LISTY);
            log.info("Uruchomienie #"+(i+1) + " :" + ((System.nanoTime()-poczatekUruchomenia)/1000000000d)+ "s");
        }
        log.info(liczbaUruchomien + " uruchomien za "+((System.nanoTime() - poczatek)/1000000000d)+"s");
    }


}
