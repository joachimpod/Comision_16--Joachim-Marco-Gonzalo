package ragnarok.entidades.enemigos;

import com.badlogic.gdx.graphics.Texture;
import ragnarok.armas.ArmaEnemigo;
import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorEnemigoArmado;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueEArmado;
import ragnarok.inteligencia.movimientos.InteligenciaEArmado;
import ragnarok.principal.Juego;

public class EnemigoArmado extends Enemigo {
	
	public EnemigoArmado() {
		super();
		
		grafico = new Grafico(new Texture("img/enemigoarmado.jpg"));
	
		Posicion posicion = new Posicion(20,(Juego.ALTO-Juego.caminable)/2);
		grafico.setPosicion(posicion.getX(), posicion.getY());
		
		colisionador = new ColisionadorEnemigoArmado();
		
		inteligenciaMovimiento = new InteligenciaEArmado();
		
		inteligenciaAtaque = new InteligenciaAtaqueEArmado(arma);
	}
	
	public void actualizar() {
		mover();
		atacar();
	}
	
	protected void atacar() {
		inteligenciaAtaque.atacar(this);
	}

	public void serChocado(Colisionador col) {
		col.afectarEnemigoArmado(this);	
	}
}
