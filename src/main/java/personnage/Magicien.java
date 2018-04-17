package personnage;

public class Magicien {

    private String Type;
    private String Nom;
    private String Image;
    private int NiveauVie;
    private int Attaque;
    private int Sort;
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

    public int getSort() {
        return Sort;
    }

    public void setSort(int sort) {
        Sort = sort;
    }

    public int getBouclier() {
        return Bouclier;
    }

    public void setBouclier(int bouclier) {
        Bouclier = bouclier;
    }

    public Magicien(String nom, String image, int sort, int bouclier) {
        Type = "Magicien";
        Nom = nom;
        Image = image;
        NiveauVie = 100;
        Attaque = 70;
        Sort = sort;
        Bouclier = bouclier;
    }

    @Override
    public String toString() {
        return "Magicien{" +
                "Type='" + Type + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Image='" + Image + '\'' +
                ", NiveauVie=" + NiveauVie +
                ", Attaque=" + Attaque +
                ", Arme=" + Sort +
                ", Bouclier=" + Bouclier +
                '}';
    }
}
