package room;

public class Doom {
    protected Room room;

    public Doom(Room room) {
        this.room = room;
    }

    public boolean isFinshed(){
        return room.getPlayer().isDead();
    }

    public void start(){
        while (!isFinshed()){
            try {
                Thread.sleep(1000);
                this.room.update();
                //this.room.display.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
