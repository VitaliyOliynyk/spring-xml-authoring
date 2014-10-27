package eu.vitaliy.springxmlauthoring;

import eu.vitaliy.springcache.BardzoWolnyComponent;
import eu.vitaliy.springcache.Logger;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.fest.assertions.Assertions.*;
import java.util.List;

@ContextConfiguration("classpath:/META-INF/application-context-springcache-root.xml")
public class SpringCacheTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BardzoWolnyComponent bardzoWolnyComponent;

    @Logger
    private Log log;

    @Test
    public void barszoWolnaMetodaTest() {
        double czasWykonania = wykonajTestow(5);
        log.info("10 uruchomien za "+czasWykonania+"s");
    }

    private double wykonajTestow(int liczbaUruchomien) {
        long poczatek = System.nanoTime();

        for(int i=0;i<liczbaUruchomien;i++) {
            long poczatekUruchomenia = System.nanoTime();
            List<String> wynik = bardzoWolnyComponent.barszoWolnaMetoda("parametr1");
            assertThat(wynik).hasSize(BardzoWolnyComponent.ROZMIAR_LISTY);
            log.info("Uruchomienie #"+(i+1) + " :" + ((System.nanoTime()-poczatekUruchomenia)/1000000000d)+ "s");
        }
        return (System.nanoTime() - poczatek)/1000000000d;
    }


}