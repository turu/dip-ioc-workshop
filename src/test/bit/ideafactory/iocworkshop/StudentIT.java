package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IPaper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
public class StudentIT {
    private Student student;
    private ExamStudent examStudent;

    @Before
    public void setUp() throws Exception {
        student = new Student();
        examStudent = new ExamStudent();
    }


    @Test
    public void testWriteEssay() throws Exception {
        //given
        final List<String> pars = Arrays.asList("Par1", "Par2", "Par3");

        //when
        student.writeEssay(pars);

        //then
        final IPaper paper = student.getPaper();
        assertThat(paper.toString()).isEqualTo("^Par^^Par^^Par^");
    }

    @Test
    public void testWriteExam() throws Exception {
        //given
        final List<String> pars = Arrays.asList("Par1", "Par2", "Par3");

        //when
        examStudent.writeEssay(pars);

        //then
        final IPaper paper = examStudent.getPaper();
        assertThat(paper.toString()).isEqualTo("^Par^^Par^^Par^");
    }

}
