package characters;

import room.Room;

public class Follower extends SimpleMonster{
    public Follower(Player p, int x, int y){
        super(p,x,y);
    }

    @Override
    public void move(){
        int dxWaarde = 0;
        int dyWaarde = 0;
        int prevposx = this.x;
        int prevposy = this.y;
        while (true) {
            if(super.player.getX() > this.x) dxWaarde = 1;
            else dxWaarde = -1;
            if(super.player.getY() > this.y) dyWaarde =1;
            else dyWaarde = -1;

            if (this.room.isFree(getX() + dxWaarde, getY() + dyWaarde)) {
                this.x += dxWaarde;
                this.y += dyWaarde;
                Room.floorPlan[this.x][this.y] = this.toString().charAt(0);
                Room.floorPlan[prevposx][prevposy] = ' ';
            }
            return;
        }
    }

    @Override
    public String toString() {
        return "F";
    }
}
