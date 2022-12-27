public class SnakeParts {
    Main main;
    float x;
    float y;
    int direction;
    float newX;
    float newY;

    public SnakeParts(Main main, float x, float y, int d) {
        this.main = main;
        this.x = x;
        this.y = y;
        direction = d;
    }

    public void draw() {
        main.fill(179, 89, 0);
        main.ellipse(x, y, 20, 20);
    }

    public void tail() {
        main.fill(77, 38, 0);
        addPart();
    } public void head() {
        main.fill(255);
        addPart();
    }
    public void addPart(){
        switch (direction) {
            case 1:
                main.triangle(x - 10, y - 10, x + 10, y - 10, x, y + 10);
                break;
            case 2:
                main.triangle(x - 10, y + 10, x + 10, y + 10, x, y - 10);
                break;
            case 3:
                main.triangle(x - 10, y + 10, x - 10, y - 10, x + 10, y);
                break;
            case 4:
                main.triangle(x + 10, y + 10, x + 10, y - 10, x - 10, y);
                break;
        }
    }
}