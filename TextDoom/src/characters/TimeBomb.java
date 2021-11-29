package characters;

public class TimeBomb extends Monster {
    private final int BOMB_STRENGTH = 3;
    private int startTime;
    private int timeLeft;

    public TimeBomb(Player player, int x, int y, int startTime) {
        super(player, x, y);
        this.startTime = startTime;
        this.timeLeft = this.startTime;
    }

    @Override
    public void attackPlayer(){
        if((Math.abs(this.x - this.player.getX())< 5) && Math.abs(this.y - this.player.getY())<5) this.player.attack(BOMB_STRENGTH);
    }


    public void move() {
        super.move();
        this.timeLeft--;
        if (timeLeft == 0) this.attackPlayer();
    }

    @Override
    public String toString() {
        return timeLeft+"";
    }
}
