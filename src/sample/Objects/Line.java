package sample.Objects;

import javafx.scene.canvas.Canvas;
import sample.Objects.Figure;

public class Line extends Figure {

    @Override
    public void Draw(Canvas canvas) {
        canvas.getGraphicsContext2D().strokeLine(fist.x,fist.y,second.x,second.y);

    }

    @Override
    public Figure factor() {
        return new Line();
    }
}
