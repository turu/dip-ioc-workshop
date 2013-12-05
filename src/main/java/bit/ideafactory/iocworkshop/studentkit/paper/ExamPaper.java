package bit.ideafactory.iocworkshop.studentkit.paper;

import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.writers.Pen;

/**
 * Author: Piotr Turek
 */
public class ExamPaper extends AbstractPaper {
    @Override
    public boolean canAccept(String paragraph) {
        return paragraph.endsWith("*");
    }
}
