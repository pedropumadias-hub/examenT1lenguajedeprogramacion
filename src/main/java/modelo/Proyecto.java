package modelo;

public class Proyecto {
	private int id;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String asesorTecnico;
    private double presupuesto;

    public Proyecto() {}

    public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFin, String asesorTecnico, double presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.asesorTecnico = asesorTecnico;
        this.presupuesto = presupuesto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }
    public String getAsesorTecnico() { return asesorTecnico; }
    public void setAsesorTecnico(String asesorTecnico) { this.asesorTecnico = asesorTecnico; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }
}
	

