package ragnarok.powerups.magiastemporales;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.powerups.MagiaTemporal;

public class MTCongelarTiempo extends MagiaTemporal{
	
	public MTCongelarTiempo(Posicion pos) {
		super(pos);
		
		grafico = new Grafico(new Texture("img/heroe.jpg"));
		Posicion posicion = new Posicion(pos.getX(),pos.getY());
		grafico.setPosicion(posicion.getX(), posicion.getY());
		
	}
	
	public void activar() {
		System.out.println("Tiempo congelado");
	}

}
