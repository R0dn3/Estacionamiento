package models;

public class VehiculoReporte {
    private String placa;
    private String claseVehiculo;
    private String fechaIngreso;
    private String fechaSalida;
    private double monto;

    // Getters y setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getClaseVehiculo() { return claseVehiculo; }
    public void setClaseVehiculo(String claseVehiculo) { this.claseVehiculo = claseVehiculo; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
}

