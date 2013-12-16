package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michal Partyka
 */
@Component
@Scope(value = "singleton")
public class MyClass {
    private final List<IStudent> students = new ArrayList<IStudent>();

    @Autowired
    public MyClass(List<IStudent> students) {
        this.students.addAll(students);
    }

    public MyClass() {
    }

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
