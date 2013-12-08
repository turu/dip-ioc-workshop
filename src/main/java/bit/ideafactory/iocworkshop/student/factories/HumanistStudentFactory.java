package bit.ideafactory.iocworkshop.student.factories;

import bit.ideafactory.iocworkshop.IStudent;
import bit.ideafactory.iocworkshop.student.IStudentFactory;
import bit.ideafactory.iocworkshop.student.HumanistStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import bit.ideafactory.iocworkshop.student.studentkit.paper.IPaperFactory;

/**
 * Author: Piotr Turek
 */
public class HumanistStudentFactory implements IStudentFactory {
    private final IPaperFactory paperFactory;
    private final IEraser eraser;
    private final IWriter writer;

    public HumanistStudentFactory(IPaperFactory paperFactory, IEraser eraser, IWriter writer) {
        this.paperFactory = paperFactory;
        this.eraser = eraser;
        this.writer = writer;
    }

    @Override
    public IStudent create() {
        return new HumanistStudent(eraser, writer, paperFactory.create());
    }
}
