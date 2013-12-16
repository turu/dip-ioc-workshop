package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.IStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Piotr Turek
 */
public abstract class AbstractStudent implements IStudent {
    private IPaper paper;

    protected AbstractStudent(IPaper paper) {
        this.paper = paper;
    }

    public AbstractStudent() {
    }

    @Override
    public IPaper getPaper() {
        return paper;
    }
}
