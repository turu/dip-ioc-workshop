package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Corrector;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.student.studentkit.paper.factories.ExamPaperFactory;
import bit.ideafactory.iocworkshop.student.studentkit.paper.factories.LessonPaperFactory;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pen;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pencil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
public class ClassIT {
    private MyClass instance;

    private IStudent foolStudent;
    private IStudent humanistStudent;
    private IStudent scientificStudent;

    private final ExamPaperFactory examPaperFactory = new ExamPaperFactory();
    private final LessonPaperFactory lessonPaperFactory = new LessonPaperFactory();
    private final Corrector corrector = new Corrector();
    private final Rubber rubber = new Rubber();
    private final Pen pen = new Pen();
    private final Pencil pencil = new Pencil();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testWriteEssay() throws Exception {
        //given
        List<String> paragraphs = Arrays.asList("Par1", "Par2", "Par3");

        //when
        final Map<IStudent,IPaper> results = instance.writeEssay(paragraphs);

        //then
        assertThat(results.get(foolStudent).toString()).isEqualTo("*Par1Par2Par3*");
        assertThat(results.get(humanistStudent).toString()).isEqualTo("^Par^^Par^^Par^");
        assertThat(results.get(scientificStudent).toString()).isEqualTo("*Par1**Par2**Par3*");
    }
}
