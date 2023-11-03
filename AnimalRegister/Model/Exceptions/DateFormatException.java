package AnimalRegister.Model.Exceptions;

public class DateFormatException extends NumberFormatException{
    public DateFormatException(){
        super(" ---> Date format is incorrect, try format dd.mm.yyyy!");
    }
}
