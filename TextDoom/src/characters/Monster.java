package characters;

import java.util.Random;

public abstract class Monster extends DoomCharacter {
    protected int STRENGHT =1;
    public Player player;

    public Monster(Player player,int x,int y) {
        super.random = new Random();
        this.x = x;
        this.y = y;
        this.player = player;
        super.room = this.player.room;

    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return "M";
    }
    public abstract void attackPlayer();
}
