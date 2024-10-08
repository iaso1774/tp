package commands;

import author.AuthorList;
import ui.Ui;

import static constants.Command.BYE_COMMAND;

public class ByeCommand extends Command {
    public ByeCommand() {
        super(BYE_COMMAND);
    }

    @Override
    public void execute(Ui ui, AuthorList authorList) {
        ui.sayGoodbye();
        setExit(true);
    }
}
