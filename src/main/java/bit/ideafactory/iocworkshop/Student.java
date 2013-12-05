package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IEraser;
import bit.ideafactory.iocworkshop.studentkit.IPaper;
import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.studentkit.writers.Pencil;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class Student {
    protected IEraser eraser;
    protected IWriter writer;
    protected IPaper paper;

    public Student() {
        paper = new LessonPaper();
        eraser = new Rubber();
        writer = new Pencil();
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
