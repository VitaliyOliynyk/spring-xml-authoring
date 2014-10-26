package eu.vitaliy.springxmlauthoring;

import com.cc.controller.SimpleViewController;
import com.cc.tabs.TabGroup;
import com.cc.tabs.TabView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.fest.assertions.Assertions.*;

@ContextConfiguration("classpath:/META-INF/application-context-root.xml")
public class SpringXmlAuthoringContextTest extends AbstractTestNGSpringContextTests {

    private static final int COUNT_OF_TABS = 3;
    @Autowired
    private SimpleViewController tab1Controller;

    @Autowired
    private SimpleViewController tab2Controller;

    @Autowired
    private SimpleViewController tab3Controller;

    @Autowired
    private TabView tab1;

    @Autowired
    private TabView tab2;

    @Autowired
    private TabView tab3;

    @Autowired
    private TabGroup tabGroup;

    @Test
    public void applicationContextTest() {
        checkControllers(tab1Controller, tab2Controller, tab3Controller);
        checkTabs(tab1, tab2, tab3);
        checkTabGroup(tabGroup);
    }

    private void checkTabGroup(TabGroup tabGroup) {
        assertThat(tabGroup).isNotNull();
        assertThat(tabGroup.getTabs()).hasSize(COUNT_OF_TABS);
    }

    private void checkTabs(TabView ...  tabs) {
        for (TabView tab : tabs) {
            assertThat(tab).isNotNull();
            assertThat(tab.getController()).isNotNull();
        }

    }

    private void checkControllers(SimpleViewController... controllers) {
        for (SimpleViewController controller : controllers) {
            assertThat(controller).isNotNull();
        }
    }

}
