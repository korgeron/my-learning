package dao;

public class P_Config {

    String url() {
        return "jdbc:mysql://localhost:3306/products_db?allowPublicKeyRetrieval=true&useSSL=false";
    }

    String user() {
        return "root";
    }

    String pass(){
        return "codeup";
    }

}
