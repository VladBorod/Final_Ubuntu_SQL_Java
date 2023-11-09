package AnimalRegister.Model;

import java.util.List;

public class Service {
    public int id;
    public Pet pet;
    public HomeAnimals<Pet> homeAnimals;
    public Service(){
        homeAnimals = new HomeAnimals<>();
    }
    public Service(HomeAnimals<Pet> homeAnimals){
        this.homeAnimals = homeAnimals;
    }
    public String getAnimalsInfo(){
        return homeAnimals.getAnimalsInfo();
    }
    public Cat addCat(String unparsedData){
        return homeAnimals.addCat(unparsedData);
    }
    public Dog addDog(String unparsedData){
        return homeAnimals.addDog(unparsedData);
    }
    public Hamster addHamster(String unparsedData){
        return homeAnimals.addHamster(unparsedData);
    }
    public List<String> showCommands(String name){
        return homeAnimals.showCommands(name);
    }
}
