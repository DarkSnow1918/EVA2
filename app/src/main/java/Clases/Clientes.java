package Clases;

public class Clientes {
    private String axel, roxana, betzabe, matias;
    private int salAxel, salRox,salBet, salMat;



    public Clientes(){
        axel = "Axel";
        roxana = "Roxana";
        betzabe ="Betzabe";
        matias ="Matias";

        salAxel=750000;
        salRox=900000;
        salBet=500000;
        salMat=100000;

    }

    public String getAxel() {
        return axel;
    }

    public void setAxel(String axel) {
        this.axel = axel;
    }

    public String getRoxana() {
        return roxana;
    }

    public void setRoxana(String roxana) {
        this.roxana = roxana;
    }

    public int getSalAxel() {
        return salAxel;
    }

    public void setSalAxel(int salAxel) {
        this.salAxel = salAxel;
    }

    public int getSalRox() {
        return salRox;
    }

    public void setSalRox(int salRox) {
        this.salRox = salRox;
    }

    public String getBetzabe() {
        return betzabe;
    }

    public void setBetzabe(String betzabe) {
        this.betzabe = betzabe;
    }

    public String getMatias() {
        return matias;
    }

    public void setMatias(String matias) {
        this.matias = matias;
    }

    public int getSalBet() {
        return salBet;
    }

    public void setSalBet(int salBet) {
        this.salBet = salBet;
    }

    public int getSalMat() {
        return salMat;
    }

    public void setSalMat(int salMat) {
        this.salMat = salMat;
    }
}

