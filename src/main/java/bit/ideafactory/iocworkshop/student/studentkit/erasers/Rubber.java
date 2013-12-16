package bit.ideafactory.iocworkshop.student.studentkit.erasers;

import bit.ideafactory.iocworkshop.student.studentkit.IEraser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Michal Partyka
 */
@Component
@Scope(value = "singleton")
public class Rubber extends AbstractEraser implements IEraser {
    @Override
    public String eraseLast(String message) {

        if ( message.endsWith("^") ) {
            return super.eraseLast(message);
        }

        throw new IllegalStateException("Rubber can only erase text written with Pencil");
    }
}
