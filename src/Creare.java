import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
    
public class Creare extends MasterUI
{
    public JLabel email_t;
    public JLabel parola_t;
    public JLabel pozaP_t;
    public JLabel pozaB_t;
    public JLabel detalii_t;
    
    public JTextField email_i;
    public JTextField parola_i;
    public JTextField pozaP_i;
    public JTextField pozaB_i;
    public JTextField detalii_i;
    
    public JButton back;
    public JButton save;
    public JButton openExp1;
    public JButton openExp2;
    
    public ProfilUtil profil;
    public boolean edit_user_mode = false;
    
    Creare()
    {
	profil = new ProfilUtil(null, null, null, null, null);
	
	container = new JPanel();
	container.setBackground(Color.decode("#17181b"));
	container.setLayout(null);
	
	email_t = new JLabel("Email");
	email_t.setForeground(Color.decode("#5f6368"));
	email_t.setFont(new Font("Verdana", 0, 20));
	email_t.setBounds(40, 20, 300, 30);
	
	email_i = new JTextField();
	email_i.setForeground(Color.decode("#5f6368"));
	email_i.setBackground(Color.decode("#17181b"));
	email_i.setFont(new Font("Verdana", 0, 20));
	email_i.setBounds(40, 50, 300, 30);
	email_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	
	parola_t = new JLabel("Parola");
	parola_t.setForeground(Color.decode("#5f6368"));
	parola_t.setFont(new Font("Verdana", 0, 20));
	parola_t.setBounds(40, 80, 100, 30);
	
	parola_i = new JTextField(10);
	parola_i.setForeground(Color.decode("#5f6368"));
	parola_i.setBackground(Color.decode("#17181b"));
	parola_i.setFont(new Font("Verdana", 0, 20));
	parola_i.setBounds(40, 110, 300, 30);
	parola_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	
	pozaP_t = new JLabel("Poza de profil");
	pozaP_t.setForeground(Color.decode("#5f6368"));
	pozaP_t.setFont(new Font("Verdana", 0, 20));
	pozaP_t.setBounds(40, 140, 150, 30);
	
	pozaP_i = new JTextField();
	pozaP_i.setForeground(Color.decode("#5f6368"));
	pozaP_i.setBackground(Color.decode("#17181b"));
	pozaP_i.setFont(new Font("Verdana", 0, 20));
	pozaP_i.setBounds(40, 170, 200, 30);
	pozaP_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	pozaP_i.setEditable(false);
	
	pozaB_t = new JLabel("Poza de fundal");
	pozaB_t.setForeground(Color.decode("#5f6368"));
	pozaB_t.setFont(new Font("Verdana", 0, 20));
	pozaB_t.setBounds(40, 200, 150, 30);
	
	pozaB_i = new JTextField();
	pozaB_i.setForeground(Color.decode("#5f6368"));
	pozaB_i.setBackground(Color.decode("#17181b"));
	pozaB_i.setFont(new Font("Verdana", 0, 20));
	pozaB_i.setBounds(40, 230, 200, 30);
	pozaB_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	pozaB_i.setEditable(false);
	
	detalii_t = new JLabel("Detalii profil");
	detalii_t.setForeground(Color.decode("#5f6368"));
	detalii_t.setFont(new Font("Verdana", 0, 20));
	detalii_t.setBounds(40, 260, 150, 30);
	
	detalii_i = new JTextField();
	detalii_i.setForeground(Color.decode("#5f6368"));
	detalii_i.setBackground(Color.decode("#17181b"));
	detalii_i.setFont(new Font("Verdana", 0, 20));
	detalii_i.setBounds(40, 290, 300, 30);
	detalii_i.setBorder(new LineBorder(Color.decode("#5f6368"), 1));
	
	back = new JButton("Anulare");
	back.setBackground(Color.decode("#5f6368"));
	back.setBounds(50, 360, 100, 50);
	
	save = new JButton("Salvare");
	save.setBackground(Color.decode("#5f6368"));
	save.setBounds(160, 360, 100, 50);
	save.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 if(checkData())
		 {
		     if(!Utilitati.createProfile(edit_user_mode, profil))
		     {
			 email_t.setForeground(Color.red);
			 email_t.setText("Email - Exista sau eroare!");
		     }else 
		     {
			 email_t.setText(edit_user_mode ? "Email - Salvat" : "Email - Creat cu succes!");
		     }
		 }
	     }
	});
	
	openExp1 = new JButton("Open");
	openExp1.setBackground(Color.decode("#5f6368"));
	openExp1.setBounds(250, 170, 80, 30);
	openExp1.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 pozaP_i.setText(Utilitati.imagePath());
	     }
	});
	
	openExp2 = new JButton("Open");
	openExp2.setBackground(Color.decode("#5f6368"));
	openExp2.setBounds(250, 230, 80, 30);
	openExp2.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 pozaB_i.setText(Utilitati.imagePath());
	     }
	});
	
	container.add(email_t);
	container.add(parola_t);
	container.add(email_i);
	container.add(parola_i);
	container.add(pozaP_t);
	container.add(pozaP_i);
	container.add(pozaB_t);
	container.add(pozaB_i);
	container.add(detalii_t);
	container.add(detalii_i);
	container.add(back);
	container.add(save);
	container.add(openExp1);
	container.add(openExp2);
    }
    
    public boolean checkData()
    {
	int er = 0;
	if(email_i.getText().trim().equals("") || email_i.getText().contains(" "))
	{
	    email_t.setForeground(Color.red);
	    er++;
	} else {
	    email_t.setForeground(Color.decode("#5f6368"));
	    profil.email = email_i.getText();
	}
	
	if(parola_i.getText().length() == 0 || parola_i.getText().contains(" "))
	{
	    parola_t.setForeground(Color.red);
	    er++;
	} else {
	    parola_t.setForeground(Color.decode("#5f6368"));
	    profil.parola = parola_i.getText();
	}
	
	if(detalii_i.getText().trim().equals(""))
	{
	    detalii_t.setForeground(Color.red);
	    er++;
	} else {
	    detalii_t.setForeground(Color.decode("#5f6368"));
	    profil.detalii = detalii_i.getText();
	}
	
	if(pozaP_i.getText().trim().equals(""))
	{
	    pozaP_t.setForeground(Color.red);
	    er++;
	} else {
	    pozaP_t.setForeground(Color.decode("#5f6368"));
	    profil.pozaP = pozaP_i.getText();
	}
	
	if(pozaB_i.getText().trim().equals(""))
	{
	    pozaB_t.setForeground(Color.red);
	    er++;
	} else {
	    pozaB_t.setForeground(Color.decode("#5f6368"));
	    profil.pozaB = pozaB_i.getText();
	}
	
	if(er > 0) return false;
	return true;
    }
    
    public void reInit(ProfilUtil profil)
    {
	this.profil = profil;
	email_i.setText(profil.email);
	parola_i.setText(profil.parola);
	detalii_i.setText(profil.detalii);
	pozaP_i.setText(profil.pozaP);
	pozaB_i.setText(profil.pozaB);
	
	email_t.setForeground(Color.decode("#5f6368"));
	parola_t.setForeground(Color.decode("#5f6368"));
	detalii_t.setForeground(Color.decode("#5f6368"));
	pozaP_t.setForeground(Color.decode("#5f6368"));
	pozaB_t.setForeground(Color.decode("#5f6368"));
	
	email_t.setText(edit_user_mode ? "Email (necesita recreare)" : "Email");
	email_i.setEditable(!edit_user_mode);
    }
    
    public ProfilUtil getProfile()
    {
	return profil;
    }
}

