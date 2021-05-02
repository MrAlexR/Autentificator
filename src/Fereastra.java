import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fereastra 
{
    public JFrame fereastra;
    public Logare pag_logare;
    public Creare pag_creare;
    public Profil pag_profil;
    
    Fereastra()
    {
	pag_logare = new Logare();
	pag_creare = new Creare();
	pag_profil = new Profil();
	fereastra = new JFrame();
	fereastra.add(pag_logare.container);
	
	pag_logare.creaza.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		pag_creare.reInit(new ProfilUtil(null, null, null, null, null));
		change(pag_logare, pag_creare, "Autentificator - Creare cont");
	     }
	});
	
	pag_logare.log.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 if(pag_logare.callback())
		 {
		     pag_profil.reInit(pag_logare.getProfile());
		     change(pag_logare, pag_profil, "Autentificator - Contul meu");
		 }
		     
	     }
	});
	
	pag_creare.back.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 if(pag_creare.edit_user_mode)
		 {
		     pag_profil.reInit(pag_creare.getProfile());
		     change(pag_creare, pag_profil, "Autentificator - Contul meu");
		     pag_creare.edit_user_mode = false;
		 }else
		 {
		     pag_logare.reInit();
		     change(pag_creare, pag_logare, "Autentificator - Logare");
		 }
	     }
	});
	
	pag_profil.bButton.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 pag_logare.reInit();
		 change(pag_profil, pag_logare, "Autentificator - Logare");
	     }
	});
	
	pag_profil.pButton.addActionListener(new ActionListener()
	{
	     public void actionPerformed(ActionEvent e)
	     {
		 pag_creare.edit_user_mode = true;
		 pag_creare.reInit(pag_profil.getProfile());
		 change(pag_profil, pag_creare, "Autentificator - Editare cont");
	     }
	});
    }
    
    public JFrame getWindow()
    {
	return fereastra;
    }
    
    public void change(MasterUI oldp, MasterUI newp, String wintit)
    {
	fereastra.setTitle(wintit);
	fereastra.remove(oldp.container);
	fereastra.add(newp.container);
	fereastra.repaint();
	fereastra.revalidate();
    }
}


