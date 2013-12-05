package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.paper.ExamPaper;

/**
 * Author: Piotr Turek
 */
public class ExamStudent extends Student {
    public ExamStudent() {
        super();
        this.paper = new ExamPaper();
    }
}
