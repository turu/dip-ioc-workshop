package bit.ideafactory.iocworkshop.student.studentkit.paper.factories;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.ExamPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.IPaperFactory;

/**
 * Author: Piotr Turek
 */
public class ExamPaperFactory implements IPaperFactory {
    @Override
    public IPaper create() {
        return new ExamPaper();
    }
}
