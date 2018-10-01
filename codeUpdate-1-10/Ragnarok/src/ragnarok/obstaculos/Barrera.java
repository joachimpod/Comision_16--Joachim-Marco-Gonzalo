package ragnarok.obstaculos;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.graficos.Grafico;

public class Barrera extends Obstaculo {
	
	private final int vidaMax = 75;
	public Barrera() {
		super();
		
		grafico = new Grafico(new Texture("img/barrera.jpg"));
		
		vida = 75;
	}
}
