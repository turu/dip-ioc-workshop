package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.IStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;

/**
 * Author: Piotr Turek
 */
public abstract class AbstractStudent implements IStudent {
    private final IPaper paper;

    protected AbstractStudent(IPaper paper) {
        this.paper = paper;
    }

    @Override
    public IPaper getPaper() {
        return paper;
    }
}
