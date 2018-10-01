package ragnarok.obstaculos;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorObstaculo;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Grafico;

public class Obstaculo extends Entidad {
	
	protected int vida;
	private final int vidaMax = 125;
	
	public Obstaculo() {
		
		colisionador = new ColisionadorObstaculo();
		
		grafico = new Grafico(new Texture("img/obstaculo.jpg"));
		
		vida = 125;
	}

	public void actualizar() {}

	public void serChocado(Colisionador col) {
		col.afectarObstaculo(this);
		
	}
}
