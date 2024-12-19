package Models;

import java.sql.Timestamp;

public class Ingreso {
    private String placa;
    private String claseVehiculo;
    private Timestamp fechaHoraIngreso;

    public Ingreso(String placa, String claseVehiculo, Timestamp fechaHoraIngreso) {
        this.placa = placa;
        this.claseVehiculo = claseVehiculo;
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public Timestamp getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(Timestamp fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }
}