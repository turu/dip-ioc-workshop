package bit.ideafactory.iocworkshop;

import bit.ideafactory.iocworkshop.student.FoolStudent;
import bit.ideafactory.iocworkshop.student.HumanistStudent;
import bit.ideafactory.iocworkshop.student.ScientificStudent;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import bit.ideafactory.iocworkshop.student.studentkit.erasers.Rubber;
import bit.ideafactory.iocworkshop.student.studentkit.paper.ExamPaper;
import bit.ideafactory.iocworkshop.student.studentkit.paper.LessonPaper;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pen;
import bit.ideafactory.iocworkshop.student.studentkit.writers.Pencil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michal Partyka
 */
public class Class {
    private final List<FoolStudent> foolStudents = new ArrayList<FoolStudent>();
    private final List<HumanistStudent> humanistStudents = new ArrayList<HumanistStudent>();
    private final List<ScientificStudent> scientificStudents = new ArrayList<ScientificStudent>();

    public void addFoolStudent() {
        foolStudents.add(new FoolStudent(new Pen(), new ExamPaper()));
    }

    public void addHumanistStudent() {
        humanistStudents.add(new HumanistStudent(new Rubber(), new Pencil(), new LessonPaper()));
    }

    public void addScientificStudent() {
        scientificStudents.add(new ScientificStudent(new Pen(), new LessonPaper()));
    }

    public Map<IStudent, IPaper> writeEssay(List<String> paragraphs) {
        Map<IStudent, IPaper> results = new HashMap<IStudent, IPaper>();
        for (FoolStudent foolStudent : foolStudents) {
            foolStudent.writeEssay(paragraphs);
            results.put(foolStudent, foolStudent.getPaper());
        }
        for (HumanistStudent humanistStudent : humanistStudents) {
            humanistStudent.writeEssay(paragraphs);
            results.put(humanistStudent, humanistStudent.getPaper());
        }
        for (ScientificStudent scientificStudent : scientificStudents) {
            scientificStudent.writeEssay(paragraphs);
            results.put(scientificStudent, scientificStudent.getPaper());
        }
        return results;
    }

}
