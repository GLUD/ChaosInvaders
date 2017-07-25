
package Juego;


public class Bomba extends Actor {
	public static final int UP_LEFT = 0;
	public static final int UP = 1;
	public static final int UP_RIGHT = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	public static final int DOWN_LEFT = 5;
	public static final int DOWN = 6;
	public static final int DOWN_RIGHT = 7;
	
	protected static final int BOMB_SPEED = 5; 
	protected int vx;
	protected int vy;
	
	public Bomba(Etapa stage, int partida, int x, int y) {
		super(stage);
		this.x = x;
		this.y = y;
		String sprite ="";
		switch (partida) {
			case UP_LEFT : vx = -BOMB_SPEED; vy = -BOMB_SPEED; sprite="bombUL.gif";break;
			case UP : vx = 0; vy = -BOMB_SPEED; sprite="bombU.gif";break;
			case UP_RIGHT: vx = BOMB_SPEED; vy = -BOMB_SPEED; sprite="bombUR.gif";break;
			case LEFT : vx = -BOMB_SPEED; vy = 0; sprite = "bombL.gif";break;
			case RIGHT : vx = BOMB_SPEED; vy = 0; sprite = "bombR.gif";break;
			case DOWN_LEFT : vx = -BOMB_SPEED; vy = BOMB_SPEED; sprite="bombDL.gif";break;
			case DOWN : vx = 0; vy = BOMB_SPEED; sprite = "bombD.gif";break;
			case DOWN_RIGHT : vx = BOMB_SPEED; vy = BOMB_SPEED; sprite = "bombDR.gif";break;
		}   
		setSpriteNombres( new String[] {sprite});
	}
	
    
    
	public void acto() {
		super.acto();
		y+=vy;
		x+=vx;
		if (y < 0 || y > Etapa.HEIGHT || x < 0 || x > Etapa.WIDTH)
		  eliminar();
	}
}