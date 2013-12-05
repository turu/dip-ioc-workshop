package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.IEraser;

/**
 * @author Michal Partyka
 */
public class Corrector extends AbstractEraser implements IEraser {
    @Override
    public String eraseLast(String message) {
        if (message.endsWith("%")) {
            throw new IllegalStateException("PermanentMarker cannot be erased by Corrector");
        }

        return super.eraseLast(message);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
