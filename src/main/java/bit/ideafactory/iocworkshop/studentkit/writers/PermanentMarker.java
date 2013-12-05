package bit.ideafactory.iocworkshop.studentkit.writers;

import bit.ideafactory.iocworkshop.studentkit.IWriter;

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
