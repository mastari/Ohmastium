package Engine;

import Game.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class GameLoop extends JPanel implements Runnable {

    public GameStateManager gsm;

    private Thread thread;
    private boolean running;

    private int fps, tps;
    private int width, height;

    public static double currFPS = 120D;

    public Graphics2D graphics2D;
    public BufferedImage img;

    public GameLoop(int width, int height) {
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setFocusable(false);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        //INIT
        init();

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / currFPS;
        int frames = 0;
        int ticks = 0;
        long lastTimer = System.currentTimeMillis();
        double deltaTime = 0;

        while(running) {
            long now = System.nanoTime();
            deltaTime += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;

            while(deltaTime >= 1) {
                ticks++;
                //TICK + DELTATIME
                tick(deltaTime);

                deltaTime -= 1;
                shouldRender = true;
            }

            if(shouldRender) {
                frames++;
                //RENDER
                render();
            }

            try{Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

            if(System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                tps = ticks;
                fps = frames;
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void init() {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) img.getGraphics();
        running = true;

        gsm = new GameStateManager();
        gsm.init();
    }

    public void tick(double deltaTime) {
        gsm.tick(deltaTime);
    }

    public void render() {
        graphics2D.clearRect(0, 0, width, height);
        graphics2D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        graphics2D.fill(new Ellipse2D.Float(0, 0, getWidth(), getHeight()));
        gsm.render(graphics2D);
        clear();
    }

    public void clear() {
        Graphics g2 = getGraphics();
        if(img != null) {
            g2.drawImage(img, 0, 0, null);
        }
        g2.dispose();
    }

}