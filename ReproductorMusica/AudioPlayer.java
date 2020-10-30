import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AudioPlayer extends JFrame implements ActionListener


{
	private JTextField tfSong;
	private JButton		bPlay, bStop ,bAlbum;
	private JLabel 		lbSong;
	private JPanel		panel1,panel2;
	private JTextArea   taCanciones;
	
	private boolean cancion=false;
	
	private Audio2 audio = new Audio2();
	private ShowDir showDir = new ShowDir();
	
   public AudioPlayer()
   	{ //contructor
   	super ("Reproductor de Audio Wav");
   	
   	//1.- Crear los objetos de los atributos
   	tfSong = new JTextField();
   	bPlay = new JButton ("Play");
   	bStop = new JButton ("Stop");
   	bAlbum = new JButton ("Canciones");
   	lbSong = new JLabel ("Now Playing: ");
   	taCanciones = new JTextArea (10,20);
   	panel1= new JPanel();
   	panel2= new JPanel();
   	
   	//poner botones a funcionar
   	bPlay.addActionListener(this);
   	bStop.addActionListener(this);
   	bAlbum.addActionListener(this);
   	
   	//2.- Definir los Layouts para los panels 
   	
   	panel1.setLayout(new GridLayout(3,2));
   	panel2.setLayout (new FlowLayout());
  
   	
   	//3.- Colocar los atributos en los paneles correspondientes
   	panel1.add(new JLabel("Cancion a Reproducir:"));
   	panel1.add(tfSong);
   	panel1.add(bPlay);
   	panel1.add(bStop);
   	panel1.add(bAlbum);
   	
   	
   	panel2.add(panel1);
   	panel2.add(lbSong);
   	panel2.add(new JScrollPane(taCanciones));
 
   	
   	//hacer visible el JFrames
   	add(panel2);
   	setSize(300,315);
   	setVisible(true);
   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para cerrar con el tache rojo 
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	String respuesta=""; 
    	String canciones ="";//inicializar variable
    	
    	if(event.getSource() == bPlay)
    	{
    	
    		//1.-Obtener de tfSong el nombre de la cancion
    		String song = tfSong.getText();
    		
    		//2.-Reproducir la cancion con Audio2
    		respuesta = audio.reproducir(song);
    		
    		lbSong.setText(respuesta);
    	}
    		
    	if(event.getSource() == bStop)
    	{
    		audio.stop();
    	}
    	
    	if (event.getSource() == bAlbum)
    	{
    		canciones = showDir.directorio();
    		
    		taCanciones.setText(canciones);
    	}
    		
    }
    	
    public static void main (String args[])
    	
    {
    	AudioPlayer audioPlayer = new AudioPlayer();
    }	
}