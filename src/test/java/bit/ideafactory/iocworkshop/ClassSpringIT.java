package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.sun.istack.internal.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:classSpringITContext.xml"})
public class ClassSpringIT {

    @Autowired
    @Qualifier(value = "studentClass")
    private MyClass myClass;

    @Test
    public void testName() throws Exception {
        //given
        List<String> paragraphs = Arrays.asList("Par1", "Par2", "Par3");

        //when
        final Map<IStudent,IPaper> results = myClass.writeEssay(paragraphs);

        //then
        final Collection<IPaper> values = results.values();
        assertThat(Iterables.transform(values, new Function<IPaper, String>() {
            @Override
            public String apply(@Nullable bit.ideafactory.iocworkshop.student.studentkit.IPaper paper) {
                return paper.toString();
            }
        })).containsOnly("*Par1Par2Par3*", "^Par^^Par^^Par^", "*Par1**Par2**Par3*");
    }
}
