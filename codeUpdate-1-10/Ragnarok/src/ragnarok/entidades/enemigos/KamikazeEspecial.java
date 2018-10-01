package ragnarok.entidades.enemigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.movimientos.InteligenciaKBuscador;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;

public class KamikazeEspecial extends Kamikaze {
	
	private boolean estaMareado;
	
	public KamikazeEspecial() {
		super();
		
		grafico = new Grafico(new Texture("img/kespecial.jpg"));
		
		inteligenciaMovimiento = new InteligenciaKBuscador();
		
		estaMareado=false;
	}
	
	public void mover() {
		if (vida<=vidaMax*0.5 && !estaMareado) {
			inteligenciaMovimiento = new InteligenciaKMareado();
			estaMareado = true;
		}
		inteligenciaMovimiento.mover(this);
	}
}