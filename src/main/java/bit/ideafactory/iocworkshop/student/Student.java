package bit.ideafactory.iocworkshop.student;

import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.IWriter;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class Student {
    private final IEraser eraser;
    private final IWriter writer;
    private final IPaper paper;

    public Student(IEraser eraser, IWriter writer, IPaper paper) {
        this.eraser = eraser;
        this.writer = writer;
        this.paper = paper;
    }

    public void writeEssay(List<String> paragraphs) {
        for (String paragraph : paragraphs) {
            writeParagraph(paragraph);
        }
    }

    public IPaper getPaper() {
        return paper;
    }

    private String fixParagraph(String paragraph) {
        return eraser.eraseLast(paragraph);
    }

    private void writeParagraph(String paragraph) {
        final String writtenParagraph = writer.write(paragraph);
        paper.addParagraph(writtenParagraph);
        final String fixedParagraph = fixParagraph(writtenParagraph);
        paper.updateLastParagraph(fixedParagraph);
    }

}
