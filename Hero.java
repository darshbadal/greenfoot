import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    boolean onGround;
    boolean coinGold= false;
    boolean coinSilver= false;
    int x = 84;
    int y = 973;
    boolean Key2;
    public int frame = 0;
    private int world = 0;
    private boolean toLevel2;
    private boolean toLevel3;
    static int wereld = 1;
    static int silverCoins;
    static int sleutels;
    public int goldCoins;
    static int lifes = 2;
    public boolean didde = false;

    public static int score=0;
     double doodegegaan;
     
     private CollisionEngine collisionEngine;
     private TileEngine tileEngine;
     

    public Hero(int world) {
        super();
        this.world = world;
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        gravity =15.0;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        getImage().scale(70, 70);                               
    }

    @Override
    public void act() {
        handleInput();
        eatKey();
        eatcoinGold();
        eatCoinSilver();
        doors();
        respawn();
        levensoptellen();
        
        silverCoins();
        lifes();
        sleutels();
        
        velocityX *= drag;
        velocityY += acc;
        
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        handleInput();
        getWorld().showText(getX() + "," + getY(),500,50);
        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                respawn();
                doodegegaan ++;
                break;
            }
        }
        for (Actor enemy : getIntersectingObjects(Death.class)) {
            if (enemy != null) {
                respawn();
                
                break;
            }
        }
    }
   
    
    public void levensoptellen() {
        if (silverCoins == 20) {
        silverCoins = silverCoins -20;
        lifes++;
        }
        if(lifes > 3) {
         lifes = 3;
        }
    }
    public int sleutels() {
        return sleutels;
    }
    
    public int silverCoins() {
        return silverCoins;
    }
    
    
    
    public int lifes() {
        return lifes;
        }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") /*&& (onGround() == true)*/) {
            //for(Actor Hero : getIntersectingObjects(Tile.class)){
                velocityY = -10;
                

            //}

        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -6;
            animatieLeft();
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 6;
            animatieRight();
        }
        
        if (Greenfoot.isKeyDown("Control") && (Greenfoot.isKeyDown("r"))) {



            Greenfoot.setWorld(new World1());

                Greenfoot.setWorld(new World1());



        }
            
    }
    
  public void death(){
        for(Actor hero : getIntersectingObjects(Death.class)){
            if(hero != null) {
                setLocation(x,y);
            }
        }
    }
  
  public boolean eatKey()

    {
        for(Actor key : getIntersectingObjects(Key2.class))

        {
            if(isTouching(Key2.class))

            {
                removeTouching(Key2.class);
                Key2= true;
                sleutels ++;
                break;
               
            }
        }
        return Key2;
    }
    
   

  public boolean eatKeys()

    {
        for(Actor key : getIntersectingObjects(Key3.class))

        {
            if(isTouching(Key3.class))

            {
                removeTouching(Key3.class);
                Key2= true;
                sleutels++;
                break;
            }
        }
        return Key2;
    }
    
  public boolean eatcoinGold()

    {
        for(Actor coinGolder : getIntersectingObjects(coinGoldTile.class))

        {
            if(isTouching(coinGoldTile.class))

            {
                removeTouching(coinGoldTile.class);
                coinGold= true;
                silverCoins = silverCoins + 2;
                break;
            }
        }
        return coinGold;
    }
  
public void doors() {
    if (isTouching(DoorTile1.class)) {
        switch(wereld)
        {
            case 1: 
            Greenfoot.setWorld( new World2());
            wereld = 2;
            break;
            case 2: 
            Greenfoot.setWorld ( new World3());
            wereld = 3;
            break;
            case 3:
            Greenfoot.setWorld ( new World4());
            wereld = 4;
            break;
            case 4:
            Greenfoot.setWorld ( new TitleScreen());
            break;
            default:
            break;
        }
        
    }
}

