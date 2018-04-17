package personnage;

public class Guerrier {

    private String Type;
    private String Nom;
    private String Image;
    private int NiveauVie;
    private int Attaque;
    private int Arme;
    private int Bouclier;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getNiveauVie() {
        return NiveauVie;
    }

    public void setNiveauVie(int niveauVie) {
        NiveauVie = niveauVie;
    }

    public int getAttaque() {
        return Attaque;
    }

    public void setAttaque(int attaque) {
        Attaque = attaque;
    }

    public int getArme() {
        return Arme;
    }

    public void setArme(int arme) {
        Arme = arme;
    }

    public int getBouclier() {
        return Bouclier;
    }

    public void setBouclier(int bouclier) {
        Bouclier = bouclier;
    }

    public Guerrier(String nom, String image, int arme, int bouclier) {
        Type = "Guerrier";
        Nom = nom;
        Image = image;
        NiveauVie = 100;
        Attaque = 50;
        Arme = arme;
        Bouclier = bouclier;
    }

    @Override
    public String toString() {
        return "Guerrier{" +
                "Type='" + Type + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Image='" + Image + '\'' +
                ", NiveauVie=" + NiveauVie +
                ", Attaque=" + Attaque +
                ", Arme=" + Arme +
                ", Bouclier=" + Bouclier +
                '}';
    }
}
