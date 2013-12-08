package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;

import java.util.List;

/**
 * Author: Piotr Turek
 */
public interface IStudent {
    void writeEssay(List<String> paragraphs);

    IPaper getPaper();
}
