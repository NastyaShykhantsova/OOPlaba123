package sample.Objects;

import javafx.scene.canvas.Canvas;

public class RightArrow extends Figure {
    @Override
    public void Draw(Canvas canvas) {

             swap();
        canvas.getGraphicsContext2D().strokeLine(fist.x, fist.y, second.x, second.y);
        canvas.getGraphicsContext2D().strokeLine(second.x, second.y, fist.x, 2*second.y - fist.y);
        canvas.getGraphicsContext2D().strokeLine(fist.x, 2*second.y - fist.y, 2*fist.x - second.x, second.y);
        canvas.getGraphicsContext2D().strokeLine(2*fist.x - second.x, second.y, fist.x, fist.y);
    }

    @Override
    public Figure factor() {
        return new RightArrow();
    }
}
