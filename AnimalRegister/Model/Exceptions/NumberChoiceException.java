package AnimalRegister.Model.Exceptions;

public class NumberChoiceException extends Exception{
    public NumberChoiceException(){
        super("---> Incorrect pet number was selected, \n" +
                "please try agan using specified numbers: \n" +
                "1 - cat,  2 - dog, 3 - hamster!");
    }
}
