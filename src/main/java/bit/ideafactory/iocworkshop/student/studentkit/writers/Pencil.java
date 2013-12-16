package bit.ideafactory.iocworkshop.student.studentkit.writers;

import bit.ideafactory.iocworkshop.student.studentkit.IWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Michal Partyka
 */
@Component
@Scope(value = "singleton")
public class Pencil extends AbstractWriter implements IWriter {
    private static final Character PENCIL_SPECIAL_CHARACTER = '^';

    @Override
    public String write(String message) {
        return super.write(message, PENCIL_SPECIAL_CHARACTER);
    }
}
