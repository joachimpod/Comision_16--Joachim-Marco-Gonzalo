package ragnarok.entidades.enemigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ragnarok.armas.ArmaKamikaze;
import ragnarok.colisiones.ColisionadorKamikaze;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueKamikaze;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;


public class EnemigoArmadoEspecial extends EnemigoArmado {
	
	private boolean mareado;
	private int vidaMax = 80;
	
	public EnemigoArmadoEspecial() {
		super();
		mareado = false;
		grafico = new Grafico(new Texture("img/enemigoarmadoespecial.jpg"));
	}
	
	protected void mover() {
		if (!mareado && vida<=vidaMax*0.20) {
			inteligenciaMovimiento = new InteligenciaKMareado();
			arma = new ArmaKamikaze();
			inteligenciaAtaque = new InteligenciaAtaqueKamikaze(arma);
			colisionador = new ColisionadorKamikaze(arma.getDaño());
			mareado = true;
		}
		inteligenciaMovimiento.mover(this);
	}
}
