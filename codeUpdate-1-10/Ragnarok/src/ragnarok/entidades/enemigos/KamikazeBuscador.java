package ragnarok.entidades.enemigos;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaKBuscador;

public class KamikazeBuscador extends Kamikaze{
	
	public KamikazeBuscador() {
		super();
		
		grafico = new Grafico(new Texture("img/kbuscador.jpg"));
		
		inteligenciaMovimiento = new InteligenciaKBuscador();
	}
}
