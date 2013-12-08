package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.studentkit.IEraser;
import bit.ideafactory.iocworkshop.studentkit.IPaper;
import bit.ideafactory.iocworkshop.studentkit.IWriter;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class HumanistStudent extends AbstractStudent {
    private final IEraser eraser;
    private final IWriter writer;

    public HumanistStudent(IEraser eraser, IWriter writer, IPaper paper) {
        super(paper);
        this.eraser = eraser;
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

}
