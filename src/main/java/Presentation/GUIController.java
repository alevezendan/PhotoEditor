package Presentation;


import Business.ColorParameters.Brightness;
import Business.ColorParameters.Contrast;
import Business.ColorParameters.Hue;
import Business.ColorParameters.Saturation;
import Business.Effects.*;

import Business.Filters.RGBFilter;
import Business.IPhotoEditor;
import Business.Operations.*;
import Business.PhotoEditor;
import Business.Shapes.*;
import Business.Shapes.Rectangle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
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
    private Button res,crop,rotR,rotL,flipV,flipH,zoomI,zoomO;
    @FXML
    private ComboBox<String> cbbFontStyle;
    @FXML
    private ComboBox<Integer> cbLayer;
    public double posX1,posY1,posX2,posY2;
    public int cnt=1;
    @FXML
    private Slider sldBorderSize;
    @FXML
    private ColorPicker cpBorderColor;
    @FXML
    private ColorPicker bgColor;
    @FXML
    private CheckBox bg, setText;
    @FXML
    private ComboBox<String> comboShapes;
   // private ObservableList<String> fonts= (ObservableList<String>) javafx.scene.text.Font.getFamilies();
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Rectangle","Circle","Line");
    public TabPane getTabPanee() {
        return TabPanee;
    }
    private double positionX = 0;
    private double positionY = 0;
    private Tools tools;

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
        tools=new Tools();


    }
    @FXML
    private MenuBar menuBar;
    @FXML
    private GridPane gridButtons;
    @FXML
    private TitledPane tpane1,tpane2;

    @FXML
    private AnchorPane anch1,anch2,anch0;

    @FXML
    private HBox hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8;
    @FXML
    private Pane p1,p2;
    @FXML
    private Menu fileM,editM,helpM,colorM,effectM,filterM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialized");
        imageView = new ImageView();
        photoEditor = new PhotoEditor();
        comboShapes.setItems(dbTypeList);
        //  cbbFontStyle.setItems(fonts);
        cbbFontStyle.getItems().addAll(Font.getFontNames());
        cbbFontStyle.setValue("Roboto");
        tools=new Tools();

        //String image = EditorGUI.class.getResource("icon_crop.png").toExternalForm();
        File f = new File("C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/icon_crop.png");
        URL u = null;
        try {
            u = f.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image img = new Image(u.toExternalForm());
        String cssLayout =
                "-fx-background-image: url(icons8-sun-100.png);\n"
            ;
       // res.setStyle("-fx-background-color: #e6b3cc;\n");
       // crop.setStyle("-fx-background-color: #993366;\n");
        //rotL.setStyle("-fx-background-color:#e6b3cc;\n");
        //rotR.setStyle("-fx-background-color: #d98cb3;\n");
        //flipH.setStyle("-fx-background-color: #d98cb3;\n");
        //flipV.setStyle("-fx-background-color: #d98cb3;\n");
        //zoomI.setStyle("-fx-background-color: #d98cb3;\n");
        //zoomO.setStyle("-fx-background-color: #d98cb3;\n");
        String menuLayout="-fx-background-color:  #f2d9e6;\n";
        String hbLayout="-fx-background-color: #df9fbf;\n";
       // menuBar.setStyle("-fx-background-color: #25022c;;\n"+"-fx-opacity: 0.9");
       // TabPanee.setStyle(menuLayout);
       // gridButtons.setStyle("-fx-background-color: #f2d9e6");
       // anch0.setStyle("-fx-background-color: #f2d9e6" +
           //     "");
       /* accordion.setStyle(menuLayout);
        tpane1.setStyle(menuLayout);
        tpane2.setStyle(menuLayout);
        anch1.setStyle(menuLayout);
        anch2.setStyle(menuLayout);
        hb1.setStyle(hbLayout);
        hb3.setStyle(hbLayout);
        hb5.setStyle(hbLayout);
        hb7.setStyle(hbLayout);
        p2.setStyle(menuLayout);*/



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
        Tab t=new Tab();
        Pane p=new Pane();
        imageView.setFitHeight(p.getHeight());
        imageView.setFitWidth(p.getWidth());
        p.getChildren().addAll(imageView);
        t.setText("NewImage");
        t.setContent(p);
        TabPanee.getTabs().add(t);



      //  t.setStyle("-fx-background-color:  #ffb3cc;\n");

       // javafx.scene.shape.Rectangle rectangle;
       // rectangle = new javafx.scene.shape.Rectangle(0, 0, image.getWidth(), image.getHeight());
        //rectangle.setStrokeWidth(lineSize);
       // rectangle.setFill(new ImagePattern(image));
       // imageView.setImage(new Image(rectangle));


      //  getMainPane().getChildren().add(imageView);
        //cbLayer.getItems().clear();
       // rectangle.setStroke(strokeColor);
       // rectangle.setOpacity(opacity/100);
       /* FileChooser fileChooser = new FileChooser();
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
        photoEditor.loadImage(selectedFile.getAbsolutePath());*/

        //Imagee i=new Imagee();
        //i.image(cpFillColor.getValue(),wid)
    }

    @FXML
    void saveFileOnAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save File");
        //fc.setInitialDirectory(new File("/home"));
        fc.setInitialFileName("project");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG File", "*.png"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG File", "*.jpg"));
        try {
            File selectedFile = fc.showSaveDialog(new Stage());
            if (selectedFile != null) {
                Image snapshot = TabPanee.getSelectionModel().getSelectedItem().getContent().snapshot(null, null);

                //ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", selectedFile);
            }
        } catch (Exception e) {
        }
    }
    @FXML
    private Accordion accordion;
    public Pane getMainPane(){
        return (Pane) TabPanee.getSelectionModel().getSelectedItem().getContent();
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
        try{
        if(accordion.getExpandedPane().getText().equals("Drawing Tools")) {
            if (comboShapes.getValue().equals("Line")&& cnt % 2 == 0) {
                getMainPane().getChildren().addAll(tools.line(sldBorderSize.getValue(), cpBorderColor.getValue(), posX1, posY1, posX2, posY2));
                layerCount();
            }else
            {
                if (comboShapes.getValue().equals("Rectangle") && cnt % 2 == 0) {
                    Rectangle r = new Rectangle();
                    //  r.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);
                    Shape shape;
                    shape = tools.rect(cpFillColor.getValue(), cpBorderColor.getValue(), posX1, posY1, posX2 - posX1, posY2 - posY1, sldBorderSize.getValue(),filled.isSelected());
                    DragResizeMod.makeResizable(shape);
                    getMainPane().getChildren().addAll(shape);
                layerCount();
                }
                else
                {
                    if (comboShapes.getValue().equals("Circle") && cnt % 2 == 0) {
                        Circle c = new Circle();
                        Shape shape;
                        shape = tools.oval(cpFillColor.getValue(), cpBorderColor.getValue(), posX1, posY1, posX2 - posX1, sldBorderSize.getValue(),filled.isSelected());
                        DragResizeMod.makeResizable(shape);
                        getMainPane().getChildren().addAll(shape);
                    layerCount();
                    }



                    }
            }
        }else{
            if(accordion.getExpandedPane().getText().equals("Text Tools")){
                if(cnt%2==0){
                    tfTextString.setText("");
                }
                Shape shape;
                shape=tools.text(tfTextString.getText(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),cbbFontStyle.getValue(),posX1,posY1);
              //  MouseControlUtil.makeDraggable(shape);

                getMainPane().getChildren().addAll(shape);
                layerCount();

            }
        }}
        catch(Exception e){
            System.out.println("sc");
        }
        cnt++;
        layerCount();
    }
    @FXML
    void RemoveOnAction(ActionEvent event) {
            removeShape();
    }

    public void clickF() {
        // Tools t=new Tools();
    }

       /* getMainPane().setOnMouseClicked(event1 -> {
            posX1 = event1.getX();
            posY1 = event1.getY();
            if(accordion.getExpandedPane().getText().equals("Drawing Tools")) {
                if (comboShapes.getValue().equals("Line")) {
                    // System.out.println(item);
                    getMainPane().setOnMouseClicked(event2 -> {
                        double p1x = posX1;
                        double p1y = posY1;
                        double p2x = event2.getX();
                        double p2y = event2.getY();
                        System.out.println(p1x + " " + p1y + " " + p2x + " " + p2y);
                       // getMainPane().getChildren().addAll(t.line(sldBorderSize.getValue(), cpBorderColor.getValue(), p1x, p1y, p2x, p2y));
                        Shape shape;
                        shape=t.line(sldBorderSize.getValue(), cpBorderColor.getValue(), p1x, p1y, p2x, p2y);



                        positionX = p2x;
                        positionY = p2y;
                        //layerCount();
                    });

                }else{
                    if (comboShapes.getValue().equals("Rectangle") && cnt % 2 == 0) {
               Rectangle r = new Rectangle();
                r.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);

                Shape shape;
                shape = t.rect(cpFillColor.getValue(), cpBorderColor.getValue(), posX1, posY1, posX2-posX1, posY2-posY1, sldBorderSize.getValue());
                //tools.draw();
                DragResizeMod.makeResizable(shape);
                getMainPane().getChildren().addAll(shape);
                }
                }
            }
        });

    }*/
       /* Tools tools=new Tools();
       // System.out.println(posX+" "+posY);
        if(accordion.getExpandedPane().getText().equals("Drawing Tools")) {
            if (comboShapes.getValue().equals("Rectangle") && cnt % 2 == 0) {
              /*  Rectangle r = new Rectangle();
                r.draw(getCanvas(), cpFillColor.getValue(), cpBorderColor.getValue(), sldBorderSize.getValue(), filled.isSelected(), posX1, posY1, posX2, posY2);

                Shape shape;
                shape = t.rect(cpFillColor.getValue(), cpBorderColor.getValue(), posX1, posY1, posX2-posX1, posY2-posY1, sldBorderSize.getValue());
                //tools.draw();
                DragResizeMod.makeResizable(shape);
                getMainPane().getChildren().addAll(shape);
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
        cnt++;*/
    //}
    @FXML
    void slideBorder(MouseEvent event) {

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
        Pane p=new Pane();

       // tab.setContent(canvas);

        p.getChildren().addAll(tools.rect(Color.WHITE,null,0.0,0.0,500.0,500.0,0.0,true));
        tab.setContent(p);
        /*if(bg.isSelected() && accordion.getExpandedPane().getText().equals("Drawing Tools")){
            getMainPane().getChildren().addAll(tools.rect(bgColor.getValue(),null,0.0,0.0,getMainPane().getWidth(),getMainPane().getHeight(),0.0,true));
        }*/
        tab.setText("BlankTab");
        TabPanee.getTabs().add(tab);
       // getMainPane().getChildren().addAll(tools.rect(Color.WHITE,null,0.0,0.0,getMainPane().getWidth(),getMainPane().getHeight(),0.0,true));

        cbLayer.getItems().clear();

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
        initNewController(resContr,"src\\main\\java\\Presentation\\FXMLfiles\\Resize.fxml","Resize","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    public void inflate(RESIZEController contr){
       int i=TabPanee.getSelectionModel().getSelectedIndex();
       //ImageView img= (ImageView) TabPanee.getTabs().get(i).getContent();
        ImageView img=getImage();
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

    public void initNewController(Controller c,String path,String title,String pathCss){
        try{
            FXMLLoader loader=new FXMLLoader();
            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(path);
            Parent parent=loader.load(fxmlStream);
            c=loader.getController();
            Stage stage =new Stage();

            stage.setTitle(title);
            Scene s=new Scene(parent);
            s.getStylesheets().add(pathCss);
            stage.setScene(s);
            stage.show();
            c.init(this);

        } catch(IOException e){
            System.out.println("eferg");
        }
    }

    @FXML
    void BrightnessOnAction(ActionEvent event) {
        initNewController(brightContr,"src\\main\\java\\Presentation\\FXMLfiles\\Brightness.fxml","Brightness","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");

    }


    @FXML
    void SaturationOnAction(ActionEvent event) {
        initNewController(saturContr,"src\\main\\java\\Presentation\\FXMLfiles\\Saturation.fxml","Sturation","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    @FXML
    void ContrastOnAction(ActionEvent event) {
        initNewController(contrContr,"src\\main\\java\\Presentation\\FXMLfiles\\Contrast.fxml","Contrast","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    @FXML
    void HueOnAction(ActionEvent event) {
        initNewController(hueContr,"src\\main\\java\\Presentation\\FXMLfiles\\Hue.fxml","Hue","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }


    @FXML
    void BoxBlurOnAction(ActionEvent event) {
        initNewController(boxContr,"src\\main\\java\\Presentation\\FXMLfiles\\BoxBlur.fxml","BoxBlur","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
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
        //ImageView img=new ImageView();
        //img.setImage(getCanvas().snapshot(param,null));
       // img.setImage((Image)getMainPane().getChildren().get(0));
       //ImageView i= (ImageView) getMainPane().getChildren().get(TabPanee.getSelectionModel().getSelectedIndex());
       Pane p= (Pane) TabPanee.getSelectionModel().getSelectedItem().getContent();
       ImageView i= (ImageView) p.getChildren().get(0);

        return i;
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
        initNewController(bloomContr,"src\\main\\java\\Presentation\\FXMLfiles\\Bloom.fxml","Bloom","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }
    @FXML
    void GaussianBlurOnAction(ActionEvent event) {
        initNewController(gaussContr, "src\\main\\java\\Presentation\\FXMLfiles\\GaussianBlur.fxml","GaussianBlur","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    @FXML
    void MotionBlurOnAction(ActionEvent event) {
        initNewController(motionContr, "src\\main\\java\\Presentation\\FXMLfiles\\MotionBlur.fxml", "MotionBlur","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    @FXML
    void ReflectionOnAction(ActionEvent event) {
            initNewController(reflContr,"src\\main\\java\\Presentation\\FXMLfiles\\Reflection.fxml","Reflection","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }


    @FXML
    void GlowOnAction(ActionEvent event) {
        initNewController(glowContr,"src\\main\\java\\Presentation\\FXMLfiles\\Glow.fxml","Glow","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }

    @FXML
    void SepiaOnAction(ActionEvent event) {
        initNewController(sepiaContr,"src\\main\\java\\Presentation\\FXMLfiles\\Sepia.fxml","Sepia Tone","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }


    @FXML
    void ShadowOnAction(ActionEvent event) {
        initNewController(shadowContr,"src\\main\\java\\Presentation\\FXMLfiles\\Shadow.fxml","Shadow","file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/pane.css");
    }
    public Canvas getCanvas(){
        return (Canvas) TabPanee.getTabs().get(TabPanee.getSelectionModel().getSelectedIndex()).getContent();
    }
    @FXML
    void fill(ActionEvent event) {

    }

    @FXML
    void BackgroundOnAction(MouseEvent event){
        if(bg.isSelected() && accordion.getExpandedPane().getText().equals("Drawing Tools")){
            getMainPane().getChildren().addAll(tools.rect(bgColor.getValue(),null,0.0,0.0,getMainPane().getWidth(),getMainPane().getHeight(),0.0,true));
        }
    }

    @FXML
    void changeBackground(ActionEvent event) {
        if(bg.isSelected() && accordion.getExpandedPane().getText().equals("Drawing Tools")){
            getMainPane().getChildren().addAll(tools.rect(bgColor.getValue(),null,0.0,0.0,getMainPane().getWidth(),getMainPane().getHeight(),0.0,true));
        }

    }

    @FXML
    void write(KeyEvent event) {
       // Text t=new Text();
       // t.setText(getCanvas(),tfTextString.getText(),cbbFontStyle.getValue(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),posX1,posY1);

        //System.out.println(accordion.getExpandedPane().getText());
        Shape shape;
       // if(setText.isSelected()) {
            shape = tools.text(tfTextString.getText(), Double.parseDouble(tfFontSize.getText()), cpTextColor.getValue(), cbbFontStyle.getValue(), posX1, posY1);
            //  MouseControlUtil.makeDraggable(shape);
            System.out.println(tfTextString.getText());
            getMainPane().getChildren().addAll(shape);
            layerCount();
        //}/*else
        /*{
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Dialog");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("This is a sample dialog");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }*/
    }
    int c=1;

    @FXML
    void DeleteOnAction(ActionEvent event) {
        if(tfTextString.getText().length()!=0){
            tfTextString.setText( tfTextString.getText().substring(0, tfTextString.getText().length()-1));
        }

        Text t=new Text();
        t.clear(getCanvas(),tfTextString.getText(),tfTextString.getText().substring(0, tfTextString.getText().length()-c+1),cbbFontStyle.getValue(),Double.parseDouble(tfFontSize.getText()),cpTextColor.getValue(),bgColor.getValue(),posX1,posY1);
        if(tfTextString.getText().length()==0){
            c=0;
        }
        else {
            c++;
        }
    }

    public void layerCount() {
        cbLayer.getItems().clear();
        for(int i = 0; i<getMainPane().getChildren().size();i++) {
            cbLayer.getItems().add(i);
            cbLayer.setValue(i);
        }
    }
    @FXML
    void layer(ActionEvent event) {

    }
    public void removeShape() {
        int itemLayer =cbLayer.getSelectionModel().getSelectedItem().intValue();
        if(accordion.getExpandedPane().getText().equals("Text Tools") && tfTextString.getText().length()!=0){
            tfTextString.setText( tfTextString.getText().substring(0, tfTextString.getText().length()-1));
        }
        getMainPane().getChildren().remove(itemLayer);
        cbLayer.getItems().remove(itemLayer);
        layerCount();
    }

    @FXML
    void BlackAndWhiteOnAction(ActionEvent event) {
        ColorAdjust colorAdjust=new ColorAdjust();
        colorAdjust.setSaturation(-1);
        ImageView img=getImage();
        img.setEffect(colorAdjust);
    }
    @FXML
    void GreenOnAction(ActionEvent event) {

    }
    @FXML
    void BlueOnAction(ActionEvent event) {

    }
    @FXML
    void RedOnAction(ActionEvent event) {
        RGBFilter r=new RGBFilter();
        r.apply(getImage(),0.0);
    }
    @FXML
    void setOnAction(ActionEvent event) {

    }

}
