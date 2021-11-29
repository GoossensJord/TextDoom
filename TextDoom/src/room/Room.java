package room;

import characters.*;

import java.sql.Time;
import java.util.Random;

public class Room {
    public final static int HEIGHT = 25;
    public final static int WIDTH = 30;
    public Display display;
    protected Player player;
    public static char[][] floorPlan;
    public Monster[] characters;

    private Random r;

    public Room() {
        //this.display = new Display();
        r = new Random();
        this.player = new Player(1, 2);
        floorPlan = new char[WIDTH][HEIGHT];
        this.createFloorPlan();
        this.draw();
        this.player.setRoom(this);

        this.characters = new Monster[15];
        fillMonsterArr();
    }

    private void createFloorPlan() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (i == 0 || i == WIDTH - 1) floorPlan[i][j] = '-';
                else if (j == 0 || j == HEIGHT - 1) floorPlan[i][j] = '|';
                else floorPlan[i][j] = ' ';
            }
        }
    }

    private void draw() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                System.out.print(floorPlan[i][j]);
            }
            System.out.println();
        }
        System.out.println("Health:  " + this.player.getHealth());
        //this.display.drawPlayer(this.player);
    }

    public boolean isFinished() {
        return this.player.isDead();
    }

    public boolean isFree(int x, int y) {
        if (x < WIDTH && x > 0 && y < HEIGHT && y > 0 && floorPlan[x][y] == ' ') return true;
        else return false;
    }

    private void fillMonsterArr() {
        int x;
        int y;
        for (int i = 0; i < 5; i++) {
            x = r.nextInt(Room.WIDTH);
            y = r.nextInt(Room.HEIGHT);
            this.characters[i] = new Follower(this.player, x, y);
        }
        for (int i = 5; i < 10; i++) {
            x = r.nextInt(Room.WIDTH);
            y = r.nextInt(Room.HEIGHT);
            this.characters[i] = new TimeBomb(this.player, x, y,r.nextInt(11));
        }
        for (int i = 11; i < 15; i++) {
            x = r.nextInt(Room.WIDTH);
            y = r.nextInt(Room.HEIGHT);
            this.characters[i] = new Zombie(this.player, x, y);
        }
    }

    public void update() {
        this.player.move();
        for (DoomCharacter m : this.characters) {
            if(m instanceof Monster){
                m.move();
                ((Monster) m).attackPlayer();
            }
        }
        draw();
    }

    public Player getPlayer() {
        return this.player;
    }
}
