package AnimalRegister.Model;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pet{
    public Cat(String name, String birthday, List<String> commands){
        super(name, birthday, commands);
    }
}
