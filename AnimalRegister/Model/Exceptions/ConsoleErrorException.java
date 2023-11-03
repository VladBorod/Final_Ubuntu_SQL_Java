package AnimalRegister.Model.Exceptions;

public class ConsoleErrorException extends Exception{
    public ConsoleErrorException(){

        super("---> Something goes wrong with console input,\n" +
                "please try agan!");
    }
}
