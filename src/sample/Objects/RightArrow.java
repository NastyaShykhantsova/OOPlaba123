package sample.Objects;

import javafx.scene.canvas.Canvas;

public class RightArrow extends Figure {
    @Override
    public void Draw(Canvas canvas) {

             swap();
        canvas.getGraphicsContext2D().strokeLine((fist.x-second.x)/2, (fist.y-second.y)/2,second.x, second.y);
    }

    @Override
    public Figure factor() {
        return new RightArrow();
    }
}
