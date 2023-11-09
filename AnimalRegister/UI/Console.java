package AnimalRegister.UI;

import AnimalRegister.Model.Exceptions.DateFormatException;
import AnimalRegister.Presenter.Presenter;
import AnimalRegister.Model.Examinations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Console implements View{
    private Presenter presenter;
    private final Scanner scanner;
    private boolean work;
    private final Menu menu;
    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    public void finish() {
        System.out.println("The program is complete, thanks for using!");
        work = false;
    }
    public void getAnimalsInfo(){
        presenter.getAnimalsInfo();
    }
    public void addCat(){
        System.out.println("To add cat, enter the cat data in next given order" +
                "using space button.\n" +
                "Name, birth date (format: dd.mm.yyyy), commands.");
        Scanner addCat = new Scanner(System.in);
        String unparsedCatData = addCat.nextLine().toUpperCase(Locale.ROOT);
        String[] check = unparsedCatData.split(" ");
        if (check.length != 2) {
            failSize();
        }
        failDate(check[1]);
        presenter.addCat(unparsedCatData);
    }
    public void addDog(){
        System.out.println("To add dog, enter the cat data in next given order" +
                "using space button.\n" +
                "Name, birth date (format: dd.mm.yyyy), commands.");
        Scanner addDog = new Scanner(System.in);
        String unparsedDogData = addDog.nextLine().toUpperCase(Locale.ROOT);
        String[] check = unparsedDogData.split(" ");
        if (check.length != 2) {
            failSize();
        }
        failDate(check[1]);
        presenter.addDog(unparsedDogData);
    }
    public void addHamster(){
        System.out.println("To add hamster, enter the cat data in next given order" +
                "using space button.\n" +
                "Name, birth date (format: dd.mm.yyyy), commands.");
        Scanner addHamster = new Scanner(System.in);
        String unparsedHamsterData = addHamster.nextLine().toUpperCase(Locale.ROOT);
        String[] check = unparsedHamsterData.split(" ");
        if (check.length < 2) {
            failSize();
        }
        failDate(check[1]);
        presenter.addHamster(unparsedHamsterData);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private boolean check(String text){
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize()
                && Integer.parseInt(text) > 0;
    }

    public void fail() {
        System.out.println("---> Wrong input!");
    }
    public void failSize() {
        System.out.println("---> Not enough data, you may have forgotten to enter birth date!");
    }
    public void failDate(String birthDate){
        String[] dateTest = birthDate.split("\\.");
        if (!(dateTest.length == 3)){
            System.out.println("---> Wrong birth date input");
        }
        String[] days = dateTest[0].split("");
        String[] month = dateTest[1].split("");
        String[] year = dateTest[2].split("");
        int daysValue = Integer.parseInt(dateTest[0]);
        int monthValue = Integer.parseInt(dateTest[0]);
        int yearValue = Integer.parseInt(dateTest[0]);
        if (days.length != 2 && daysValue < 1 || daysValue > 32){
            System.out.println("---> Wrong birth date input, pay attention to days input!");
        }
        if (month.length != 2 && monthValue < 1 || monthValue > 12){
            System.out.println("---> Wrong birth date input, pay attention to month input!");
        }
        if (year.length != 4 && yearValue < 1916 || yearValue > 2024){
            System.out.println("---> Wrong birth date input, pay attention to year input!");
        }
    }
    public void showCommands(){
        System.out.println("Enter the name of the pet, which commands you whant to see");
        Scanner searchedAnimal = new Scanner(System.in);
        String name = searchedAnimal.nextLine().toUpperCase();

        presenter.showCommands(name);
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }
    @Override
    public void start(){
        while (work){
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)){
                menu.execute(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }
}
