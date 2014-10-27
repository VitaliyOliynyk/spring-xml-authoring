package eu.vitaliy.springxmlauthoring;

import com.cc.controller.SimpleViewController;
import com.cc.tabs.TabGroup;
import com.cc.tabs.TabView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration("classpath:/META-INF/application-context-root-schama-based.xml")
public class SpringXmlAuthoringContextSchemaBasedTest extends AbstractSpringXmlAuthoringContextTest {
}
