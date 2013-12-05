package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.paper.LessonPaper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
public class StudentIT {
    private Student instance;

    @Before
    public void setUp() throws Exception {
        instance = new Student();
    }


    @Test
    public void testWriteEssay() throws Exception {
        //given
        final List<String> pars = Arrays.asList("Par1", "Par2", "Par3");

        //when
        instance.writeEssay(pars);

        //then
        final LessonPaper paper = instance.getPaper();
        assertThat(paper.toString()).isEqualTo("^Par^^Par^^Par^");
    }

}
