package kedua;

import java.util.List;

public abstract class Pengguna {
    private String username;
    private String pass;
    private final int privilege;
    public Pengguna(int privilege){
        this.privilege = privilege;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public int getPrivilege () {
        return privilege;
    }

    public void setPass (String pass) {
        this.pass = pass;
    }
    public Boolean checkCredentials(String username, String pass){
        return username.equals(this.username) && pass.equals(this.pass);
    }

    public void getDaftarBuku(List<Buku> db){
        for (int i=0; i<db.size();i++){
            System.out.println((i+1) + ".");
            System.out.println("Judul: " + db.get(i).getTitle());
            System.out.println("\tGenre: " + db.get(i).getGenre() + "\n");
        }
    }
    public int getDaftarBukuByGenre(List<Buku> db, String[] genre){    
        String left = "";
        String right = "";
        for (int i=0; i<db.size(); i++){                        
            boolean temp = true;                                
            for (int j=0; j< genre.length; j++){
                for (int k=0; k<db.get(i).getRawGenre().length; k++){
                    boolean val = genre[j].equalsIgnoreCase(db.get(i).getRawGenre()[k]);
                    if(val){
                        temp = temp && val;
                        break;
                    }else if(k == db.get(i).getRawGenre().length-1){
                        temp = false;
                        break;
                    }
                }
                if(!temp) break;
            }
            if(temp) left += i;
            else right += i;
        }
        String index = left + right;
        for (int i=0; i<db.size(); i++){                       
            System.out.println((i+1) + ".");
            System.out.println("Judul: " + db.get(Integer.parseInt(String.valueOf(index.charAt(i)))).getTitle());
            System.out.println("\tGenre: " + db.get(Integer.parseInt(String.valueOf(index.charAt(i)))).getGenre() + "\n");
        }
        return left.length();
    }
}