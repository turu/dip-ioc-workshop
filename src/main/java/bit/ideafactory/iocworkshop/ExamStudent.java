package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.erasers.Corrector;
import bit.ideafactory.iocworkshop.studentkit.paper.ExamPaper;
import bit.ideafactory.iocworkshop.studentkit.writers.Pen;

/**
 * Author: Piotr Turek
 */
public class ExamStudent extends Student {
    public ExamStudent() {
        super();
        this.paper = new ExamPaper();
        this.eraser = new Corrector();
        this.writer = new Pen();
    }
}
