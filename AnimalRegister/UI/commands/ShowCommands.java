package AnimalRegister.UI.commands;

import AnimalRegister.UI.Console;

public class ShowCommands extends Command{
    public ShowCommands(Console console){
        super(console);
    }
    @Override
    public String getDescription(){
        return "Show animal commands by pet`s name.";
    }

    @Override
    public void execute(){
        getConsole().showCommands();
    }
}
