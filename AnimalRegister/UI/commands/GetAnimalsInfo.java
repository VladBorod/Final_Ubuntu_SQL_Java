package AnimalRegister.UI.commands;

import AnimalRegister.UI.*;

public class GetAnimalsInfo extends Command {
    public GetAnimalsInfo(Console console){
        super(console);
    }

    @Override
    public String getDescription(){
        return "Output of all animals information.";
    }

    @Override
    public void execute(){
        getConsole().getAnimalsInfo();
    }
}
