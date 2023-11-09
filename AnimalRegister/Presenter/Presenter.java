package AnimalRegister.Presenter;

import AnimalRegister.Model.Service;
import AnimalRegister.UI.View;


public class Presenter {
    public View view;
    public Service service;

    public Presenter(View view, Service service){
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }
    public void getAnimalsInfo(){
        String answer = service.getAnimalsInfo();
        view.print(answer);
    }
    public void addCat(String unparsedData){
        view.print(String.valueOf(service.addCat(unparsedData)));
    }
    public void addDog(String unparsedData){
        view.print(String.valueOf(service.addDog(unparsedData)));
    }
    public void addHamster(String unparsedData){
        view.print(String.valueOf(service.addHamster(unparsedData)));
    }
    public void showCommands(String name){
        view.print(service.showCommands(name).toString().replaceAll("[ \\[ \\] ]", ""));
    }
}
