package characters;

import room.Room;

import java.util.Random;

public class Zombie extends Monster {
    public enum ZombieStatus {
        DEAD("X"), ALIVE("Z");
        private String currentStatus;

        ZombieStatus(String status) {
            currentStatus = status;
        }
    }

    protected ZombieStatus status = ZombieStatus.DEAD;

    public Zombie(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public void move() {
        Random r = new Random();
        int chance = r.nextInt(101);

        if (chance <= 10) status = ZombieStatus.ALIVE;

        if (!(status == ZombieStatus.DEAD)) {
            super.move();
            chance = r.nextInt(101);
            if (chance <= 70) status = ZombieStatus.DEAD;
            System.out.println("ALIVE");
        } else Room.floorPlan[this.x][this.y] = this.toString().charAt(0);
    }


    @Override
    public String toString() {
        System.out.println(status.currentStatus);
        return status.currentStatus;
    }

    @Override
    public void attackPlayer() {

    }
}
