package Commands;

import Interfaces.Command;
import Utilities.Submenu;

public class RefreshMenuCommand implements Command {

    Submenu submenu;

    public RefreshMenuCommand(Submenu submenu) {
        this.submenu = submenu;
    }

    @Override
    public void execute() {
        submenu.execute();
    }

    @Override
    public String getName() {
        return null;
    }
}
