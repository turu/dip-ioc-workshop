package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IPaper;

import java.util.List;

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
