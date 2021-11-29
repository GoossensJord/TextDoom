package characters;

import room.Room;

import java.util.Random;

public class Player extends DoomCharacter {
    private final double START_HEALTH = 9;
    protected double health;

    public Player(int x, int y) {
        this.health = START_HEALTH;
        super.random = new Random();
        this.x = random.nextInt(Room.WIDTH);
        this.y = random.nextInt(Room.HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void attack(double damage) {
        this.health -= damage;
        this.isDead();
        System.out.println("Damaged");
    }

    public double getHealth() {
        return health;
    }

    public boolean isDead() {
        if (this.health <= 0) return true;
        else return false;
    }


    @Override
    public String toString() {
        return "P";
    }
}

