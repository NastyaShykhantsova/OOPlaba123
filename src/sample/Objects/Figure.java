package sample.Objects;

import javafx.scene.canvas.Canvas;
import sample.Point;

import java.io.Serializable;

public abstract class Figure implements Serializable {

    public Point fist= new Point();
    public Point second =new Point();
    public abstract   void Draw(Canvas canvas);
    public void   swap()
    {
        double temp;
        if (second.y<fist.y) {
            temp =second.y;
            second.y=fist.y;
            fist.y=temp;
        }
        if (second.x<fist.x) {
            temp =second.x;
            second.x=fist.x;
            fist.x=temp;

        }
    }
    public  abstract Figure factor();  //возвращает фигуру данного типа
}
