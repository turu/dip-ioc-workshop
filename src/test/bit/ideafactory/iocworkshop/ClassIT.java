package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.sun.istack.internal.Nullable;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
public class ClassIT {
    private Class instance;

    @Before
    public void setUp() throws Exception {
        instance = new Class();
        instance.addFoolStudent();
        instance.addHumanistStudent();
        instance.addScientificStudent();
    }

    @Test
    public void testWriteEssay() throws Exception {
        //given
        List<String> paragraphs = Arrays.asList("Par1", "Par2", "Par3");

        //when
        final Map<IStudent,IPaper> results = instance.writeEssay(paragraphs);

        //then
        final Collection<IPaper> values = results.values();
        assertThat(Iterables.transform(values, new Function<IPaper, String>() {
            @Override
            public String apply(@Nullable IPaper paper) {
                return paper.toString();
            }
        })).containsOnly("*Par1Par2Par3*", "*Par1**Par2**Par3*", "^Par^^Par^^Par^");
    }
}
