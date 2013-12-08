package bit.ideafactory.iocworkshop.student.studentkit.writers;

import bit.ideafactory.iocworkshop.student.studentkit.IWriter;

/**
 * @author Michal Partyka
 */
public class PermanentMarker extends AbstractWriter implements IWriter {
    private static final Character SPECIAL_MARKER_CHARACTER = '%';

    @Override
    public String write(String message) {
        return super.write(message, SPECIAL_MARKER_CHARACTER);
    }
}
