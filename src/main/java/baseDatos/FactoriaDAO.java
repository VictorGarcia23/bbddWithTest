package baseDatos;

public class FactoriaDAO {
    public static DAO crearDB(Constantes.DAOS baseDeDatosActual){
        switch (baseDeDatosActual){
            case POSTGRES:
                return new DAOPostgres();
            case MYSQL:
                return new DAOMySql();
        }
        return null;
    }
}
