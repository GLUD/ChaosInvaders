
package Juego;

import java.awt.image.ImageObserver;

public interface Etapa extends ImageObserver {
	public static final int WIDTH=800;
	public static final int HEIGHT=600;
	public static final int PLAY_HEIGHT = 500; 
	public static final int SPEED=10;
	public SpriteCache getSpriteCache();
	public SoundCache getSoundCache();
	public void addActor(Actor a);
	public Jugador getPlayer();
	public void gameOver();
}
