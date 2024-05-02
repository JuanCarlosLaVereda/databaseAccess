import java.sql.Date;

public class TestMySQL {
    public static void main(String[] args) {
//        ConectarDriverManager.conexionMysql();
        MyDataSource.conectarMySQL();
        AlmacenDatosDB empleados = new EmpleadoDB();
        System.out.println(empleados.getEmpleados());
        Empleado empleado = empleados.getEmpleados().get(0);
        empleado.setCargo("jefe");
        System.out.println(empleados.updateEmpleado(empleado));
        System.out.println("-------------------------------Lista de empleados-------------------------------");
        System.out.println(empleados.getEmpleados());
        System.out.println("Añadimos un empleado:");
        System.out.println(empleados.addEmpleado(new Empleado(0, "12345679X", "Quien?", "SIHOMBRE", "1234", "apensab@gmail.com", new Date(2000/11/11), "plebe", "El suyo")));
        System.out.println("Se ha añadido?");
        System.out.println(empleados.getEmpleados());
        System.out.println("Lo borro ahora");
        System.out.println(empleados.deleteEmpleado("12345679X"));
        System.out.println("Se ha borrado?");
        System.out.println(empleados.getEmpleados());
        System.out.println("Tabla de empleados");
        System.out.println(empleados.getEmpleados());
        System.out.println("Autentificacion con 12345678X y 1111");
        System.out.println(empleados.authenticate("12345678X", "1111"));
        System.out.println("Get de empleados por cargo");
        System.out.println(empleados.getEmpleadoPorCargo("jefe"));
        System.out.println("-------------------------------Lista de empleados-------------------------------");
        System.out.println("Añado un usuario con un procedimiento de la base de datos");
        System.out.println(empleados.addEmpleadoProcedure(new Empleado(0, "12345679X", "Quien?", "SIHOMBRE", "1234", "apensab@gmail.com", new Date(2000/11/11), "plebe", "El suyo")));
        System.out.println("Se ha añadido?");
        System.out.println(empleados.getEmpleados());
        System.out.println("Lo borro");
        System.out.println(empleados.deleteEmpleado("12345679X"));
        System.out.println("Se ha borrado?");
        System.out.println(empleados.getEmpleados());

    }
}
