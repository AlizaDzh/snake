import java.util.ArrayList;

public class GameplayTitle {
    Main main;
    float width = 1366; 
    float height = 768; 
    float bigW = 720;
    float bigH = 480;
    int radius = 20;
    float x = (width - bigW + 5 * 20) / 2;
    float y = (height - bigH + 20) / 2;
    float startX = x;
    float startY = y;
    int direction = 0;
    ArrayList<SnakeParts> part = new ArrayList<>();
    int score = 0;
    boolean isDead = false;
    float appleX = (width - bigW) / 2 + ((int) (Math.random() * 35)) * radius + 10;
    float appleY = (height - bigH) / 2 + ((int) (Math.random() * 23)) * radius + 10;


    public GameplayTitle(Main main) {
        this.main = main;
    }

    public Main.gameStates run() {

        drawField();

        main.frameRate(main.velocity + 3);
        snakeControl();

        main.fill(255, 0, 0);
        main.ellipse(appleX, appleY, 20, 20);
        part.add(0, new SnakeParts(main, x, y, direction));
        part.get(0).head();
        if (part.size() > 2) {
            part.get(part.size() - 1).tail();
            part.remove(part.size() - 1);
            for (int i = 2; i < part.size(); i++) {
                if (part.get(0).x == part.get(i).x && part.get(0).y == part.get(i).y) {
                    isDead = true;
                }
            }
        }

        if (x == appleX && y == appleY) {
            appleX = (width - bigW) / 2 + ((int) (Math.random() * 35)) * radius + 10;
            appleY = (height - bigH) / 2 + ((int) (Math.random() * 23)) * radius + 10;
            score++;
            part.add(score, new SnakeParts(main, x, y, direction));
        } else if (x < (width - bigW) / 2 + 10 || x > (width - bigW) / 2 + 36 * radius - 10
                || y < (height - bigH) / 2 + 10 || y > (height - bigH) / 2 + 24 * radius - 10 || isDead) {
            main.result = score;
            if (main.result > main.bestResult) {
                main.bestResult = main.result;
            }
            part.removeAll(part);
            x = startX;
            y = startY;
            score = 0;
            direction = 4;
            isDead = false;
            return Main.gameStates.RESULT;
        }
        for (SnakeParts e : part) {
            e.draw();
        }


        return Main.gameStates.GAMEPLAY;
    }

    public void drawField() {
        main.background(77,38,0);

        main.fill(0, 0, 255);
        main.rect(main.width / 2, main.height / 2, radius, radius);

        for (int i = 0; i < 36; i++) {
            for (int j = 0; j < 24; j++) {

                main.fill(65, 146, 21);
                main.rect((main.width - bigW) / 2 + i * radius, (main.height - bigH) / 2 + j * radius, radius, radius);
            }
        }

        main.textAlign(main.CENTER);
        main.textSize(80);
        main.fill(255, 255, 0);
        main.text("Level: " + main.velocity, main.width / 2, (main.height - bigH) / 3);

        main.textAlign(main.CENTER);
        main.textSize(40);
        main.fill(255, 255, 0);
        main.text("Score: " + score, main.width / 4, (main.height - bigH / 6));

        main.textAlign(main.CENTER);
        main.textSize(40);
        main.fill(255, 255, 0);
        main.text("Best result: " + main.bestResult, main.width * 3 / 4, (main.height - bigH / 6));
    } // drawField method

    public void snakeControl() {
        switch (main.keyCode) {
            case 38://up
                if (direction != 2) {
                    y -= 20;
                    direction = 1;
                } else {
                    y += 20;
                }
                break;
            case 40://down
                if (direction != 1) {
                    y += 20;
                    direction = 2;
                } else {
                    y -= 20;
                }
                break;
            case 37://left
                if (direction != 4) {
                    x -= 20;
                    direction = 3;
                } else {
                    x += 20;
                }
                break;
            case 39://right
                if (direction != 3) {
                    x += 20;
                    direction = 4;
                } else {
                    x -= 20;
                }
                break;
        }
    }


}