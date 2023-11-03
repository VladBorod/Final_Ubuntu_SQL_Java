package AnimalRegister.Model.Exceptions;

public class IncorrectNameFormatException extends RuntimeException{
    public IncorrectNameFormatException(){
        super(" ---> Incorrect symbols in name, surname or patronymic, checkout and try agan!");
    }
}
