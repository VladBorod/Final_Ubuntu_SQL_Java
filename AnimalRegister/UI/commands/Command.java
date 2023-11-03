package AnimalRegister.UI.commands;
import AnimalRegister.UI.Console;

public abstract class Command implements Option{
    private Console console;
    public Command(Console console){
        this.console = console;
    }
    public Console getConsole(){
        return console;
    }
}
