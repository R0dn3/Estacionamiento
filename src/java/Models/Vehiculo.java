package Models;

import java.time.LocalDateTime;

public class Vehiculo {
    private int id; // ID único del registro en la tabla "ingresos"
    private String placa; // Placa del vehículo
    private String claseVehiculo; // Tipo de vehículo (auto, moto, etc.)
    private LocalDateTime fechaIngreso; // Fecha y hora de ingreso
    private LocalDateTime fechaSalida; // Fecha y hora de salida (si aplica)
    private long tiempoTranscurrido; // Tiempo transcurrido en minutos
    private double monto; // Monto calculado para el cobro

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public long getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(long tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

