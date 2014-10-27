package eu.vitaliy.springxmlauthoring;

import eu.vitaliy.springcache.BardzoWolnyComponent;
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

    @Test
    public void barszoWolnaMetodaTest() {
        List<String> wynik = bardzoWolnyComponent.barszoWolnaMetoda("parametr1");
        assertThat(wynik).hasSize(BardzoWolnyComponent.ROZMIAR_LISTY);
    }
}
