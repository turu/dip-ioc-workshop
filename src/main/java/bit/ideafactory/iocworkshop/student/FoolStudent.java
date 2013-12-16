package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: Piotr Turek
 */
@Component
@Scope(value = "prototype")
public class FoolStudent extends AbstractStudent {
    private IWriter writer;

    @Autowired
    public FoolStudent(@Qualifier("paperForExam") IPaper paper) {
        super(paper);
    }

    @Required
    @Autowired
    public void setWriter(@Qualifier("pen") IWriter writer) {
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
