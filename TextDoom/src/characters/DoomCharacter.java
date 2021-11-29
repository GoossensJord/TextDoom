package characters;

import room.Room;

import java.util.Random;

public class DoomCharacter {
    protected int x;
    protected int y;
    protected Random random;
    protected Room room;

    public DoomCharacter(int x, int y) {
        random = new Random();
        this.x = random.nextInt(Room.WIDTH);
        this.y = random.nextInt(Room.HEIGHT);
    }

    public DoomCharacter() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void move() {
        //        while(!room.isFree(posx,posy) || posx == -1 || posy ==1) {
        //            posx += random.nextInt(2)-1;
        //            posy += random.nextInt(2)-1;
        //        }
        //        this.room.floorPlan[posx][posy] = this.room.getPlayer().toString().charAt(0);
        //        System.out.println(this.room.isFinished());
        int prevposx = this.x;
        int prevposy = this.y;
        while (true) {
            int dxWaarde = random.nextInt(3) - 1;
            int dyWaarde = random.nextInt(3) - 1;
            if (this.room.isFree(getX() + dxWaarde, getY() + dyWaarde)) {
                this.x += dxWaarde;
                this.y += dyWaarde;
                //System.out.println(this.getClass());
                if(this instanceof Player) {
                    Room.floorPlan[this.x][this.y] = this.toString().charAt(0);
                    //this.room.display.drawPlayer((Player)this);
                }
                else {
                    Room.floorPlan[this.x][this.y] = this.toString().charAt(0);
                    //this.room.display.drawMonster((Monster)this);
                }

                Room.floorPlan[prevposx][prevposy] = ' ';
            }
            return;
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}

