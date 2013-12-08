package bit.ideafactory.iocworkshop.student.studentkit.paper.factories;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.IPaperFactory;
import bit.ideafactory.iocworkshop.student.studentkit.paper.LessonPaper;

/**
 * Author: Piotr Turek
 */
public class LessonPaperFactory implements IPaperFactory {
    @Override
    public IPaper create() {
        return new LessonPaper();
    }
}
