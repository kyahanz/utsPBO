abstract class Hewan {
    String jenisSuara;
    Boolean isMammalia;
    public String bersuara(){
        return jenisSuara;
    }
    public String isMammal(){
        return (isMammalia) ? (this.getClass().getName() + " adalah Mamalia")     //Percabangan
                : (this.getClass().getName() + " adalah bukan Mamalia");
    }
}