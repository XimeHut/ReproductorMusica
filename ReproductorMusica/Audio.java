import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio
{
	//Definir atributos 
	
	private File  				audioFile; //aqui ocupamos un package especial
	private AudioInputStream    audioStream;
	private Clip 				audioClip;
	
	//Definir el metodo reproducir 
	private void reproducir () throws Exception
	{
		//1.- Obtener el nombre de la cancion a reproducir 
		
		String song = "VengoDelFuturo.wav";
		
		//2.-Relacionar la cancion con un archuvo tipo File
		audioFile = new File (song); //el constructor es en base a un file o a un url 
		
		//3.-Crear un bufer en RAM para el audio stream
		audioStream = AudioSystem.getAudioInputStream(audioFile); //la calse AudioSystem tiene metodos que nos permiten utilizar el sistema de audio que tengamos en la computadora
		
		
		//4.-Reproducir la cancion 
		audioClip = AudioSystem.getClip();
		audioClip.open(audioStream);
		audioClip.start();
	}
	


	public static void main (String args[] ) throws Exception //control de errores o exception
		
	{
		Audio audio = new Audio ();
		
		audio.reproducir(); //metodo reproducir cancion 
		
	}
		
	
		
}