package AnimalRegister.UI;

import AnimalRegister.Presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
}
