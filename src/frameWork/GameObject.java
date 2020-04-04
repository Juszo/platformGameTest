package frameWork;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject
{
    //protected- tylko klasy pochodne widzą
    protected float x,y;
    protected ObjectId id; //
    protected float velX=0, velY=0;

    public GameObject(float x, float y, ObjectId id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void thick(LinkedList<GameObject> object); //bedzie potrzebne przy kolizjach?
    public abstract void render(Graphics g);

    public abstract float getX();
    public abstract float getY();
    public abstract void setX(float x);
    public abstract void setY(float y);

    public abstract float geVelX();
    public abstract float getVelY();
    public abstract void setVelX(float velX);
    public abstract void setVelY(float velY);

    public abstract ObjectId getId();


}
