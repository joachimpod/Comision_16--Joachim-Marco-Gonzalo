package ragnarok.disparos;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorDisparoHeroe;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaDHeroe;

public class Flecha extends Disparo{
	
	public Flecha (Posicion pos,int daño) {
		super();
		
		colisionador = new ColisionadorDisparoHeroe(daño);
		
		grafico = new Grafico(new Texture("img/arma1.jpg"));
		
		grafico.setPosicion(pos.getX()+grafico.getAncho(), pos.getY());
		
		velocidad = 5;
		
		inteligenciaMovimiento = new InteligenciaDHeroe();
	}
	
	public void serChocado(Colisionador col) {
		col.afectarDisparoJugador(this);
	}
}
