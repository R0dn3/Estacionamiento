package Models;

public class Historial {
    private String placa;
    private String claseVehiculo;
    private String fechaIngreso;

    // Constructor
    public Historial(String placa, String claseVehiculo, String fechaIngreso) {
        this.placa = placa;
        this.claseVehiculo = claseVehiculo;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y Setters
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
