public class HomeTitle {
    Main main;

    public HomeTitle(Main main) {
        this.main = main;

    }

    public Main.gameStates run() {
        main.background(77,38,0);
        main.textAlign(main.CENTER);
        main.textSize(50);
        main.fill(255, 0, 0);
        main.text("Snake", main.width / 2, 100);
        main.fill(255, 255, 0);
        main.text("by Shabdan", main.width / 2, 400);
        main.textSize(40);
        main.fill(0, 255, 0);
        main.text("press ENTER to continue", main.width / 2, 700);

        if (main.keyCode == main.ENTER) {
            main.keyCode = 0;
            return Main.gameStates.LEVEL;
        }
        return Main.gameStates.HOME;
    }

}