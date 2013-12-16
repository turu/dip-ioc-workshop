package bit.ideafactory.iocworkshop.student.studentkit.paper;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Piotr Turek
 */
@Component
@Scope(value = "prototype")
public class LessonPaper extends AbstractPaper {
    @Override
    public boolean canAccept(String paragraph) {
        return true;
    }
}
