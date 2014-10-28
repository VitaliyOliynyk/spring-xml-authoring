package eu.vitaliy.springcache;

import org.apache.commons.logging.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BardzoWolnyComponent {

    public static final int ROZMIAR_LISTY = 30;

    @Logger
    private Log log;

    @CacheEvict(value="barszoWolnaMetodaCache", allEntries=true)
    public void dodajNoweDane(){
    }


    @Cacheable(value="barszoWolnaMetodaCache", key = "#klucz+'_'+#uzytkownik", condition = "#uzytkownik.length() < 14")
    public List<String> barszoWolnaMetoda(String klucz, String uzytkownik, Date dataDostepu) {
        List<String> wynik = new ArrayList<String>(ROZMIAR_LISTY);
         for(int i=0; i<ROZMIAR_LISTY; i++) {
             String elementWyniku = klucz + "_" + i;
             wynik.add(elementWyniku);
             sleep(200);
             log.info(elementWyniku);
         }
         return wynik;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
