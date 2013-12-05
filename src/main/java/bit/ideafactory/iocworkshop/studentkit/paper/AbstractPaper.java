package bit.ideafactory.iocworkshop.studentkit.paper;

import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.writers.Pen;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Piotr Turek
 */
public abstract class AbstractPaper implements IPaper {
    private final List<String> paragraphs = new LinkedList<String>();

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (String paragraph : paragraphs) {
            builder.append(paragraph);
        }

        return builder.toString();
    }

    @Override
    public void addParagraph(String writtenParagraph) {
        if (!canAccept(writtenParagraph)) {
            throw new IllegalArgumentException("Cannot accept a paragraph written this way");
        }
        paragraphs.add(writtenParagraph);
    }

    @Override
    public void updateLastParagraph(String fixedParagraph) {
        if (!canAccept(fixedParagraph) || paragraphs.isEmpty()) {
            throw new IllegalArgumentException("Cannot accept this paragraph.");
        }
        paragraphs.set(paragraphs.size() - 1, fixedParagraph);
    }
}
