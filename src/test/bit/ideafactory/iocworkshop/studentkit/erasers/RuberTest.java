package bit.ideafactory.iocworkshop.studentkit.erasers;

import bit.ideafactory.iocworkshop.studentkit.erasers.Rubber;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author Michal Partyka
 */
public class RuberTest {
    private Rubber ruber;

    @org.junit.Before
    public void setUp() throws Exception {
        ruber = new Rubber();
    }

    @Test
    public void eraseLast_shouldEraseLastAndSkipSpecialSign( ) {
        //given

        //when
        final String erased = ruber.eraseLast("^Ala has a cat^");

        //then
        assertThat(erased).isEqualTo("^Ala has a ca^");
    }
}
