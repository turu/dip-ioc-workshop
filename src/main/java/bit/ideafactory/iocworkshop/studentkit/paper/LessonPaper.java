package bit.ideafactory.iocworkshop.studentkit.paper;

import bit.ideafactory.iocworkshop.studentkit.IWriter;

/**
 * Author: Piotr Turek
 */
public class LessonPaper extends AbstractPaper {
    @Override
    public boolean canAccept(String paragraph) {
        return true;
    }
}
