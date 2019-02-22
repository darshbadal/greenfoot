import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    private boolean onetime = true;
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (onetime == true ){
        onetime = false;
        getWorld().addObject(new Levens(),960,20);
        getWorld().addObject(new Sleutels(), 960, 55);
        getWorld().addObject(new SilverCoins(), 960, 90);
    }
        
    }    
}
