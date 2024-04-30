import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDB implements AlmacenDatosDB{
    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        DataSource dataSource = MyDataSource.getMySQLDataSource();

        try(Connection connection=dataSource.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM EMPLEADO")){

            Empleado empleado;
            while(resultSet.next()){
                empleado = new Empleado(
                        resultSet.getInt("idEmpleado"),
                        resultSet.getString("DNI"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("CP"),
                        resultSet.getString("email"),
                        resultSet.getDate("fechaNac"),
                        resultSet.getString("cargo"),
                        resultSet.getString("domicilio"));

                empleados.add(empleado);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

        return empleados;
    }

    @Override
    public boolean updateEmpleado(Empleado empleado) {
        boolean resultado = false;
        DataSource dataSource = MyDataSource.getMySQLDataSource();

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {

            String query = "UPDATE EMPLEADO SET " +
                    "nombre='"+empleado.getNombre()+"',"+
                    "apellidos='"+empleado.getApellidos()+"',"+
                    "domicilio='"+empleado.getDomicilio()+"',"+
                    "CP='"+empleado.getCP()+"',"+
                    "email='"+empleado.getEmail()+"',"+
                    "fechaNac='"+empleado.getFechaNac()+"',"+
                    "cargo='"+empleado.getCargo()+"'"+
                    "WHERE DNI='"+empleado.getDNI()+"'";

            statement.executeUpdate(query);
            resultado = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteEmpleado(String DNI) {
        boolean resultado = false;
        DataSource dataSource = MyDataSource.getMySQLDataSource();

        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();){

            String query = "DELETE FROM EMPLEADO WHERE DNI='" + DNI + "'";
            int updatedRows = statement.executeUpdate(query);
            if (updatedRows > 0) {
                resultado = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        DataSource dataSource = MyDataSource.getMySQLDataSource();

        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();){
            int updatedRows = 0;

            String query = "INSERT EMPLEADO (DNI, nombre, apellidos, CP, email, fechaNac, cargo, domicilio)" +
                    "VALUES('" + empleado.getDNI() + "','" + empleado.getNombre() + "','" + empleado.getApellidos() +
                    "'," + empleado.getCP() + ",'" + empleado.getEmail() + "','" + empleado.getFechaNac() + "','" +
                    empleado.getCargo() + "','" + empleado.getDomicilio() + "');";
            updatedRows = statement.executeUpdate(query);

            if (updatedRows>0){
                empleado = getEmpleado(empleado.getDNI());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return empleado;
    }

    @Override
    public Empleado getEmpleado(String dni) {
        DataSource dataSource= MyDataSource.getMySQLDataSource();
        Empleado empleado = null;

        try(Connection connection = dataSource.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLEADO WHERE DNI = '"+dni+"'")){
            resultSet.next();
            empleado = new Empleado(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDate(7),
                    resultSet.getString(8),
                    resultSet.getString(11));

        } catch (SQLException e){
            e.printStackTrace();
        }

        return empleado;
    }

    @Override
    public boolean authenticate(String login, String passwd) {
        boolean resultado = false;
        DataSource dataSource = MyDataSource.getMySQLDataSource();

        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*)"  + "FROM EMPLEADO WHERE DNI = '" + login + "' AND password = '" + passwd + "'")){
            resultSet.next();
            if (resultSet.getInt(1)>0){
                resultado = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List<Empleado> getEmpleadoPorCargo(String cargo) {
        List<Empleado> empleados = new ArrayList<>();
        DataSource dataSource = MyDataSource.getMySQLDataSource();
        String query = "SELECT * FROM EMPLEADO WHERE CARGO = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setString(1, cargo);
            ResultSet resultSet = ps.executeQuery();
            Empleado empleado;
            while (resultSet.next()){
                empleado = new Empleado(
                        resultSet.getInt("idEmpleado"),
                        resultSet.getString("DNI"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("CP"),
                        resultSet.getString("email"),
                        resultSet.getDate("fechaNac"),
                        resultSet.getString("cargo"),
                        resultSet.getString("domicilio"));
                empleados.add(empleado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return empleados;
    }
}
