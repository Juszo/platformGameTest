package window;

import frameWork.GameObject;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
    private boolean running = false;
    private Thread thread;//tworzymy nowy wątek


    public synchronized void start()
    {
        if(running) {return;}//jeżeli z jakiegos powodu znowu się wykona nie rozpocznie nowego watku
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public void run()
    {//Game loop - serce gry
        long lastTime = System.nanoTime();
        double amountOfThicks = 60.0; // tyle razy wywoła tick() na sekunde czyli fps=60
        double ns = 1000000000/amountOfThicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while (delta >= 1)
            {
                tick();//uaktualnia
                updates++;
                delta--;
            }
            render();//renderuje tak szybko jak da rade
            frames++;
            if(System.currentTimeMillis()-timer>1000)
            {
                timer+=1000;
                System.out.println("FPS:"+ frames+" TICKS:"+updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    private void tick()//uaktualnienie
    {

    }
    private void render()//grafika
    {
        /*BufferStrategy -(Buffory) powoduje, że gdy załaduje nam się aktualny obraz i komputer
        będzie miał jeszcze czas to załaduje kolejny obraz, który jak się skończy czas aktualnego
        obrazu to wyświetli czekający obraz.
        Do 3 czekających obrazow więcej zazwyczaj komputery nie sa w stanie
        W skrócie tworzy kolejkę obrazów.
         */
        //tworzymy aby zmniejszyć ilość FPS
        BufferStrategy bs = this.getBufferStrategy();//this odwołuje się do Canvas
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics(); //graficzny kontekst dla bufforow
        //od tego miejsca rysujemy wszystko w grze

        //Draw here
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());

        //do tego miejsca rysujemy wszystko w grze
        g.dispose();
        bs.show();

    }
     public static void main(String args[])
     {
         new Window(800,600,"Game Prototype", new Game());

     }
}
