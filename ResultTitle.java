public class ResultTitle {
    Main main;

    public ResultTitle(Main main) {
        this.main = main;
    }

    public Main.gameStates run() {
        main.background(77, 38, 0);
        main.fill(255);
        main.textSize(40);
        main.textAlign(main.CENTER);
        main.text("YOUR RESULT: " + main.result, main.width / 4, main.height / 2);
        main.text("BEST RESULT: " + main.bestResult, main.width * 3 / 4, main.height / 2);
        if (main.result >= main.bestResult) {
            drawBest();
        } else if(main.result < main.bestResult) {
            drawWorst();
        }
        if (main.keyCode == main.ENTER) {
            main.keyCode = 0;
            return Main.gameStates.LEVEL;
        } else if (main.keyCode == main.ESC) {
            return Main.gameStates.EXIT;
        }
        return Main.gameStates.RESULT;
    }

    public void drawBest() {
        main.textAlign(main.CENTER);
        main.textSize(50);
        main.fill(0, 255, 0);
        main.text("New Record!!!", main.width / 2, main.height / 4);
    }

    public void drawWorst() {
        main.textAlign(main.CENTER);
        main.textSize(50);
        main.fill(255, 0, 0);
        main.text("you can more...", main.width / 2, main.height / 4);
    }
}