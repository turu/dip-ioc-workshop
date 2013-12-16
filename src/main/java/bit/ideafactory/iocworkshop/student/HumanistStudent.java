package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class HumanistStudent extends AbstractStudent {
    private IEraser eraser;
    private IWriter writer;

    public HumanistStudent(IPaper paper) {
        super(paper);
    }

    @Required
    public void setEraser(IEraser eraser) {
        this.eraser = eraser;
    }

    @Required
    public void setWriter(IWriter writer) {
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
