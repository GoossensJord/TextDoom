package characters;

public class SimpleMonster extends Monster{
    public SimpleMonster(Player player , int x,int y){
        super(player, x, y);
    }
    public void attackPlayer(){ if((Math.abs(this.x - this.player.getX())<= 1) && Math.abs(this.y - this.player.getY())<=1) this.player.attack(super.STRENGHT);}
}
