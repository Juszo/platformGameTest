package objects;

import frameWork.GameObject;
import frameWork.ObjectId;

import java.awt.*;
import java.util.LinkedList;
//Jezeli do tej klasy dodamy abstract nie musimy inicjalizować wszystkich
//metod jej funkcji macierzystej.
public class Test extends GameObject
{
    Test(float x, float y, ObjectId id) { super(x,y,id); }

    public void thick(LinkedList<GameObject> object)
    {

    }

    public void render(Graphics g)
    {

    }

    public float getX() { return this.x; }

    public float getY() { return this.y; }

    public void setX(float x) { this.x = x; }

    public void setY(float y) { this.y =y; }

    public float geVelX()  { return this.velX; }

    public float getVelY() { return this.velY; }

    public void setVelX(float velX)  { this.velX = velX; }

    public void setVelY(float velY) { this.velY = velY; }

    public ObjectId getId() { return id; }
}
