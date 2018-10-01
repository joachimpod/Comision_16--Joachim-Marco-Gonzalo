package ragnarok.powerups;

import ragnarok.graficos.Posicion;

public abstract class MagiaTemporal extends PowerUp {
	protected int timer;
	protected int timerMax;
	
	public MagiaTemporal(Posicion pos) {
		super(pos);
		timer = 0;
	}
	
}
