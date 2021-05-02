import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Utilitati
{
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException 
    {
	Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	resultingImage.flush();
	return outputImage;
    }
    
    public static ImageIcon resizeBaseImage(String image, int x, int y)
    {
	BufferedImage img = null;
	try {
	    img = ImageIO.read(new File(image));
	} catch (IOException e) {
	    return null;
	}
	
	return new ImageIcon(img.getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    public static String imagePath()
    {
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");
	    chooser.setFileFilter(filter);
	if(chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION)
	{
	    return chooser.getSelectedFile().getAbsolutePath();
	}
	return "";
    }
    
    public static boolean createProfile(boolean on_existing, ProfilUtil profil) 
    {
	File f = new File(profil.email + ".txt");
	FileOutputStream fout;
	if(f.exists() && !on_existing) return false;
	
	if(f.exists() && on_existing)
	{
	    try {
		PrintWriter deleter = new PrintWriter(f);
		deleter.close();
		Files.copy(Paths.get(profil.pozaP), Paths.get(profil.email + "P.png"), REPLACE_EXISTING);
		Files.copy(Paths.get(profil.pozaB), Paths.get(profil.email + "B.png"), REPLACE_EXISTING);
		fout = new FileOutputStream(f, true);
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(fout));
		writeToFile(profil, wr);
		wr.close();
		fout.close();
	    } catch (Exception e) {
		return false;
	    }
	    return true;
	}
	
	try {
	    if(!f.createNewFile())
		return false;
	    Files.copy(Paths.get(profil.pozaP), Paths.get(profil.email + "P.png"), REPLACE_EXISTING);
	    Files.copy(Paths.get(profil.pozaB), Paths.get(profil.email + "B.png"), REPLACE_EXISTING);
	    fout = new FileOutputStream(f, true);
	    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(fout));
	    writeToFile(profil, wr);
	    wr.close();
	    fout.close();
	}catch(Exception e) {return false;}
	
	return true;
    }
    
    public static void writeToFile(ProfilUtil profil, BufferedWriter wr) throws IOException
    {
	wr.write(profil.email);
	wr.newLine();
	wr.write(profil.parola);
	wr.newLine();
	wr.write(profil.detalii);
	wr.newLine();
	wr.write(profil.pozaP);
	wr.newLine();
	wr.write(profil.pozaB);
	wr.newLine();
	wr.close();
    }
    
    public static ProfilUtil getProfile(String profile_name)
    {
	ProfilUtil profil = new ProfilUtil(null, null, null, null, null);
	File f = new File(profile_name + ".txt");
	FileInputStream fin;
	if(!f.exists()) return null;
	
	try {
	    fin = new FileInputStream(f);
	    BufferedReader rr = new BufferedReader(new InputStreamReader(fin));
	    profil.email = rr.readLine();
	    profil.parola = rr.readLine();
	    profil.detalii = rr.readLine();
	    profil.pozaP = rr.readLine();
	    profil.pozaB = rr.readLine();
	    rr.close();
	    fin.close();
	}catch(Exception e) {return null;}
	return profil;
    }
}