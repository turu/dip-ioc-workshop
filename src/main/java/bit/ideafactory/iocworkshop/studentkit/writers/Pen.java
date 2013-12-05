package bit.ideafactory.iocworkshop.studentkit.writers;

import bit.ideafactory.iocworkshop.studentkit.IWriter;

/**
 * @author Michal Partyka
 */
public class Pen extends AbstractWriter implements IWriter {
    public static final char PEN_SPECIAL_CHARACTER = '*';

    @Override
    public String write(String message) {
        return super.write(message, PEN_SPECIAL_CHARACTER);
    }
}
