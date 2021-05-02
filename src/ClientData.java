public class ClientData
{
    public String Username;
    public String Password;
    public String Details;
    public String BgImgPath;
    public String PfImgPath;
    
    ClientData(String un, String pwd, String dt, String bi, String pi)
    {
	Username = un;
	Password = pwd;
	Details = dt;
	BgImgPath = bi;
	PfImgPath = pi;
    }
}