package bit.ideafactory.iocworkshop.student.factories;

import bit.ideafactory.iocworkshop.IStudent;
import bit.ideafactory.iocworkshop.student.IStudentFactory;
import bit.ideafactory.iocworkshop.student.ScientificStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import bit.ideafactory.iocworkshop.student.studentkit.paper.IPaperFactory;

/**
 * Author: Piotr Turek
 */
public class ScientificStudentFactory implements IStudentFactory {
    private final IPaperFactory paperFactory;
    private final IWriter writer;

    public ScientificStudentFactory(IPaperFactory paperFactory, IWriter writer) {
        this.paperFactory = paperFactory;
        this.writer = writer;
    }

    @Override
    public IStudent create() {
        return new ScientificStudent(writer, paperFactory.create());
    }
}
