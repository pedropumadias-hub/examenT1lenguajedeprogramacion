<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Proyecto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Proyectos - Municipalidad</title>
    <!-- CSS Bootstrap opcional para que se vea ordenado -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <h2 class="mb-4">Registro de Proyectos Municipales</h2>

    <!-- Mensaje de Error si lo hubiera -->
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <div class="alert alert-danger"><%= error %></div>
    <% } %>

    <!-- FORMULARIO DE REGISTRO -->
    <div class="card mb-4">
        <div class="card-header bg-primary text-white">Nuevo Proyecto</div>
        <div class="card-body">
            <form action="<%= request.getContextPath() %>/ProyectoServlet" method="POST">
                <div class="mb-3">
                    <label class="form-label">Nombre:</label>
                    <input type="text" name="nombre" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Descripción:</label>
                    <textarea name="descripcion" class="form-control"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Fecha Inicio (YYYY-MM-DD):</label>
                    <input type="date" name="fechaInicio" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Fecha Fin (YYYY-MM-DD):</label>
                    <input type="date" name="fechaFin" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Asesor Técnico:</label>
                    <input type="text" name="asesor" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Presupuesto:</label>
                    <input type="number" step="0.01" name="presupuesto" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success">Guardar Proyecto</button>
            </form>
        </div>
    </div>

    <!-- TABLA DE LISTADO -->
    <div class="card">
        <div class="card-header bg-secondary text-white">Lista de Proyectos Registrados</div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>F. Inicio</th>
                        <th>F. Fin</th>
                        <th>Asesor</th>
                        <th>Presupuesto</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Proyecto> lista = (List<Proyecto>) request.getAttribute("proyectos");
                        if (lista != null && !lista.isEmpty()) {
                            for (Proyecto p : lista) {
                    %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getNombre() %></td>
                            <td><%= p.getDescripcion() %></td>
                            <td><%= p.getFechaInicio() %></td>
                            <td><%= p.getFechaFin() %></td>
                            <td><%= p.getAsesorTecnico() %></td>
                            <td>S/. <%= p.getPresupuesto() %></td>
                        </tr>
                    <% 
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="7" class="text-center">No hay proyectos registrados o cargados.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>