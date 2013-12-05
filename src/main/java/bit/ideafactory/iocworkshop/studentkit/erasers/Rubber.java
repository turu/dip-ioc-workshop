package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.IErasor;

/**
 * @author Michal Partyka
 */
public class Rubber extends AbstractErasor implements IErasor {
    @Override
    public String eraseLast(String message) {

        if ( ! message.endsWith("^") ) {
            throw new IllegalStateException("Pencil cannot erase if message was not written with Pencil");
        }

        return super.eraseLast(message);
    }
}
