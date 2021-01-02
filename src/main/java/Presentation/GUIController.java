package Presentation;


import Business.ColorParameters.Brightness;
import Business.ColorParameters.Contrast;
import Business.ColorParameters.Hue;
import Business.ColorParameters.Saturation;
import Business.Effects.BBlur;

import Business.Effects.GBlur;
import Business.Effects.MBlur;
import Business.IPhotoEditor;
import Business.Operations.*;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class GUIController {
    private IPhotoEditor photoEditor;

    @FXML
    RESIZEController resContr;
    @FXML
    BRIGHTController brightContr;
    @FXML
    SATURATIONController saturContr;
    @FXML
    CONTRASTController contrContr;
    @FXML
    HUEController hueContr;
    @FXML
    BOXBLURController boxContr;
    @FXML
    GAUSSIANBController gaussContr;
    @FXML
    MOTIONBController motionContr;
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
        initNewController(resContr,"src\\main\\java\\Presentation\\FXMLfiles\\Resize.fxml","Resize");
    }

    public void inflate(RESIZEController contr){
       int i=TabPanee.getSelectionModel().getSelectedIndex();
       ImageView img= (ImageView) TabPanee.getTabs().get(i).getContent();
       Resize res=new Resize();
       res.apply(img);
       img.setFitWidth(Double.parseDouble(contr.getW().getText()));
       img.setFitHeight(Double.parseDouble(contr.getH().getText()));
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

    public void initNewController(Controller c,String path,String title){
        try{
            FXMLLoader loader=new FXMLLoader();
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(path);
            Parent parent=loader.load(fxmlStream);
            c=loader.getController();
            Stage stage =new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            c.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }
    }

    @FXML
    void BrightnessOnAction(ActionEvent event) {
        initNewController(brightContr,"src\\main\\java\\Presentation\\FXMLfiles\\Brightness.fxml","Brightness");

    }


    @FXML
    void SaturationOnAction(ActionEvent event) {
        initNewController(saturContr,"src\\main\\java\\Presentation\\FXMLfiles\\Saturation.fxml","Sturation");
    }

    @FXML
    void ContrastOnAction(ActionEvent event) {
        initNewController(contrContr,"src\\main\\java\\Presentation\\FXMLfiles\\Contrast.fxml","Contrast");
    }

    @FXML
    void HueOnAction(ActionEvent event) {
        initNewController(hueContr,"src\\main\\java\\Presentation\\FXMLfiles\\Hue.fxml","Hue");
    }


    @FXML
    void BoxBlurOnAction(ActionEvent event) {
        initNewController(boxContr,"src\\main\\java\\Presentation\\FXMLfiles\\BoxBlur.fxml","BoxBlur");
    }

    public void boxBlur(BOXBLURController contr){
        double val=  contr.getSlider().getValue();
        System.out.println(val);
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        BBlur b= new BBlur();
        b.apply(img,val);

    }
    public void gaussBlur(GAUSSIANBController contr){
        double val=  contr.getSlider().getValue();
        System.out.println(val);
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        GBlur g=new GBlur();
        g.apply(img,val);

    }
    public void motionBlur(MOTIONBController contr){
        double radius=  contr.getRadiusSlider().getValue();
        double angle=contr.getAngleSlider().getValue();
        //System.out.println(val);
        ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        MBlur m=new MBlur();
        m.apply(img,radius,angle);

    }

    @FXML
    void GaussianBlurOnAction(ActionEvent event) {
        initNewController(gaussContr, "src\\main\\java\\Presentation\\FXMLfiles\\GaussianBlur.fxml","GaussianBlur");
    }

    @FXML
    void MotionBlurOnAction(ActionEvent event) {
        initNewController(motionContr, "src\\main\\java\\Presentation\\FXMLfiles\\MotionBlur.fxml", "MotionBlur");
    }

}
