package dao;

public class DaoFactory {
    private static Comments commentDao;

    public static Comments getCommentDao(){
        if (commentDao == null){
            commentDao = new CommentDao();
        }
        return commentDao;
    }
}
