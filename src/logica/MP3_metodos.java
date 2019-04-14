package logica;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class MP3_metodos {
    int duration=0;
    //int tiempo=0;
    private Player player;//obcjeto del tipo player de jl 1.0
    //reproducir mp3
    Thread repro=new Thread () {//es un hilo 
            public void run() {
                try { 
                    player.play();
                    }
                catch (Exception e) { System.out.println(e); }
            }
        };
    public void reproducir(String ruta){               
        try {
            //lee el archivo
            FileInputStream fis = new FileInputStream(ruta);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);//inicializa el player con la cancion           
            AudioFile audioFile = AudioFileIO.read(new File(ruta));
            duration= audioFile.getAudioHeader().getTrackLength();
            }
        catch (Exception e) {
            System.out.println("Problem playing file");
            System.out.println(e);
        }
    }
    
    public void close() { if (player != null) repro.stop();player.close(); }

}
