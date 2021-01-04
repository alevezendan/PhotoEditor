package Presentation;


import Business.ColorParameters.Brightness;
import Business.ColorParameters.Contrast;
import Business.ColorParameters.Hue;
import Business.ColorParameters.Saturation;
import Business.Effects.*;

import Business.IPhotoEditor;
import Business.Operations.*;
import Business.PhotoEditor;
import Business.Shapes.Circle;
import Business.Shapes.Line;
import Business.Shapes.Rectangle;
import Business.Shapes.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


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
    @FXML REFLController reflContr;
    @FXML BLOOMController bloomContr;
    @FXML GLOWController glowContr;
    @FXML SEPIAController sepiaContr;
    @FXML SHADOWController shadowContr;
    @FXML
    private ColorPicker cpFillColor;
    @FXML
    private ImageView imageView;
    @FXML
   private TabPane TabPanee;
    @FXML
    private CheckBox filled;
    @FXML
    private TextField tfTextString;

    @FXML
    private TextField tfFontSize;

    @FXML
    private ColorPicker cpTextColor;

    @FXML
    private ComboBox<String> cbbFontStyle;
    public double posX1,posY1,posX2,posY2;
    public int cnt=1;
    @FXML
    private Slider sldBorderSize;
    @FXML
    private ColorPicker cpBorderColor;
    @FXML
    private ColorPicker bgColor;
    @FXML
    private CheckBox bg;
    @FXML
    private ComboBox<String> comboShapes;
   // private ObservableList<String> fonts= (ObservableList<String>) javafx.scene.text.Font.getFamilies();
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Rectangle","Circle","Line");
    public TabPane getTabPanee() {
        return TabPanee;
    }

    @FXML
    private void initialize()
    {
        System.out.println("Initialized");
        imageView = new ImageView();
        photoEditor = new PhotoEditor();
        comboShapes.setItems(dbTypeList);
      //  cbbFontStyle.setItems(fonts);
        cbbFontStyle.getItems().addAll(Font.getFontNames());
        cbbFontStyle.setValue("Roboto");

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
        Canvas c=new Canvas(300,300);
        javafx.scene.shape.Rectangle r=new javafx.scene.shape.Rectangle(posX1,posY1,c.getWidth(),c.getHeight());
        r.setFill(new ImagePattern(image));

        //Rectangle r=new Rectangle();
       // r.draw(c,new ImagePattern(image),cpBorderColor.getValue(),sldBorderSize.getValue(),filled.isSelected(),0,30,c.getWidth(),c.getHeight());
       //WritableImage img= c.snapshot(new SnapshotParameters(),new WritableImage(300,300));
        //Image i=getCanvas().snapshot(null,null);
       // ImageView img=new ImageView();
       // img.setImage(i);

        //tab1.setContent(view);
        GraphicsContext gc = c.getGraphicsContext2D();

        gc.drawImage(view.getImage(), 0, 0, c.getWidth(), c.getHeight());
        tab1.setContent(c);

       // tab1.setContent(view);
        tab1.closableProperty();
        tab1.setClosable(true);
        TabPanee.getTabs().add(tab1);
        photoEditor.loadImage(selectedFile.getAbsolutePath());
    }

    @FXML
    void clicked(MouseEvent event) {
        MouseEvent event2;
        if (cnt % 2 == 1) {
            posX1 = event.getX();
            posY1 = event.getY()-30;
            System.out.println(posX1+" "+posY1);
        } else{
            posX2 = event.getX();
            posY2 = event.getY()-30;
            System.out.println(posX2+" "+posY2);
         }
       // System.out.println(posX+" "+posY);
        if(accordion.getExpandedPane().getText().equals("Drawing Tools")) {
            if (comboShapes.getValue().equals("Rectangle") && cnt % 2 == 0) {
                Rectangle r = new Rectangle();
                r.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);
            } else {
                if (comboShapes.getValue().equals("Circle") && cnt % 2 == 0) {
                    Circle c = new Circle();
                    c.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);
                } else {
                    if (comboShapes.getValue().equals("Line") && cnt % 2 == 0) {
                        Line l = new Line();
                        l.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);
                    }
                }
            }
        }else
        {
            if(accordion.getExpandedPane().getText().equals("Text Tools")){
                Text t=new Text();
                t.setText(getCanvas(),tfTextString.getText(),cbbFontStyle.getValue(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),posX1,posY1);
            }
        }
        cnt++;
    }

    @FXML
    void NewImageBtnAction(ActionEvent event) {

       /* double red=1;
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
        TabPanee.getTabs().add(tab1);*/

        Canvas canvas = new Canvas();

        // set height and width
        canvas.setHeight(400);
        canvas.setWidth(400);

        // graphics context
        GraphicsContext graphics_context =
                canvas.getGraphicsContext2D();

        // set fill for rectangle
       /* graphics_context.setFill(Color.PINK);
        graphics_context.fillRect(40, 40, 100, 100);

        // set fill for rectangle
        graphics_context.setFill(Color.RED);
        graphics_context.fillRect(20, 20, 70, 70);

        // set fill for oval
        graphics_context.setFill(Color.BLUE);
        graphics_context.fillOval(30, 30, 70, 70);*/

        Tab tab=new Tab();
        tab.setContent(canvas);
        tab.setText("BlankTab");
        TabPanee.getTabs().add(tab);

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
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
       // ImageView img1=img;
        Node n=TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Tab t=new Tab();
        t.setText(TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getText()+"Copy");
        t.setContent(n);
        TabPanee.getTabs().add(t);
       // Tab current=TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex());
       // current.setContent(n);
    }

    @FXML
    void FlipHorizontalBtnAction(ActionEvent event) {
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        FlipHorizontal flipH=new FlipHorizontal();
        flipH.apply(getImage());

    }

    @FXML
    void FlipVerticalBtnAction(ActionEvent event) {
        ///ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        //img.scaleXProperty().set(-1.0);
        FlipVertical flip=new FlipVertical();
        flip.apply(getImage());
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
       //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
       Brightness b=new Brightness();
       b.apply(getImage(),val);

    }

    public void inflateS(SATURATIONController contr){
        double val=contr.getSlider().getValue();
        //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Saturation s=new Saturation();
        s.apply(getImage(),val);
    }

    public void inflateC(CONTRASTController contr){
        double val=contr.getSlider().getValue();
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Contrast c=new Contrast();
        c.apply(getImage(),val);

    }
    public void inflateH(HUEController contr){
        double val=contr.getSlider().getValue();
        //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Hue h=new Hue();
        h.apply(getImage(),val);
    }


    @FXML
    void RotateLeftBtnAction(ActionEvent event) {
        //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        RotateCounterclockwise rotL=new RotateCounterclockwise();
        rotL.apply(getImage());
    }


   @FXML
    void RotateRightBtnAction(ActionEvent event) {
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
       RotateClockwise rotR=new RotateClockwise();
       rotR.apply(getImage());
    }

    @FXML
    void ZoomInBtnAction(ActionEvent event) {
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ZoomIn zoomIn=new ZoomIn();
        zoomIn.apply(getImage());
    }

    @FXML
    void ZoomOutBtnAction(ActionEvent event) {
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        ZoomOut zoomOut=new ZoomOut();
        zoomOut.apply(getImage());
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
       // ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        BBlur b= new BBlur();
        b.apply(getImage(),val);

    }
    public void gaussBlur(GAUSSIANBController contr){
        double val=  contr.getSlider().getValue();
        System.out.println(val);
        //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        GBlur g=new GBlur();
        g.apply(getImage(),val);
    }

    public void refl(REFLController contr){
        double val1=  contr.getBottOpSlider().getValue();
        double val2=contr.getTopOpSlider().getValue();
        double val3=contr.getTopOffSlider().getValue();
        double val4=contr.getFrSlider().getValue();
      //  ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        Reflectionn r=new Reflectionn();
        r.apply(getImage(),val1,val2,val3,val4);
    }

    public ImageView getImage(){
       // return (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        SnapshotParameters param=new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);
        ImageView img=new ImageView();
        img.setImage(getCanvas().snapshot(param,null));
        return img;
    }
    public void motionBlur(MOTIONBController contr){
        double radius=  contr.getRadiusSlider().getValue();
        double angle=contr.getAngleSlider().getValue();
        //ImageView img= (ImageView) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
        MBlur m=new MBlur();
        m.apply(getImage(),radius,angle);
    }
    public void bloom(BLOOMController contr){
        double thrashold=  contr.getThresholdSlider().getValue();
        Bloomm b=new Bloomm();
        b.apply(getImage(),thrashold);
    }

    public void glow(GLOWController contr){
        double level=  contr.getSlider().getValue();
       Gloww g=new Gloww();
        g.apply(getImage(),level);
    }

    public void sepia(SEPIAController contr){
        double level=  contr.getSlider().getValue();
        Sepia s=new Sepia();
        s.apply(getImage(),level);
    }

    public void shadow(SHADOWController contr){
        double level=  contr.getSlider().getValue();
        Shadow s=new Shadow();
        s.apply(getImage(),level);
    }

    @FXML
    void BloomOnAction(ActionEvent event) {
        initNewController(bloomContr,"src\\main\\java\\Presentation\\FXMLfiles\\Bloom.fxml","Bloom");
    }
    @FXML
    void GaussianBlurOnAction(ActionEvent event) {
        initNewController(gaussContr, "src\\main\\java\\Presentation\\FXMLfiles\\GaussianBlur.fxml","GaussianBlur");
    }

    @FXML
    void MotionBlurOnAction(ActionEvent event) {
        initNewController(motionContr, "src\\main\\java\\Presentation\\FXMLfiles\\MotionBlur.fxml", "MotionBlur");
    }

    @FXML
    void ReflectionOnAction(ActionEvent event) {
            initNewController(reflContr,"src\\main\\java\\Presentation\\FXMLfiles\\Reflection.fxml","Reflection");
    }


    @FXML
    void GlowOnAction(ActionEvent event) {
        initNewController(glowContr,"src\\main\\java\\Presentation\\FXMLfiles\\Glow.fxml","Glow");
    }

    @FXML
    void SepiaOnAction(ActionEvent event) {
        initNewController(sepiaContr,"src\\main\\java\\Presentation\\FXMLfiles\\Sepia.fxml","Sepia Tone");
    }


    @FXML
    void ShadowOnAction(ActionEvent event) {
        initNewController(shadowContr,"src\\main\\java\\Presentation\\FXMLfiles\\Shadow.fxml","Shadow");
    }
    public Canvas getCanvas(){
        return (Canvas) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
    }
   //@FXML
   /* void RectOnAction(ActionEvent event) {
        //Rectangle rect=new Rectangle(10,10,200,200);
        //rect.setFill(Color.BLUE);
        //GraphicsContext graphics_context =

        Rectangle r=new Rectangle();
        r.draw(getCanvas(),cpFillColor.getValue(),cpBorderColor.getValue(),sldBorderSize.getValue(),filled.isSelected(),posX1,posY1,posX2,posY2);

    }
    @FXML
    void CircleOnAction(ActionEvent event) {
        Circle ci=new Circle();
        ci.draw(getCanvas(),cpFillColor.getValue(),cpBorderColor.getValue(),sldBorderSize.getValue(),filled.isSelected(),posX1,posY1,posX2,posY2);

    }
    @FXML
    void LineOnAction(ActionEvent event) {
        Line l=new Line();
        l.draw(getCanvas(),cpFillColor.getValue(),cpBorderColor.getValue(),sldBorderSize.getValue(),filled.isSelected(),posX1,posY1,posX2,posY2);

    }*/
    @FXML
    void fill(ActionEvent event) {

    }

    @FXML
    void BackgroundOnAction(MouseEvent event){
        if(bg.isSelected() && accordion.getExpandedPane().getText().equals("Drawing Tools")){
            Rectangle r=new Rectangle();
            r.draw(getCanvas(),bgColor.getValue(),null,0,bg.isSelected(),0,0,getCanvas().getWidth(),getCanvas().getHeight());
        }
    }

    @FXML
    void changeBackground(ActionEvent event) {
        if(bg.isSelected() && accordion.getExpandedPane().getText().equals("Drawing Tools")){
            Rectangle r=new Rectangle();
            r.draw(getCanvas(),bgColor.getValue(),null,0,bg.isSelected(),0,0,getCanvas().getWidth(),getCanvas().getHeight());
        }

    }

    @FXML
    void write(KeyEvent event) {
        Text t=new Text();
        t.setText(getCanvas(),tfTextString.getText(),cbbFontStyle.getValue(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),posX1,posY1);

        //System.out.println(accordion.getExpandedPane().getText());

    }
    int c=1;
    @FXML
    private Accordion accordion;
    @FXML
    void DeleteOnAction(ActionEvent event) {
        tfTextString.setText( tfTextString.getText().substring(0, tfTextString.getText().length()-1));
        Text t=new Text();
        t.clear(getCanvas(),tfTextString.getText(),tfTextString.getText().substring(0, tfTextString.getText().length()-c),cbbFontStyle.getValue(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),bgColor.getValue(),posX1,posY1);
        if(tfTextString.getText().length()==0){
            c=0;
        }
        else {
            c++;
        }
    }

}
