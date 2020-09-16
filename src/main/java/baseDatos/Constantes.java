package baseDatos;

public class Constantes {
    public enum DAOS{
        POSTGRES,
        MYSQL
    }
    public static final DAOS BASE_DE_DATOS_ACTUAL = DAOS.MYSQL;
}
