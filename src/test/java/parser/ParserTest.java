package parser;

import commands.Command;
import commands.ViewAuthorsCommand;
import exceptions.TantouException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void getUserCommand_view_parsedCorrectly() {
        parseInputAssertCommandType("view", ViewAuthorsCommand.class);
    }

    private void parseInputAssertCommandType(String input, Class<? extends Command> expectedClass) {
        try {
            Command actual = parser.getUserCommand(input);
            assertEquals(actual.getClass(), expectedClass);
        } catch (TantouException e) {
            // Should not reach here as the input should be valid for testing
            fail();
        }
    }
}
