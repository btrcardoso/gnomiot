package gnomIoT.entities;

public class Tomada extends Dispositivo{
	
	public Tomada(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.TOMADA);
         this.setImageEstadoOff("/tomadaOff.png");
	 	this.setImageEstadoOn("/tomadaOn.png");
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (Tomada)super.clone();
    }
	
}
