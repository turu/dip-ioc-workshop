package bit.ideafactory.iocworkshop.studentkit.writers;

import bit.ideafactory.iocworkshop.studentkit.IWriter;

/**
 * @author Michal Partyka
 */
public class Pencil implements IWriter {

    @Override
    public String write(String message) {
        return "^" + message + "^";
    }
}
