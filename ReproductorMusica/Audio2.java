import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio2
{
	//Definir atributos

	private File  				audioFile; //aqui ocupamos un package especial
	private AudioInputStream    audioStream;
	private Clip 				audioClip;

	//Definir el metodo reproducir
	public String reproducir (String song)
	{

		String respuesta="Now Playing:\n";

		String pathSongs = "C:\\Users\\Xime HQ\\Documents\\SEGUNDO_SEMESTRE\\POO\\SegundoParcial\\ReproductorMusica\\CancionesWav\\";

		try{


		//1.- Obtener el nombre de la cancion a reproducir  la cancion llega de
		//String song = "Lazarus.wav";

		//2.-Relacionar la cancion con un archuvo tipo File
		audioFile = new File (pathSongs + song + ".wav"); //el constructor es en base a un file o a un url , lo va buscar en el path que yo le estpu dando , lo estamos concatenando
		System.out.println(audioFile);           //aqui adicionamos el punto wav para que el ususrio ya no lo tenga que poner

		//3.-Crear un bufer en RAM para el audio stream
		audioStream = AudioSystem.getAudioInputStream(audioFile); //la calse AudioSystem tiene metodos que nos permiten utilizar el sistema de audio que tengamos en la computadora


		//4.-Reproducir la cancion
		audioClip = AudioSystem.getClip();
		audioClip.open(audioStream);
		//while(true)
		audioClip.start();
		respuesta = respuesta + song;

		}

		catch(Exception e)
		{
			respuesta = respuesta + "Song NOT FOUND";
			System.out.println("Error: "+e);
		}
		return respuesta;
	}


		public void stop() //metodo stop
		{
			audioClip.stop();
		}
	}
