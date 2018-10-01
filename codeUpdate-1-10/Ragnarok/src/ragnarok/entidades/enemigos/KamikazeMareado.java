package ragnarok.entidades.enemigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;

public class KamikazeMareado extends Kamikaze {
	
	public KamikazeMareado() {
		super();
		
		grafico = new Grafico(new Texture("img/kmareado.jpg"));

		inteligenciaMovimiento = new InteligenciaKMareado();
	}
}
