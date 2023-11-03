package AnimalRegister.UI.commands;

import AnimalRegister.UI.Console;

public class DogAdd extends Command{
    public DogAdd(Console console){
        super(console);
    }

    @Override
    public String getDescription(){
        return "Add Dog.";
    }

    @Override
    public void execute(){
        getConsole().addDog();
    }
}
