package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michal Partyka
 */
public class Class {
    private List<IStudent> students = new ArrayList<IStudent>();

    public void addStudent(IStudent student) {
        students.add(student);
    }

    public Map<IStudent, IPaper> writeEssay(List<String> paragraphs) {
        Map<IStudent, IPaper> results = new HashMap<IStudent, IPaper>();
        for (IStudent student : students) {
            student.writeEssay(paragraphs);
            results.put(student, student.getPaper());
        }
        return results;
    }

}
