package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.IEraser;

/**
 * @author Michal Partyka
 */
public abstract class AbstractEraser implements IEraser {
    @Override
    public String eraseLast(String message) {
        return message.substring(0,message.length()-2) + message.charAt(message.length()-1);
    }
}
