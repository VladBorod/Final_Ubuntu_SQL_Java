package AnimalRegister.Model;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pet{
    public Dog(String name, String birthday, List<String> commands){
        super(name, birthday, commands);
    }
}
