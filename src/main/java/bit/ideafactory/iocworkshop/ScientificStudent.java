package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IPaper;
import bit.ideafactory.iocworkshop.studentkit.IWriter;

import java.util.List;

/**
 * Author: Piotr Turek
 */
public class ScientificStudent extends AbstractStudent {
    private final IWriter writer;

    public ScientificStudent(IWriter writer, IPaper paper) {
        super(paper);
        this.writer = writer;
    }

    @Override
    public void writeEssay(List<String> paragraphs) {
        for (String paragraph : paragraphs) {
            final String writtenParagraph = writer.write(paragraph);
            final IPaper paper = getPaper();
            paper.addParagraph(writtenParagraph);
        }
    }
}
