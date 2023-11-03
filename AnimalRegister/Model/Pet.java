package AnimalRegister.Model;

import java.util.List;

public abstract class Pet {
    static int generatorId = 1;
    private int id;
    private String name;
    private String birthday;
    private List<String> commands;

    public Pet(String name, String birthday, List<String> commands){
        this.id = generatorId++;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    protected Pet() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdayDate(){
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getKind(){
        String res;
        if (getClass() == Cat.class){
            res ="Cat";
        } else if (getClass() == Dog.class) {
            res ="Dog";
        } else {
            res ="Hamster";
        }
        return res;
    }

    public String getInfo(){
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("Pet id: ");
        infoBuilder.append(getId());
        infoBuilder.append(", ");
        infoBuilder.append("pet kind: ");
        infoBuilder.append(getKind());
        infoBuilder.append(", ");
        infoBuilder.append("pet name: ");
        infoBuilder.append(getName());
        infoBuilder.append(", ");
        infoBuilder.append("pet birthday: ");
        infoBuilder.append(getBirthdayDate());
        infoBuilder.append(", ");
        infoBuilder.append("pet commands: ");
        infoBuilder.append(getCommands());
        infoBuilder.append(".");
        return infoBuilder.toString();
    }

    @Override
    public String toString(){
        return "Pet id: " + getId() +
                "\npet kind: " + getKind() +
                "\npet name: " + getName() +
                "\nbirthday: " + getBirthdayDate() +
                "\ncommands: " + getCommands();
    }
}
