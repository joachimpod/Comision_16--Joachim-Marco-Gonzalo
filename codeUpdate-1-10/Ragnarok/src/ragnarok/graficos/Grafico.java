package ragnarok.graficos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Grafico {
	
	private float alto;
	private float ancho;
	private Sprite sprite;
	private Hitbox hitbox;
	private Posicion posicion;
	
	public Grafico(Texture t) {
		
		posicion = new Posicion();
		
		sprite = new Sprite(t);
		alto = sprite.getHeight();
		ancho = sprite.getWidth();
		
		sprite.setPosition(posicion.getX(), posicion.getY());
		
		float xMax = posicion.getX()+ancho;
		float xMin = posicion.getX();
		float yMax = posicion.getY()+alto;
		float yMin = posicion.getY();
		
		hitbox = new Hitbox(xMax,xMin,yMax,yMin);
		
	}
	
	public float getAlto() {
		return alto;
	}
	
	public float getAncho() {
		return ancho;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public boolean colisiona(Grafico g) {
		actualizarHitbox();
		return hitbox.colisiona(g.getHitbox());
	}
	
	private void actualizarHitbox() {
		hitbox.actualizar(posicion.getX(),posicion.getY(),alto,ancho);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(float x,float y) {
		posicion.setPos(x, y);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
}
