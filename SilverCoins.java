import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Gems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SilverCoins extends HUD
{
    /**
     * Act - do whatever the Gems wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        getWorld().showText(Integer.toString(hero.get(0).silverCoins()) + "X",930,90);
    }  
    
    public SilverCoins()
    {
        setImage("coinSilver.png");
        
    }
}
