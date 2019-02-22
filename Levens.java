import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Gems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levens extends HUD
{
    /**
     * Act - do whatever the Gems wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        getWorld().showText(Integer.toString(hero.get(0).lifes()) + "X",930,20);
    }  
    
    public Levens()
    {
        setImage("hud_heartFull.png");
        
    }
}
