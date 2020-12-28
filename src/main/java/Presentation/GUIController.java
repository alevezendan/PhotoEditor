package Presentation;

import Business.IPhotoEditor;
import Business.PhotoEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GUIController {
    private IPhotoEditor photoEditor;

    @FXML
    public ImageView imageView;
    @FXML
    private TabPane TabPanee;

    @FXML
    private TextField ActualWidth;

    @FXML
    private TextField ActualHeight;

    @FXML
    private TextField NewWidth;

    @FXML
    private TextField NewHeight;
    @FXML
    private javafx.scene.control.MenuItem openImageBtn;
    @FXML
    // The reference of inputText will be injected by the FXML loader
    private TextField inputText;

    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextArea outputText;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public void FxFXMLController()
    {
    }

    @FXML
    private void initialize()
    {
        System.out.println("Initialized");
        imageView = new ImageView();
        photoEditor = new PhotoEditor();
    }

    @FXML
    private void printOutput()
    {
        outputText.setText(inputText.getText());
    }

    public void OpenImageBtnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files", "*.png"));
    Image image=null;
        try {
            System.out.println("Showing image " + selectedFile.getName());
            FileInputStream stream = new FileInputStream(selectedFile.getAbsolutePath());
            image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView view=new ImageView(image);
       view.setFitHeight(350);
        view.setFitWidth(240);
        Tab tab1=new Tab();
        tab1.setText("NewImage");
        tab1.setContent(view);

        TabPanee.getTabs().add(tab1);


        photoEditor.loadImage(selectedFile.getAbsolutePath());
    }


    @FXML
    void NewImageBtnAction(ActionEvent event) {

        double red=1;
        double green=1;
        double blue=1;
        double opacity=1;
        int width=400;
        int height=500;
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw = img.getPixelWriter();

        // Should really verify 0.0 <= red, green, blue, opacity <= 1.0
        int alpha = (int) (opacity * 255) ;
        int r = (int) (red * 255) ;
        int g = (int) (green * 255) ;
        int b = (int) (blue * 255) ;

        int pixel = (alpha << 24) | (r << 16) | (g << 8) | b ;
        int[] pixels = new int[width * height];
        Arrays.fill(pixels, pixel);
        pw.setPixels(0, 0, width, height, PixelFormat.getIntArgbInstance(), pixels, 0, width);


        Image marshallUniGreen = (Image)img;
        ImageView imageView = new ImageView(marshallUniGreen);
        imageView.setFitWidth(600);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);
        Tab tab1=new Tab();
        tab1.setText("Blank Image");
        tab1.setContent(imageView);
        TabPanee.getTabs().add(tab1);

    }

   /* @FXML
    void MirrorBtnAction(ActionEvent event) {
       ImageView img=(ImageView)TabPanee.getTabs().get(0).getContent();
       Image i=img.getImage();
       BufferedImage bImage = SwingFXUtils.fromFXImage(i, null);
    }*/
   @FXML
   void CropBtnAction(ActionEvent event) {

   }

    @FXML
    void DuplicateAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Tab t=new Tab();
        //TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);
        t.setText(TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getText()+"Copy");
        t.setContent(img);
        TabPanee.getTabs().add(t);
    }

    @FXML
    void FlipHorizontalBtnAction(ActionEvent event) {

    }

    @FXML
    void FlipVerticalBtnAction(ActionEvent event) {

    }

    @FXML
    void ApplyBtnAction(ActionEvent event) {
        //ImageView img=(ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ImageView img= (ImageView) TabPanee.getTabs().get(0).getContent();
        System.out.println(img.getImage().getWidth());
        System.out.println(NewHeight.getText());
        //  ActualWidth.setText(Double.toString(img.getImage().getWidth()));
        //  ActualHeight.setText(Double.toString(img.getImage().getHeight()));
       Image i=img.getImage();

       /* try{

            img.setFitHeight(Double.parseDouble(NewHeight.getText()));}
        catch(Exception e){
            System.out.println("Set width!");
        }
        try{
            img.setFitWidth(Double.parseDouble(NewWidth.getText()));}
        catch(Exception e){
            System.out.println("Set height!");
        }*/
        //Tab t=new Tab();
        //t.setContent(img);
        TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);

    }

    @FXML
    void ResizeBtnAction(ActionEvent event) {

        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src\\main\\java\\Presentation\\Resize.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Resize Image");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch(Exception e){
            System.out.println("Cannot load new window");
        }
*/

        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "src\\main\\java\\Presentation\\Resize.fxml";
        FileInputStream fxmlStream = null;
        try {
            fxmlStream = new FileInputStream(fxmlDocPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // Create the Pane and all Details
       /* VBox root = null;
        try {
            root = (VBox) loader.load(fxmlStream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Parent root1 = null;
        try {
            root1 = (Parent) loader.load(fxmlStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root1);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.setTitle("Resize Image");
        stage.show();
    }

    @FXML
    void RotateLeftBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        img.setRotate(-90);
        TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);
    }

    @FXML
    void RotateRightBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        img.setRotate(90);
        
        TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(img);

    }

    @FXML
    void ZoomInBtnAction(ActionEvent event) {

    }

    @FXML
    void ZoomOutBtnAction(ActionEvent event) {

    }


}
