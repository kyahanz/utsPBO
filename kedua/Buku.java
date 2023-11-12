package kedua;

public class Buku {
    private String title;
    private String[] genre;

    public Buku(String title, String[] genre){
        this.title = title;
        this.genre = genre;
    }

    public String getTitle () {
        return title;
    }

    public String getGenre () {
        String res = "";
        for (int i=0;i<genre.length;i++){
            res += genre[i] + " ";
        }
        return res;
    }
    public String[] getRawGenre(){
        return genre;
    }
}