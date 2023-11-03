package AnimalRegister;

import AnimalRegister.Model.*;
import AnimalRegister.Presenter.Presenter;
import AnimalRegister.UI.Console;
import AnimalRegister.UI.View;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        HomeAnimals<Pet> homeAnimals = new HomeAnimals<>();

        Cat cat1 = new Cat("Lola", "11.12.2020", Collections.singletonList("sit, run, stay"));
        Dog dog1 = new Dog("Sharik", "12.11.2020", Collections.singletonList("paw, bark, sit, stand"));
        Hamster hamster1 = new Hamster("Kykysha", "02.02.2023", Collections.singletonList(""));
        Hamster hamster2 = new Hamster("Геннадий Петрович", "31.12.2022", Collections.singletonList(""));

        homeAnimals.addPet(cat1);
        homeAnimals.addPet(dog1);
        homeAnimals.addPet(hamster1);
        homeAnimals.addPet(hamster2);

        Service service = new Service(homeAnimals);

        View view = new Console();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}

//Myrka 02.02.2020 roll jump sing fly
//Barka 01.01.2004 paw bark jump attack stop hide
//Чопик 31.12.2022 уничтожение
