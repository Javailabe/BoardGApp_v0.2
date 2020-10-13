package database;

public class Games {

    private static final String dbname = "BoardG_games";
    //private static final String sqldbname = "'BoardG_games'";

    //private static final String sqlcolName = "['Name']";
    //private static final String sqlcolAvailableQty = "['Available Qty']";
    //private static final String sqlcolTotalQty = "['Total Qty']";

    private static String name;
    private static int availableqty, totalqty;

    public static String getDbname() {
        return dbname;
    }

    //public static String getSqlcolName() {
    //    return sqlcolName;
    //}

    //public static String getSqlcolAvailableQty() {
    //    return sqlcolAvailableQty;
    //}

    //public static String getsqlColTotalQty() {
    //    return sqlcolTotalQty;
    //}

    public static void setName(String subname) {
        name = subname;
        setSqlName();
    }

    public static String getName() {
        return name;
    }

    public static void setAvailableqty(int subavailableqty) {
        availableqty = subavailableqty;
    }

    public static int getAvailableqty() {
        return availableqty;
    }

    public static void setTotalqty(int subtotalqty) {
        totalqty = subtotalqty;
    }

    public static int getTotalqty() {
        return totalqty;
    }

    //metoda zapisujaca nazwe do formatu sql
    static void setSqlName() {
        name = "'" + name + "'";
    }

}
