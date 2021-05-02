import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;
    
public class Logare extends MasterUI
{
    public JTextField email_i;
    public JTextField parola_i;
    public JLabel email_t;
    public JLabel parola_t;
    public JButton log;	
    public JButton creaza;	
    public JLabel picture_frame;
    public ProfilUtil profil;
    
    Logare()
    {
	profil = new ProfilUtil(null, null, null, null, null);
	picture_frame = new JLabel(Utilitati.resizeBaseImage("controller.png", 90, 90));
	picture_frame.setBounds(130, 20, 90, 90);
	
	container = new JPanel();
	container.setBackground(Color.decode("#17181b"));
	container.setLayout(null);
	
	email_t = new JLabel("Email");
	email_t.setForeground(Color.decode("#5f6368"));
	email_t.setFont(new Font("Verdana", 0, 20));
	email_t.setBounds(40, 90, 200, 50);
	
	email_i = new JTextField();
	email_i.setForeground(Color.decode("#5f6368"));
	email_i.setBackground(Color.decode("#17181b"));
	email_i.setFont(new Font("Verdana", 0, 20));
	email_i.setBounds(40, 130, 300, 50);
	email_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	
	parola_t = new JLabel("Parola");
	parola_t.setForeground(Color.decode("#5f6368"));
	parola_t.setFont(new Font("Verdana", 0, 20));
	parola_t.setBounds(40, 190, 200, 50);
	
	parola_i = new JTextField();
	parola_i.setForeground(Color.decode("#5f6368"));
	parola_i.setBackground(Color.decode("#17181b"));
	parola_i.setFont(new Font("Verdana", 0, 20));
	parola_i.setBounds(40, 230, 300, 50);
	parola_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	
	log = new JButton("LogIn");
	log.setBackground(Color.decode("#5f6368"));
	log.setBounds(40, 300, 150, 70);
	log.setFont(new Font("Verdana", 0, 20));
	
	creaza = new JButton("Creare");
	creaza.setBackground(Color.decode("#5f6368"));
	creaza.setBounds(200, 300, 150, 70);
	creaza.setFont(new Font("Verdana", 0, 20));
	
	container.add(email_t);
	container.add(parola_t);
	container.add(email_i);
	container.add(parola_i);
	container.add(log);
	container.add(creaza);
	container.add(picture_frame);
    }
    
    public boolean callback()
    {
	profil = Utilitati.getProfile(email_i.getText());
	if(profil == null)   
	{
	    email_t.setText("Email - Invalid");
	    email_t.setForeground(Color.red);
	    return false;
	}else {
	    email_t.setText("Email");
	    email_t.setForeground(Color.decode("#5f6368"));
	}
	
	if(!profil.parola.equals(parola_i.getText()))   
	{
	    parola_t.setText("Parola - Invalida");
	    parola_t.setForeground(Color.red);
	    return false;
	}else {
	    parola_t.setText("Parola");
	    parola_t.setForeground(Color.decode("#5f6368"));
	}
	
	return true;
    }
    
    public void reInit()
    {
	email_i.setText("");
	parola_i.setText("");
	
	email_t.setText("Email");
	parola_t.setText("Parola");
	
	email_t.setForeground(Color.decode("#5f6368"));
	parola_t.setForeground(Color.decode("#5f6368"));
    }
    
    public ProfilUtil getProfile()
    {
	return profil;
    }
}
    
    
    