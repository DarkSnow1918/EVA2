package Clases;

public class Clientes {
    private String axel, roxana;
    private int salAxel, salRox;



    public Clientes(){
        axel = "Axel";
        roxana = "Roxana";

        salAxel=750000;
        salRox=900000;

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
}

