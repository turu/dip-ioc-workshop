package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.IWriter;
import bit.ideafactory.iocworkshop.studentkit.writers.AbstractWriter;

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
