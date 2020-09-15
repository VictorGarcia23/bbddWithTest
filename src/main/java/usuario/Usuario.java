package usuario;

public class Usuario {

        private int id;
        private String apellidos;
        private String nombre;
        private String departamento;
        private String sede;
        public Usuario(String apellidos, String nombre, String Departamento, String sede, int id)
        {
            this.apellidos = apellidos;
            this.nombre = nombre;
            this.departamento = Departamento;
            this.sede = sede;
            this.id = id;
        }


    public int getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSede() {
        return sede;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
