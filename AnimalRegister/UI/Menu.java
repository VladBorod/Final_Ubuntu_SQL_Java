package AnimalRegister.UI;

import AnimalRegister.UI.commands.*;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    public List<Option> list;

    public Menu(Console console){
        list = new ArrayList<>();
        list.add(new GetAnimalsInfo(console));
        list.add(new CatAdd(console));
        list.add(new DogAdd(console));
        list.add(new HamsterAdd(console));
        list.add(new Finish(console));
    }

    public String print(){
        System.out.println("==================================\n" +
                " To navigate through the menu, \n" +
                " use the console input of numbers.\n" +
                "==================================\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){ list.get(choice - 1).execute();}
    public int getSize(){return list.size();}
}
