package bit.ideafactory.iocworkshop.student.studentkit;

/**
 * Author: Piotr Turek
 */
public interface IPaper {
    void addParagraph(String writtenParagraph);

    void updateLastParagraph(String fixedParagraph);

    boolean canAccept(String paragraph);
}
