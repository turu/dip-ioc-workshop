package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.FoolStudent;
import bit.ideafactory.iocworkshop.student.HumanistStudent;
import bit.ideafactory.iocworkshop.student.ScientificStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Corrector;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.student.studentkit.paper.ExamPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pen;
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
    private final FoolStudent foolStudent = new FoolStudent(
            new Pen(),
            new LessonPaper()
    );
    private final HumanistStudent humanistStudent = new HumanistStudent(
            new Corrector(),
            new Pen(),
            new LessonPaper()
    );
    private final ScientificStudent scientificStudent = new ScientificStudent(
            new Pen(),
            new ExamPaper()
    );

    private Class instance;

    @Before
    public void setUp() throws Exception {
        instance = new Class();
        instance.addStudent(scientificStudent);
        instance.addStudent(humanistStudent);
        instance.addStudent(foolStudent);
    }

    @Test
    public void testWriteEssay() throws Exception {
        //given
        List<String> paragraphs = Arrays.asList("Par1", "Par2", "Par3");

        //when
        final Map<IStudent,IPaper> results = instance.writeEssay(paragraphs);

        //then
        assertThat(results.get(foolStudent).toString()).isEqualTo("*Par1Par2Par3*");
        assertThat(results.get(humanistStudent).toString()).isEqualTo("*Par**Par**Par*");
        assertThat(results.get(scientificStudent).toString()).isEqualTo("*Par1**Par2**Par3*");
    }
}
