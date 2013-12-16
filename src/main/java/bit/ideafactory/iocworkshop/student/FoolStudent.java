package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Author: Piotr Turek
 */
public class FoolStudent extends AbstractStudent {
    private IWriter writer;

    public FoolStudent(IPaper paper) {
        super(paper);
    }

    @Required
    public void setWriter(IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeEssay(List<String> paragraphs) {
        StringBuilder builder = new StringBuilder();
        for (String paragraph : paragraphs) {
            builder.append(paragraph);
        }
        final String writtenParagraph = writer.write(builder.toString());
        getPaper().addParagraph(writtenParagraph);
    }

    @Override
    public String toString() {
        return "FoolStudent";
    }
}
