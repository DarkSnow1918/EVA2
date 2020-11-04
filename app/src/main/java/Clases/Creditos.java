package Clases;

public class Creditos {
    private String creHipo, creAuto;
    private int valHipo, valAuto, cuotaHipo, cuotaAuto;

    public Creditos(){
        creHipo ="Credito Hipotecario";
        creAuto ="Credito Automotriz";
        cuotaHipo= 12;
        cuotaAuto=8;

        valHipo=1000000;
        valAuto=500000;
    }

    public String getCreHipo() {
        return creHipo;
    }

    public void setCreHipo(String creHipo) {
        this.creHipo = creHipo;
    }

    public String getCreAuto() {
        return creAuto;
    }

    public void setCreAuto(String creAuto) {
        this.creAuto = creAuto;
    }

    public int getValHipo() {
        return valHipo;
    }

    public void setValHipo(int valHipo) {
        this.valHipo = valHipo;
    }

    public int getValAuto() {
        return valAuto;
    }

    public void setValAuto(int valAuto) {
        this.valAuto = valAuto;
    }

    public int getCuotaHipo() {
        return cuotaHipo;
    }

    public void setCuotaHipo(int cuotaHipo) {
        this.cuotaHipo = cuotaHipo;
    }

    public int getCuotaAuto() {
        return cuotaAuto;
    }

    public void setCuotaAuto(int cuotaAuto) {
        this.cuotaAuto = cuotaAuto;
    }
}
