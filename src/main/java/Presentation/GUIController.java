package Presentation;


import Business.ColorParameters.Brightness;
import Business.ColorParameters.Contrast;
import Business.ColorParameters.Hue;
import Business.ColorParameters.Saturation;
import Business.IPhotoEditor;
import Business.Operations.*;
import Business.PhotoEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.effect.ColorAdjust;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.ResourceBundle;


public class GUIController {
    private IPhotoEditor photoEditor;

    @FXML RESIZEController resContr;
    @FXML BRIGHTController brightContr;
    @FXML SATURATIONController saturContr;
    @FXML CONTRASTController contrContr;
    @FXML HUEController hueContr;
    @FXML
    private ImageView imageView;
    @FXML
   private TabPane TabPanee;

    public TabPane getTabPanee() {
        return TabPanee;
    }



    @FXML
    private void initialize()
    {
        System.out.println("Initialized");
        imageView = new ImageView();
        photoEditor = new PhotoEditor();

    }

public Double getWContr2(){
        return Double.parseDouble(resContr.getW().getText());
}

public Double getHContr2(){
        return  Double.parseDouble(resContr.getH().getText());
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
        tab1.closableProperty();
        tab1.setClosable(true);


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
       ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
      // RubberBandSelection rubberBandSelection;
       Cropp c =new Cropp(img);
       //c.init(img);
       //c.apply(img);
      // ImageView i=c.crop(c.getRubberBandSelection().getBounds(),img);
      // TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).setContent(i);
   }

    @FXML
    void DuplicateAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ImageView img1=img;
        Tab t=new Tab();
        t.setText(TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getText()+"Copy");
        t.setContent(img);
        TabPanee.getTabs().add(t);
        Tab current=TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex());
        current.setContent(img1);
    }

    @FXML
    void FlipHorizontalBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        FlipHorizontal flipH=new FlipHorizontal();
        flipH.apply(img);

    }

    @FXML
    void FlipVerticalBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        //img.scaleXProperty().set(-1.0);
        FlipVertical flip=new FlipVertical();
        flip.apply(img);
    }

    @FXML
    void ResizeBtnAction(ActionEvent event) {
        try{
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Resize.fxml"));
            FXMLLoader loader=new FXMLLoader();
        // Path to the FXML File
            String fxmlDocPath = "src\\main\\java\\Presentation\\Resize.fxml";
             FileInputStream fxmlStream = null;
             fxmlStream = new FileInputStream(fxmlDocPath);
             Parent parent=loader.load(fxmlStream);
             resContr= loader.getController();
             Stage stage =new Stage();
             stage.setTitle("Resize Image");
            stage.setScene(new Scene(parent));
            stage.show();
            resContr.init(this);

        } catch(IOException e){
                 System.out.println("eferg");
        }
    }

    public void inflate(RESIZEController contr){
       double W=getWContr2();
       double H=getHContr2();
       int i=TabPanee.getSelectionModel().getSelectedIndex();
       ImageView img= (ImageView) TabPanee.getTabs().get(i).getContent();
       Resize res=new Resize();
       res.apply(img);
       img.setFitWidth(W);
       img.setFitHeight(H);
       //TabPanee.getTabs().get(i).setContent(img);


    }

    public void inflateB(BRIGHTController contr){
      double val=contr.getBrightSlider().getValue();
       ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Brightness b=new Brightness();
        b.apply(img,val);

    }

    public void inflateS(SATURATIONController contr){
        double val=contr.getSlider().getValue();
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Saturation s=new Saturation();
        s.apply(img,val);

    }

    public void inflateC(CONTRASTController contr){
        double val=contr.getSlider().getValue();
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Contrast c=new Contrast();
        c.apply(img,val);

    }
    public void inflateH(HUEController contr){
        double val=contr.getSlider().getValue();
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Hue h=new Hue();
        h.apply(img,val);

    }


    @FXML
    void RotateLeftBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        RotateCounterclockwise rotL=new RotateCounterclockwise();
        rotL.apply(img);
    }


   @FXML
    void RotateRightBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
       RotateClockwise rotR=new RotateClockwise();
       rotR.apply(img);
    }

    @FXML
    void ZoomInBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ZoomIn zoomIn=new ZoomIn();
        zoomIn.apply(img);


    }

    @FXML
    void ZoomOutBtnAction(ActionEvent event) {
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ZoomOut zoomOut=new ZoomOut();
        zoomOut.apply(img);
    }


    @FXML
    void BrightnessOnAction(ActionEvent event) {
        try{
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Resize.fxml"));
            FXMLLoader loader=new FXMLLoader();
            // Path to the FXML File
            String fxmlDocPath = "src\\main\\java\\Presentation\\Brightness.fxml";
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(fxmlDocPath);
            Parent parent=loader.load(fxmlStream);
            brightContr=loader.getController();
            Stage stage =new Stage();
            stage.setTitle("Brightness");
            stage.setScene(new Scene(parent));
            stage.show();
           brightContr.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }

    }


    @FXML
    void SaturationOnAction(ActionEvent event) {
        try{
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Resize.fxml"));
            FXMLLoader loader=new FXMLLoader();
            // Path to the FXML File
            String fxmlDocPath = "src\\main\\java\\Presentation\\Saturation.fxml";
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(fxmlDocPath);
            Parent parent=loader.load(fxmlStream);
            saturContr=loader.getController();
            Stage stage =new Stage();
            stage.setTitle("Saturation");
            stage.setScene(new Scene(parent));
            stage.show();
            saturContr.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }
    }

    @FXML
    void ContrastOnAction(ActionEvent event) {
        try{
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Resize.fxml"));
            FXMLLoader loader=new FXMLLoader();
            // Path to the FXML File
            String fxmlDocPath = "src\\main\\java\\Presentation\\Contrast.fxml";
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(fxmlDocPath);
            Parent parent=loader.load(fxmlStream);
            contrContr=loader.getController();
            Stage stage =new Stage();
            stage.setTitle("Saturation");
            stage.setScene(new Scene(parent));
            stage.show();
            contrContr.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }
    }

    @FXML
    void HueOnAction(ActionEvent event) {
        try{
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("Resize.fxml"));
            FXMLLoader loader=new FXMLLoader();
            // Path to the FXML File
            String fxmlDocPath = "src\\main\\java\\Presentation\\Hue.fxml";
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(fxmlDocPath);
            Parent parent=loader.load(fxmlStream);
            hueContr=loader.getController();
            Stage stage =new Stage();
            stage.setTitle("Saturation");
            stage.setScene(new Scene(parent));
            stage.show();
            hueContr.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }
    }


}
