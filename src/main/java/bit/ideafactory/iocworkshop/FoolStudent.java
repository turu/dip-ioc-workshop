package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.studentkit.IPaper;
import bit.ideafactory.iocworkshop.studentkit.IWriter;

import java.util.List;

/**
 * Author: Piotr Turek
 */
public class FoolStudent extends AbstractStudent {
    private final IWriter writer;

    protected FoolStudent(IWriter writer, IPaper paper) {
        super(paper);
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
}
