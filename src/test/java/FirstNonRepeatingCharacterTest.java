import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

public class FirstNonRepeatingCharacterTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void testFindFirstNonRepeatingCharacterUsingMap() {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("compass")),
                        Optional.of('c'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("express")),
                        Optional.of('x'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("eetate")),
                        Optional.of('a'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("ababcdcde")),
                        Optional.of('e'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("AbabCdcDe")),
                        Optional.of('e'));

        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Invalid Input");
        firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingMap("");
    }

    @Test
    public void testFindFirstNonRepeatingCharacterUsingQueue() {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("compass")),
                        Optional.of('c'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("express")),
                        Optional.of('x'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("eetate")),
                        Optional.of('a'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("ababcdcde")),
                        Optional.of('e'));
        assertEquals
                (java.util.Optional.ofNullable(firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("AbabCdcDe")),
                        Optional.of('e'));

        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Invalid Input");
        firstNonRepeatingCharacter.findFirstNonRepeatingCharacterUsingQueue("");
    }
}
