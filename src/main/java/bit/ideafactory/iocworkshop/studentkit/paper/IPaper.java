package bit.ideafactory.iocworkshop.studentkit.paper;

import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.writers.Pen;

/**
 * Author: Piotr Turek
 */
public interface IPaper {
    void addParagraph(String writtenParagraph);

    void updateLastParagraph(String fixedParagraph);

    boolean canAccept(String paragraph);
}
