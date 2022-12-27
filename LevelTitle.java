
public class LevelTitle {

    Main main;

    public LevelTitle(Main main) {
        this.main = main;
    }

    public Main.gameStates run() {
        main.background(77,38,0);
        main.frameRate(10);
        main.fill(200, 200, 0);
        main.textSize(72);
        main.textAlign(main.CENTER);
        main.text("Choose speed", main.width / 2, 100);
        main.fill(255, 0, 0);
        main.text(main.velocity, main.width / 2, main.height / 2 + 25);

        main.fill(0, 200, 0);
        main.triangle(main.width / 2 - 25, main.height / 2 - 50, main.width / 2 + 25, main.height / 2 - 50, main.width / 2, main.height / 2 - 100);
        main.triangle(main.width / 2 - 25, main.height / 2 + 75, main.width / 2 + 25, main.height / 2 + 75, main.width / 2, main.height / 2 + 125);

        if (main.keyCode == main.ESC) {
            main.keyCode = 0;
            return Main.gameStates.EXIT;

        } else if (main.keyCode == main.UP && main.velocity != 10) {
            main.velocity++;
            main.keyCode = 0;
        } else if (main.keyCode == main.DOWN && main.velocity != 1) {
            main.velocity--;
            main.keyCode = 0;
        } else if (main.keyCode == main.ENTER) {
            main.result = 0;
            main.keyCode = main.RIGHT;
            return Main.gameStates.GAMEPLAY;
        }
        return Main.gameStates.LEVEL;
    }
}