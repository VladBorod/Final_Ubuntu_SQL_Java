package AnimalRegister.UI.commands;

import AnimalRegister.UI.Console;

public class CatAdd extends Command{
    public CatAdd(Console console){
        super(console);
    }

    @Override
    public String getDescription(){
        return "Add Cat.";
    }

    @Override
    public void execute(){
        getConsole().addCat();
    }
}
