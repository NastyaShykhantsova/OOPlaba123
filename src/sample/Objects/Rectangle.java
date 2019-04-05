package sample.Objects;

import javafx.scene.canvas.Canvas;

public class Rectangle extends Figure {
    @Override
    public void Draw(Canvas canvas) {

        swap();
        canvas.getGraphicsContext2D().strokeRect(fist.x,fist.y,Math.abs(fist.x-second.x),Math.abs(second.y-fist.y));
    }

    @Override
    public Figure factor() {
        return new Rectangle();
    }
}
