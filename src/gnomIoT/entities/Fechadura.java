package gnomIoT.entities;

public class Fechadura extends Dispositivo{
	
	public Fechadura(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.FECHADURA);
        this.setImageEstadoOff("/trancaOff.png");
		this.setImageEstadoOn("/trancaOn.png");
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (Fechadura)super.clone();
    }
}
