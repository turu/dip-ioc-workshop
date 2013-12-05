package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.IEraser;

/**
 * @author Michal Partyka
 */
public class Rubber extends AbstractEraser implements IEraser {
    @Override
    public String eraseLast(String message) {

        if ( message.endsWith("^") ) {
            return super.eraseLast(message);
        }

        throw new IllegalStateException("Rubber can only erase text written with Pencil");
    }
}
