package AnimalRegister.UI.commands;

import AnimalRegister.UI.Console;

public class HamsterAdd extends Command {
    public HamsterAdd(Console console){
        super(console);
    }

    @Override
    public String getDescription(){
        return "Add Hamster.";
    }

    @Override
    public void execute(){
        getConsole().addHamster();
    }
}
