package bit.ideafactory.iocworkshop.student.studentkit.writers;

import bit.ideafactory.iocworkshop.student.studentkit.IWriter;

/**
 * @author Michal Partyka
 */
public abstract class AbstractWriter implements IWriter {
    public String write(String message, Character specialCharachter) {
        return specialCharachter + message + specialCharachter;
    }
}
