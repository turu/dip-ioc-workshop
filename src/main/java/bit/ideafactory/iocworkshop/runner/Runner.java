package bit.ideafactory.iocworkshop.runner;

import bit.ideafactory.iocworkshop.IStudent;
import bit.ideafactory.iocworkshop.MyClass;
import bit.ideafactory.iocworkshop.student.studentkit.IPaper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Author: Piotr Turek
 */
public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private final ClassPathXmlApplicationContext context;

    private MyClass myClass;


    public Runner() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LOG.info("Context is up");
    }

    public static void main(String[] args) {
        final Runner runner = new Runner();
        runner.init();
        runner.run();
    }

    private void init() {
        final IStudent foolStudent = (IStudent) context.getBean("foolStudent");
        final IStudent humanistStudent = (IStudent) context.getBean("humanistStudent");
        final IStudent scientificStudent = (IStudent) context.getBean("scientificStudent");
        final List<IStudent> students = Arrays.asList(
                foolStudent,
                humanistStudent,
                scientificStudent
        );
        myClass = new MyClass(students);
    }

    private void run() {
        List<String> paragraphs = Arrays.asList("Par1", "Par2", "Par3");

        final Map<IStudent,IPaper> results = myClass.writeEssay(paragraphs);

        logResults(results);
    }

    private void logResults(Map<IStudent, IPaper> results) {
        LOG.info("Printing results of essay. {} students participated", results.size());
        for (Map.Entry<IStudent, IPaper> entry : results.entrySet()) {
            final IStudent student = entry.getKey();
            final IPaper paper = entry.getValue();

            LOG.info("Student: {} came up with following paper: {}", student, paper);
        }
    }
}
