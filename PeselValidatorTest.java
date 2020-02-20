import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pracownicy.PeselValidator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(value= Parameterized.class)
public class PeselValidatorTest {



        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "1000000", false }, { "22222222222", true }, { "90061801713", true }, { "61051974997", true }, { "81092375591", true }, { "87010566827", true }, { "71082411749", true }
            });
        }

        private String fInput;

        private boolean fExpected;

    public PeselValidatorTest(String input, boolean expected) {
            this.fInput = input;
            this.fExpected = expected;
        }

        @Test
        public void test() {
            PeselValidator testing = new PeselValidator(fInput);
            assertEquals(fExpected, testing.isValid());
        }
    }

