package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.Student;
import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Corrector;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.student.studentkit.paper.ExamPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pen;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pencil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Piotr Turek
 */
public class HumanistStudentIT {
    @Test
    public void testWriteEssay() throws Exception {
        //given
        final IWriter pencil = new Pencil();
        final IEraser rubber = new Rubber();
        final IPaper lessonPaper = new LessonPaper();
        final IStudent student = new HumanistStudent(rubber, pencil, lessonPaper);
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
        final IWriter pen = new Pen();
        final IEraser corrector = new Corrector();
        final IPaper examPaper = new ExamPaper();
        final IStudent examStudent = new HumanistStudent(corrector, pen, examPaper);
        final List<String> pars = Arrays.asList("Par1", "Par2", "Par3");

        //when
        examStudent.writeEssay(pars);

        //then
        final IPaper paper = examStudent.getPaper();
        assertThat(paper.toString()).isEqualTo("*Par**Par**Par*");
    }

}
