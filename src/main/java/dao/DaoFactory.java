package dao;

public class DaoFactory {
    private static Comments commentDao;
    private static Products productDao;
    private static P_Config config = new P_Config();

    public static Comments getCommentDao(){
        if (commentDao == null){
            commentDao = new CommentDao();
        }
        return commentDao;
    }

    public static Products getProductDao(){
        if (productDao == null){
            productDao = new ProductDao(config);
        }
        return productDao;
    }
}
