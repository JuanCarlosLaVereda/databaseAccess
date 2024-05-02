import java.util.List;

public interface AlmacenDatosDB {
    List<Empleado> getEmpleados();
    boolean updateEmpleado(Empleado empleado);
    boolean deleteEmpleado(String DNI);
    Empleado addEmpleado(Empleado empleado);
    Empleado getEmpleado(String dni);
    boolean authenticate(String login, String passwd);
    List<Empleado> getEmpleadoPorCargo(String cargo);
    int addEmpleadoProcedure(Empleado empleado);
}
