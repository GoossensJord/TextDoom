package room;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        Doom game = new Doom(room);
        game.start();
    }
}
