package bit.ideafactory.iocworkshop.student.studentkit.paper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Piotr Turek
 */
@Component(value = "paperForExam")
@Scope(value = "prototype")
public class ExamPaper extends AbstractPaper {
    @Override
    public boolean canAccept(String paragraph) {
        return paragraph.endsWith("*");
    }
}
