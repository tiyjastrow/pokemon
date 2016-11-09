import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pikachu extends Pokemon
{
    public Pikachu() 
    {
        name = "Pikachu";
        health = 100;
        damage = 10;
        aliveImage = "pikachu-alive.png";
        deadImage = "pikachu-dead.png";
    }

    protected void battle(Pokemon enemy) {
        if (health <= 0 || enemy.health <= 0) {
        return;
        }
        health -= enemy.damage;
        enemy.health -= damage;
        getWorld().showText(name + "'s health " + health, 10, 5);
        getWorld().showText(enemy.name + "'s health " + enemy.health, 10, 10);
        
        if (enemy.health <= 0) {
            showPokemonDead(enemy);
        }
        if (health <= 0) {
            showPokemonDead(this);
        }
   }

   void showPokemonDead(Pokemon pokemon) {
      getWorld().showText(pokemon.name + " has died", 10, 15);
      pokemon.setImage(pokemon.deadImage);
      getWorld().repaint();
   }

    
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        int x = getX();
        int y = getY();

        if (Greenfoot.isKeyDown("right")) {
            setLocation(x+1,y);
        } else if (Greenfoot.isKeyDown("left")) {
            setLocation(x-1,y);
        } else if (Greenfoot.isKeyDown("up")) {
            setLocation(x,y-1);
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation(x,y+1);
        } 
    
        Actor actor = getOneObjectAtOffset(0, 0, Pokemon.class);
        if (actor == null) {
            // do nothing
        } else {
            battle((Pokemon)actor);        
        }

   }
    
}
