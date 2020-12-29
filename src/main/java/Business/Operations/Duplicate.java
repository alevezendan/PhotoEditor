package Business.Operations;

import Business.Operation;
import Presentation.GUIController;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;

public class Duplicate implements Operation {
    @Override
    public void apply(ImageView source) {
       /* Tab t=new Tab();

        //TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);
        t.setText(GUIController.getTabPanee().getTabs().get(GUIController.getTabPanee().getSelectionModel().getSelectedIndex()).getText()+"Copy");
        t.setContent(source);
        GUIController.getTabPanee().getTabs().add(t);
        //TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);

        */
    }
}
