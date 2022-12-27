import processing.core.PApplet;


public class Main extends PApplet {

    public enum gameStates {HOME, LEVEL, GAMEPLAY, RESULT, EXIT}

    private gameStates window = gameStates.HOME;

    int result = 0;
    int bestResult = 0;
    int velocity = 5;

    HomeTitle homeWindow = new HomeTitle(this);
    LevelTitle speedWindow = new LevelTitle(this);
    GameplayTitle gamePlayWindow = new GameplayTitle(this);
    ResultTitle resultWindow = new ResultTitle(this);
    ExitCommand exitWindow = new ExitCommand();

    public void settings() {
        fullScreen();
    }

    public void setup() {
        frameRate(10);
    }


    public void draw() {
        switch (window) {
            case HOME:
                window = homeWindow.run();
                break;
            case LEVEL:
                window = speedWindow.run();
                break;
            case GAMEPLAY:
                window = gamePlayWindow.run();
                break;
            case RESULT:
                window = resultWindow.run();
                break;
            case EXIT:
                exitWindow.run();
                break;
        }

    }


    public static void main(String... args) {
        PApplet.main("Main");
    }
}