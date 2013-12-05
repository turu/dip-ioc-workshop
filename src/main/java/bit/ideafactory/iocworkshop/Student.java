package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.studentkit.paper.AbstractPaper;
import bit.ideafactory.iocworkshop.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.studentkit.writers.Pen;

import java.util.List;

/**
 * @author Michal Partyka
 */
public class Student {
    private final Rubber rubber;
    private final Pen pen;
    private final LessonPaper paper;

    public Student() {
        paper = new LessonPaper();
        rubber = new Rubber();
        pen = new Pen();
    }

    public void writeEssay(List<String> paragraphs) {
        for (String paragraph : paragraphs) {
            writeParagraph(paragraph);
        }
    }

    private String fixParagraph(String paragraph) {
        return rubber.eraseLast(paragraph);
    }

    private void writeParagraph(String paragraph) {
        final String writtenParagraph = pen.write(paragraph);
        paper.addParagraph(writtenParagraph);
        final String fixedParagraph = fixParagraph(paragraph);
        paper.updateLastParagraph(fixedParagraph);
    }


}
