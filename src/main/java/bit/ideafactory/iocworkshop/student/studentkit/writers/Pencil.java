package bit.ideafactory.iocworkshop.student.studentkit.writers;

import bit.ideafactory.iocworkshop.student.studentkit.IWriter;

/**
 * @author Michal Partyka
 */
public class Pencil extends AbstractWriter implements IWriter {
    private static final Character PENCIL_SPECIAL_CHARACTER = '^';

    @Override
    public String write(String message) {
        return super.write(message, PENCIL_SPECIAL_CHARACTER);
    }
}
