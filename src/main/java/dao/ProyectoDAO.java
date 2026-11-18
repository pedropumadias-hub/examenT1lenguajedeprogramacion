package dao;

import modelo.Proyecto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {
	private String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BDD_ProyectosMunicipalidad;encrypt=true;trustServerCertificate=true;";
    private String user = "sa";
    private String pass = "CAMBIAR_CONTRASEÑA";

    public Connection conectar() {

        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("✅ Conexión exitosa con SQL Server");

        } catch (Exception e) {

            System.out.println("❌ Error de conexión:");
            e.printStackTrace();

        }

        return con;
    }
    public List<Proyecto> listarProyectos() {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion, fecha_inicio, fecha_fin, asesor_tecnico, presupuesto FROM tb_proyecto";
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFechaInicio(rs.getString("fecha_inicio"));
                p.setFechaFin(rs.getString("fecha_fin"));
                p.setAsesorTecnico(rs.getString("asesor_tecnico"));
                p.setPresupuesto(rs.getDouble("presupuesto"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void registrarProyecto(Proyecto p) {
        String sql = "INSERT INTO tb_proyecto (nombre, descripcion, fecha_inicio, fecha_fin, asesor_tecnico, presupuesto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getFechaInicio());
            ps.setString(4, p.getFechaFin());
            ps.setString(5, p.getAsesorTecnico());
            ps.setDouble(6, p.getPresupuesto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}