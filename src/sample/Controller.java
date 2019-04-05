package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Objects.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    @FXML
    Canvas MainCanvas;
    @FXML
    Button Line1;
    @FXML
    ColorPicker GridColor;
    @FXML
    ColorPicker GridColorFill;


    private  AllFigure allFigure = new AllFigure(); //список всех фигур
    private  Figure chose;    //выбранная фигура
    private double x1,y1,x2,y2;   //нажатие-отжатие

    @FXML
    public void initialize() {
        chose=new Line();
        GridColor.setValue(Color.BLACK);
        GridColorFill.setValue(Color.WHITE);
        MainCanvas.getGraphicsContext2D().setFill(Paint.valueOf("white"));
    }


    public void handle(MouseEvent mouseEvent) { //нажатие
        x1 =mouseEvent.getSceneX();
        y1=mouseEvent.getSceneY()-125;
    }

    public void setСoordinates(){
        chose=chose.factor();
        chose.fist.x=x1;
        chose.fist.y=y1;
        chose.second.x=x2;
        chose.second.y=y2;
    }

    public void handle1(MouseEvent mouseEvent) {  //отжатие
        x2 = mouseEvent.getSceneX();
        y2 = mouseEvent.getSceneY()-125;
        setСoordinates();
        chose.Draw(MainCanvas);
        allFigure.addFigure(chose);
    }

    public void MovedMouse(MouseEvent mouseEvent) {   //держишь мышку
        PaintAll();
        x2 = mouseEvent.getSceneX();
        y2 = mouseEvent.getSceneY()-125;
        setСoordinates();
        chose.Draw(MainCanvas);
    }

    public  void clear()
    {
        MainCanvas.getGraphicsContext2D().clearRect(0,0,1000,681);
        allFigure.getAll().clear();
    }
    public  void Clear(ActionEvent actionEvent){
        clear();
    }

    public void ColorSetPen(ActionEvent actionEvent) {
        MainCanvas.getGraphicsContext2D().setStroke(GridColor.getValue());//контур

    }

    public void ColorSetFill(ActionEvent actionEvent) {
        MainCanvas.getGraphicsContext2D().setFill(GridColorFill.getValue());//заливка
    }

    public void ChooseLine(ActionEvent actionEvent) {
        chose=new Line();
    }

    public void ChooseSquare(ActionEvent actionEvent) {
        chose = new Square();
    }

    public void ChooseCircle(ActionEvent actionEvent) {
        chose=new Circle();
    }

    public void ChooseRectangle(ActionEvent actionEvent) {
        chose= new Rectangle();
    }

    public void ChooseRightArrow(ActionEvent actionEvent) {
        chose=new RightArrow();
    }

    public void ChooseTriangle(ActionEvent actionEvent) {
        chose=new Triangle();
    }

    public  void WriteInFile(String name,String content) {
        try(FileWriter writer = new FileWriter(name, false))
        {

            writer.write(content);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void SaveAll(ActionEvent actionEvent) throws Exception {  //серялизация в бинарный файл
        ArrayList<Figure> all= allFigure.getAll();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("figure.dat")))
        {

            oos.writeObject(all);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public void ReadAll(ActionEvent actionEvent) throws IOException {   //чтение из файла
        clear();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("figure.dat")))
        {
            allFigure.setAll((ArrayList<Figure>)ois.readObject());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        PaintAll();

    }

    public void PaintAll(){   //очищает canvas, перерисовывает фигуры
        MainCanvas.getGraphicsContext2D().clearRect(0,0,MainCanvas.getWidth(),MainCanvas.getWidth());
        for(Figure h:allFigure.getAll())
            h.Draw(MainCanvas);
    }
    public void Cancel(ActionEvent actionEvent) {   //удаление последней фигуры
        if (allFigure.getAll().size()>0) {
            allFigure.getAll().remove(allFigure.getAll().size()-1);
            PaintAll();
        }
    }

}
