package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IErasor;
import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.studentkit.paper.IPaper;
import bit.ideafactory.iocworkshop.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.studentkit.writers.Pencil;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class Student {
    protected final IErasor rubber;
    protected final IWriter pencil;
    protected final IPaper paper;

    public Student() {
        paper = new LessonPaper();
        rubber = new Rubber();
        pencil = new Pencil();
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
        return rubber.eraseLast(paragraph);
    }

    private void writeParagraph(String paragraph) {
        final String writtenParagraph = pencil.write(paragraph);
        paper.addParagraph(writtenParagraph);
        final String fixedParagraph = fixParagraph(writtenParagraph);
        paper.updateLastParagraph(fixedParagraph);
    }


}
