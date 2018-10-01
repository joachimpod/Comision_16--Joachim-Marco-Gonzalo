package ragnarok.principal;

import java.util.LinkedList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.colisiones.Colisionador;
import ragnarok.entidades.Entidad;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.KamikazeEspecial;

public class Juego implements ApplicationListener {
	
	public static int ANCHO = 800;
	public static int ALTO = 600;
	
	public static int caminable = 150;
	
	private SpriteBatch batch; int i = 0;
	private Texture fondo;
	private Sprite sEntidad;
	
	private Mapa mapa;
	
	private Sprite corazones;
	
	public void create() {
		mapa = Mapa.getMapa();
		ANCHO = Gdx.graphics.getWidth();
		ALTO = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		
		fondo = new Texture("img/fondos/fondo1a.jpg");
				
		corazones = new Sprite(new Texture("img/hud/corazones/vida100.png"));
		
		iniciarHud();
		
		posicionesIniciales();
		

	}
	
	public void render() {
		actualizarVida();
		
		colisionar();
		
		actualizarEntidades();
		
		dibujarBatch();
		
		checkNivel();
	
		eliminarEntidades(crearListaBasura());
	}
	
	private void checkNivel() {
		if (mapa.getHeroe().getVida() <= 0) {
			mapa.resetearNivel();
		}
		else {
			if (mapa.cantEntidades()==1) {
				mapa.subirNivel();
			}
		}
	}
	
	private void colisionar() {
		for (Entidad x:mapa.getEntidades()) {
			for (Entidad y: mapa.getEntidades()) {
				if (x!=y && x.colisiona(y)) {
					x.colisionar(y);
				}
			}
		}
	}
	
	private LinkedList<Entidad> crearListaBasura() {
		LinkedList<Entidad> lista = new LinkedList<Entidad>();
		for(Entidad e:mapa.getEntidades()) {
			if (e.estaEliminado() || estaFuera(e)) {
				lista.addLast(e);
			}
		}
		return lista;
	}
	
	private boolean estaFuera(Entidad e) {
		boolean fuera = false;
		float x = e.getPos().getX();
		float y = e.getPos().getY();
		if (x < -50 || x > Juego.ANCHO+50 || y > Juego.ALTO+50 || y < -50) {
			fuera = true;
		}
		return fuera;
	}
	
	private void eliminarEntidades(LinkedList<Entidad> lista) {
		for (Entidad e:lista) {
			mapa.getEntidades().remove(e);
		}
	}
	
	private void actualizarEntidades() {
		for (Entidad entidad:mapa.getEntidades()) {
			entidad.setPosHeroe(mapa.getHeroe().getPos());
			entidad.actualizar();
			sEntidad = entidad.getGrafico().getSprite();
			sEntidad.setPosition(entidad.getPos().getX(), entidad.getPos().getY());
		}
	}
	
	private void dibujarBatch() {
		batch.begin();
		batch.draw(fondo,0,0);
		for (Entidad entidades:mapa.getEntidades()) {
			sEntidad = entidades.getGrafico().getSprite();
			batch.draw(sEntidad,sEntidad.getX(),sEntidad.getY());
		}
		batch.draw(corazones,corazones.getX(),corazones.getY());
		batch.end();
	}
	
	private void posicionesIniciales() {
		for (Entidad entidad:mapa.getEntidades()) {
			sEntidad = entidad.getGrafico().getSprite();
			sEntidad.setPosition(entidad.getPos().getX(), entidad.getPos().getY());
		}
	}
	
	private void iniciarHud() {
		corazones.setPosition(10, Juego.ALTO-corazones.getHeight()-10);
	}
	
	private void actualizarVida() {
		int vida = mapa.getHeroe().getVida()/10;
		vida*=10;
		if ( vida <= 0) vida = 0;
		String imagenVida = "img/hud/corazones/vida"+vida+".png";
		corazones.setTexture(new Texture(imagenVida));
	}
	
	public void resize(int ancho, int alto) {}
	//Pausa la app
	public void pause() {}
	//Resume la app
	public void resume() {}
	public void dispose() {}
}