public void respawn() {
 if ( isTouching(Death.class)) {
     
     if( wereld == 1){
        setLocation(84, 986);
        
        doodegegaan= doodegegaan + 0.5;
        }
        if( wereld == 2){
        Greenfoot.setWorld(new World2());
        lifes --;
        }
        if( wereld == 3){
        Greenfoot.setWorld(new World3());
        lifes --;
        }
        if( wereld == 4){
        Greenfoot.setWorld(new World4());
        lifes --;
        }
     
    // switch(world)
      //  {
      //      case 0:
      //      Greenfoot.setWorld( new MyWorld());
      //      levens = levens -1;
      //      break;
      //      case 1: 
      //      Greenfoot.setWorld( new World2());
      //      levens = levens -1;
      //      break;
      //      case 2: 
      //      Greenfoot.setWorld ( new World3());
      //      levens = levens -1;
      //      break;
      //      case 3:
      //      Greenfoot.setWorld ( new World4());
      //      levens = levens -1;
      //      break;
      //      default:
      //      break;
      //  }
 /* if (levens = 0) {
  * Greenfoot.setWorld( new GameOver()); 
}
  */
 
    }
    
    if(doodegegaan == 1) {
        lifes = lifes - 1;
        doodegegaan = 0;
        
    }
}
    
  public boolean eatCoinSilver()

    {
        for(Actor coinSilver1 : getIntersectingObjects(coinSilverTile.class))

        {
            if(isTouching(coinSilverTile.class))

            {
                removeTouching(coinSilverTile.class);
                coinSilver= true;
                silverCoins ++;
                break;
            }
        }
        return coinGold;
    }
    
  public int getWidth() {
        return getImage().getWidth();
    }
  public int getHeight() {
        return getImage().getHeight();
    }
  public void animatieRight()
    {
        if(frame == 1 )
        {
            setImage("p1_walk01.png");
            getImage().scale(60, 70);
        }
        else if(frame == 2)
        {
            setImage("p1_walk02.png");
            getImage().scale(60, 70);
        }
        else if(frame == 3)
        {
            setImage("p1_walk03.png");
            getImage().scale(60, 70);
        }
        else if(frame == 4)
        {
            setImage("p1_walk04.png");
            getImage().scale(60, 70);
        }
        else if(frame == 5)
        {
            setImage("p1_walk05.png");
            getImage().scale(60, 70);
        }
        else if(frame == 6)
        {
            setImage("p1_walk06.png");
            getImage().scale(60, 70);
        }
        else if(frame == 7)
        {
            setImage("p1_walk07.png");
            getImage().scale(60, 70);
        }
        else if(frame == 8)
        {
            setImage("p1_walk08.png");
            getImage().scale(60, 70);
        }
        else if(frame == 9)
        {
            setImage("p1_walk09.png");
            getImage().scale(60, 70);
        }
        else if(frame == 10)
        {
            setImage("p1_walk10.png");
            getImage().scale(60, 70);
        }
        else if(frame == 11)
        {
            setImage("p1_walk11.png");
            getImage().scale(60, 70);
            frame = 0;
            return;
            
        }
        frame++;
    }
  public void animatieLeft()
    {
        if(frame == 1)
        {
            setImage("p1_walk010.png");
            getImage().scale(55, 70);
        }
        else if(frame == 2)
        {
            setImage("p1_walk020.png");
            getImage().scale(55, 70);
        }
        else if(frame == 3)
        {
            setImage("p1_walk030.png");
            getImage().scale(55, 70);
        }
        else if(frame == 4)
        {
            setImage("p1_walk040.png");
            getImage().scale(55, 70);
        }
        else if(frame == 5)
        {
            setImage("p1_walk050.png");
            getImage().scale(55, 70);
        }
        else if(frame == 6)
        {
            setImage("p1_walk060.png");
            getImage ().scale(55, 70);
        }
        else if(frame == 7)
        {
            setImage("p1_walk070.png");
            getImage().scale(55, 70);
        }
        else if(frame == 8)
        {
            setImage("p1_walk080.png");
            getImage().scale(55, 70);
        }
        else if(frame == 9)
        {
            setImage("p1_walk090.png");
            getImage().scale(55, 70);
        }
        else if(frame == 10)
        {
            setImage("p1_walk100.png");
            getImage().scale(55, 70);
        }
        else if(frame == 11)
        {
            setImage("p1_walk110.png");
            getImage().scale(55, 70);
            frame = 0;
            return;
        }
        frame++;
        
        
    }
    
    
}
