package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Author: Piotr Turek
 */
public class ScientificStudent extends AbstractStudent {
    private IWriter writer;

    public ScientificStudent(IPaper paper) {
        super(paper);
    }

    @Required
    public void setWriter(IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeEssay(List<String> paragraphs) {
        for (String paragraph : paragraphs) {
            final String writtenParagraph = writer.write(paragraph);
            final IPaper paper = getPaper();
            paper.addParagraph(writtenParagraph);
        }
    }

    @Override
    public String toString() {
        return "ScientificStudent";
    }

}
