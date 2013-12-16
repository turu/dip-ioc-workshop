package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Michal Partyka
 */
@Component
@Scope(value = "prototype")
public class HumanistStudent extends AbstractStudent {
    private IEraser eraser;
    private IWriter writer;

    @Autowired
    public HumanistStudent(@Qualifier("lessonPaper") IPaper paper) {
        super(paper);
    }

    @Required
    @Autowired
    public void setEraser(@Qualifier("rubber") IEraser eraser) {
        this.eraser = eraser;
    }

    @Required
    @Autowired
    public void setWriter(@Qualifier("pencil") IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeEssay(List<String> paragraphs) {
        for (String paragraph : paragraphs) {
            writeParagraph(paragraph);
        }
    }

    private String fixParagraph(String paragraph) {
        return eraser.eraseLast(paragraph);
    }

    private void writeParagraph(String paragraph) {
        final String writtenParagraph = writer.write(paragraph);
        final IPaper paper = getPaper();
        doWriteParagraph(writtenParagraph, paper);
    }

    private void doWriteParagraph(String writtenParagraph, IPaper paper) {
        paper.addParagraph(writtenParagraph);
        final String fixedParagraph = fixParagraph(writtenParagraph);
        paper.updateLastParagraph(fixedParagraph);
    }

    @Override
    public String toString() {
        return "HumanistStudent";
    }


}
