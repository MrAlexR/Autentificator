import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
    
public class Profil extends MasterUI
{
    public JButton pButton;
    public JButton bButton;
    
    public JLabel pPicture;
    public JLabel bPicture;
    
    public JLabel username;
    public JTextArea detalii;
    
    public ProfilUtil profil;
    
    Profil()
    {
	profil = new ProfilUtil(null, null, null, null, null);
	username = new JLabel("");
	username.setForeground(Color.MAGENTA);
	username.setBounds(100, 145, 100, 50);
	username.setFont(new Font("Verdana", 0, 20));
	
	detalii = new JTextArea("");
	detalii.setForeground(Color.MAGENTA);
	detalii.setBackground(Color.decode("#17181b"));
	detalii.setBounds(40, 220, 320, 140);
	detalii.setFont(new Font("Verdana", 0, 20));
	
	pButton = new JButton("Editare");
	pButton.setBackground(Color.decode("#5f6368"));
	pButton.setBounds(70, 360, 100, 50);
	pButton.setFont(new Font("Verdana", 0, 15));
	
	container = new JPanel();
	container.setBackground(Color.decode("#17181b"));
	container.setLayout(null);
	
	bPicture = new JLabel(Utilitati.resizeBaseImage("sunset.jpg", 400, 200));
	bPicture.setBounds(0, 0, 400, 200);
	pPicture = new JLabel(Utilitati.resizeBaseImage("student.png", 90, 90));
	pPicture.setBounds(0, 100, 90, 90);
	
	pButton = new JButton("Editare");
	pButton.setBackground(Color.decode("#5f6368"));
	pButton.setBounds(70, 360, 100, 50);
	pButton.setFont(new Font("Verdana", 0, 15));
	
	bButton = new JButton("LogOut");
	bButton.setBackground(Color.decode("#5f6368"));
	bButton.setBounds(190, 360, 100, 50);
	bButton.setFont(new Font("Verdana", 0, 15));
	
	container.add(detalii);
	container.add(username);
	container.add(pButton);
	container.add(bButton);
	container.add(pPicture);
	container.add(bPicture);
    }
    
    public void reInit(ProfilUtil profil)
    {
	this.profil = profil;
	username.setText(profil.email);
	detalii.setText("Despre mine:\n" + profil.detalii);
	//pPicture.setIcon(Utilitati.resizeBaseImage(profil.pozaP, 90, 90));
	//bPicture.setIcon(Utilitati.resizeBaseImage(profil.pozaB, 400, 200));
    }
    
    public ProfilUtil getProfile()
    {
	return profil;
    }
}