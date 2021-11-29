package room;

import characters.Monster;
import characters.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {
    private JPanel panel;
    private JButton exitButton;

    public Display() throws HeadlessException {
        setTitle("Game");
        createComponents();
        layoutComponents();
        addListeners();
        setSize(Room.WIDTH, Room.HEIGHT);
        setVisible(true);
    }

    private void createComponents() {
        this.panel = new JPanel();
        this.exitButton = new JButton("exit");
    }

    private void layoutComponents() {
        Container contentPane = getContentPane();
        contentPane.add(this.panel, BorderLayout.CENTER);
        contentPane.add(this.exitButton, BorderLayout.SOUTH);
    }

    private void exit() {
        setVisible(false);
        System.exit(0);
    }

    private void addListeners() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exit();
            }
        });
    }

    public void clear() {
        final Graphics graphics = panel.getGraphics();
        graphics.clearRect(0, 0, Room.WIDTH, Room.HEIGHT);
    }

    public void drawPlayer(Player player) {
        final Graphics graphics = panel.getGraphics();
        graphics.setColor(Color.GREEN);
        graphics.fillOval(player.getX(), player.getY(), 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(player.getX(), player.getY(), 10, 10);
    }
    public void drawMonster(Monster monster) {
        final Graphics graphics = panel.getGraphics();
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(monster.getX(), monster.getY(), 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(monster.getX(), monster.getY(), 10, 10);
    }

//    public void drawRectangle(Location location) {
//        final Graphics graphics = panel.getGraphics();
//        graphics.setColor(Color.RED);
//        graphics.fillRoundRect(location.getX() * 10, location.getY() * 10, 10, 10, 2, 2);
//        graphics.setColor(Color.BLACK);
//        graphics.drawRoundRect(location.getX() * 10, location.getY() * 10, 10, 10, 2, 2);
//    }

//    public void drawString(String s, Location location) {
//        final Graphics graphics = panel.getGraphics();
//        graphics.setColor(Color.BLUE);
//        graphics.drawString(s, location.getX() * 10, location.getY() * 10);
//    }
//
//    public void drawNames(String s, Player player) {
//        final Graphics graphics = panel.getGraphics();
//        graphics.setColor(Color.RED);
//        graphics.drawString(s, player.getLocation().getX() * 9 , player.getLocation().getY() * 9);
//    }
}