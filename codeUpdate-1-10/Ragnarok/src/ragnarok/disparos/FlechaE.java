package ragnarok.disparos;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorDisparoEnemigo;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaDEnemigo;

public class FlechaE extends Disparo{
	
	public FlechaE (Posicion pos,int daño) {
		super();
		
		colisionador = new ColisionadorDisparoEnemigo(daño);
	
		
		grafico = new Grafico(new Texture("img/arma1.jpg"));
		
		grafico.setPosicion(pos.getX()-grafico.getAncho(), pos.getY());
		
		velocidad = 5;
		
		inteligenciaMovimiento = new InteligenciaDEnemigo();
	}

	public void serChocado(Colisionador col) {
		col.afectarDisparoEnemigo(this);
	}
}
