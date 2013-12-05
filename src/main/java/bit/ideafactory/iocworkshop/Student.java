package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.studentkit.writers.Pencil;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class Student {
    private final Rubber rubber;
    private final Pencil pencil;
    private final LessonPaper paper;

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

    public LessonPaper getPaper() {
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
