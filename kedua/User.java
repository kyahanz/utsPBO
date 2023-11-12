package kedua;

public class User extends Pengguna{
    public User(String username, String pass){
        super(1);

        setUsername(username);
        setPass(pass);
    }
}