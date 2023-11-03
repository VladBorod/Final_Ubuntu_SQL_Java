package AnimalRegister.Model;


import java.util.ArrayList;
import java.util.List;

public class HomeAnimals<P> {
    public List<Pet> homeAnimals;
    public HomeAnimals(List<Pet> homeAnimals){
        this.homeAnimals = homeAnimals;
    }
    public HomeAnimals(){
        this(new ArrayList<>());
    }
    public void addPet(Pet pet){
        homeAnimals.add(pet);
    }
    public void addPet(Cat pet){
        homeAnimals.add(pet);
    }
    public String getAnimalsInfo(){
        StringBuilder animals = new StringBuilder();
        for (Pet pet:homeAnimals) {
            animals.append(pet.getInfo());
            animals.append("\n");
        }
        return animals.toString();
    }

    public Cat addCat(String unparsedData){
        String[] dataArray = unparsedData.split(" ");
        int arraySize = dataArray.length;
        Examinations.nameExamination(dataArray[0].toUpperCase());
//        Examinations.birthDateExamination(dataArray[1]);

        List<String> commands = new ArrayList<>();
        for (int i = 2; i < arraySize; i++) {
            commands.add(dataArray[i]);
        }
        Cat newCat = new Cat(dataArray[0], dataArray[1], commands);
        homeAnimals.add(newCat);
        return newCat;
    }
    public Dog addDog(String unparsedData){
        String[] dataArray = unparsedData.split(" ");
        int arraySize = dataArray.length;
        Examinations.nameExamination(dataArray[0].toUpperCase());
//        Examinations.birthDateExamination(dataArray[1]);

        List<String> commands = new ArrayList<>();
        for (int i = 2; i < arraySize; i++) {
            commands.add(dataArray[i]);
        }
        Dog newDog = new Dog(dataArray[0], dataArray[1], commands);
        homeAnimals.add(newDog);
        return newDog;
    }
    public Hamster addHamster(String unparsedData){
        String[] dataArray = unparsedData.split(" ");
        int arraySize = dataArray.length;
        Examinations.nameExamination(dataArray[0].toUpperCase());
//        Examinations.birthDateExamination(dataArray[1]);

        List<String> commands = new ArrayList<>();
        for (int i = 2; i < arraySize; i++) {
            commands.add(dataArray[i]);
        }
        Hamster newHamster = new Hamster(dataArray[0], dataArray[1], commands);
        homeAnimals.add(newHamster);
        return newHamster;
    }

}
