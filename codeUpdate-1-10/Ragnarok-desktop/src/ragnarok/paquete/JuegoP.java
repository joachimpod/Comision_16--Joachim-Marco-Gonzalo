package ragnarok.paquete;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.disparos.Disparo;
import ragnarok.entidades.Entidad;
import ragnarok.entidades.Heroe;
import ragnarok.graficos.Posicion;

public class JuegoP implements ApplicationListener {
	
	public static int ANCHO;
	public static int ALTO;
	
	SpriteBatch batch;
	Texture fondo;
	
	//Inicia el juego
	public void create() {
		ANCHO = Gdx.graphics.getWidth();
		ALTO = Gdx.graphics.getHeight()-150;
		
		batch = new SpriteBatch();
		//Fondo inicial
		fondo = new Texture("img/fondos/inicio.jpg");

	}
	
	//Metodo que se ejecuta continuamente
	public void render() {
		batch.begin();
		batch.draw(fondo,0,0);
		batch.end();
	}
	
	
	public void resize(int ancho, int alto) {}
	//Pausa la app
	public void pause() {}
	//Resume la app
	public void resume() {}
	public void dispose() {}
}