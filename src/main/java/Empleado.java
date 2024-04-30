import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private String DNI;
    private String nombre;
    private String apellidos;
    private String CP;
    private String email;
    private Date fechaNac;
    private String cargo;
    private String domicilio;

    public Empleado(int idEmpleado, String DNI, String nombre, String apellidos, String CP, String email, Date fechaNac, String cargo, String domicilio) {
        this.idEmpleado = idEmpleado;
        this.DNI=DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.CP = CP;
        this.email = email;
        this.fechaNac = fechaNac;
        this.cargo = cargo;
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", CP='" + CP + '\'' +
                ", email='" + email + '\'' +
                ", fechaNac=" + fechaNac +
                ", cargo='" + cargo + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}' + "\n";
    }
}
