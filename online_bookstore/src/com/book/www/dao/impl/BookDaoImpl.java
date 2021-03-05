package com.book.www.dao.impl;

import com.book.www.dao.BookDao;
import com.book.www.entity.Book;
import com.book.www.entity.Classification;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public int insertBook(Book book) {
        try {
            return queryRunner.update("insert into book (id, original_name, name, original_price, price, description, author, translator, publishing_house, isbn, path, filename, class_Id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                                    book.getId(), book.getOriginal_name(),book.getName(),book.getOriginal_price(),book.getPrice(),book.getDescription(),book.getAuthor(),book.getTranslator(),book.getPublishing_house(),book.getIsbn(),book.getPath(),book.getFilename(), book.getClass()==null?null:book.getClassification().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteBook(String id) {
        try {
            return queryRunner.update("delete from book where id = ?;", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int updateBook(Book book) {
        try {
            return queryRunner.update("update book set class_Id = ? , original_name = ? , name = ? , original_price = ? , price = ? , description = ? , author = ? , translator = ? , publishing_house = ?, isbn = ? , path = ? , filename = ? ;",
                                    book.getClass()==null?null:book.getClassification().getId(), book.getOriginal_name(), book.getName(), book.getOriginal_price(), book.getPrice(), book.getDescription(), book.getAuthor(), book.getTranslator(), book.getPublishing_house(), book.getIsbn(), book.getPath(), book.getFilename());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getBookCount() {
        try {
            Long num = (Long) queryRunner.query("select count(id) from book", new ScalarHandler<>(1));
            return num.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getBookCount(String classId) {
        try {
            Long num = (Long) queryRunner.query("select count(id) from book where class_Id = ?", new ScalarHandler<>(1), classId);
            return num.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> getAllBookByPages(int pageIndex, int pageSize) {
        try {
            List<Book> books = queryRunner.query("select *from book limit ? ,? ", new BeanListHandler<Book>(Book.class), pageIndex, pageSize);
            if (books != null) {
                for (Book book : books) {
                    String sql = "select *from book_classification where id = (select class_Id from book where id =?)";
                    Classification classification =queryRunner.query(sql, new BeanHandler<Classification>(Classification.class), book.getId());
                    book.setClassification(classification);
                }
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBookByPages(int pageIndex, int pageSize, String classId) {
        try {
            List<Book> books = queryRunner.query("select *from book where class_Id = ? limit ? , ? ", new BeanListHandler<Book>(Book.class), classId, pageIndex, pageSize );
            if (books != null) {
                for (Book book : books) {
                    String sql = "select *from book_classification where id = ?";
                    Classification classification =queryRunner.query(sql , new BeanHandler<Classification>(Classification.class), classId);
                    book.setClassification(classification);
                }
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Book getBook(String id) {
        try {
            Book book = queryRunner.query("select *from book where id = ?", new BeanHandler<Book>(Book.class), id);
            if (book != null) {
                String sql = "select *from book_classification where id = (select class_Id from book where id =?) ";
                Classification classification = queryRunner.query(sql, new BeanHandler<Classification>(Classification.class),book.getId());
                book.setClassification(classification);
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    @Override
//    public List<Book> getAllBook() {
//        try {
//            return queryRunner.query("select *from book;", new BeanListHandler<Book>(Book.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Book getBook(int id) {
//        try {
//            return queryRunner.query("select *from book where book_id = ?;", new BeanHandler<Book>(Book.class), id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//        @Override
//    public int deleteBook(int id) {
//        try {
//            return queryRunner.update("delete from book where book_id = ?;", id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    @Override
//    public int insertBook(Book book) {
//        Object[] params = {book.getClass(), book.getBook_id(), book.getOriginal_name(), book.getName(), book.getOriginal_price(), book.getPrice(), book.getDescription(), book.getAuthor(), book.getTranslator(), book.getPublishing_house(), book.getIsbn()};
//        try {
//            return queryRunner.update("insert into book (class_id, original_name, name, original_price, price, description, author, translator, publishing_house, isbn);", params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    @Override
//    public int updateBook(Book book) {
//        Object[] params = {book.getClass_id(), book.getOriginal_name(), book.getName(), book.getOriginal_price(), book.getPrice(), book.getDescription(), book.getAuthor(), book.getTranslator(), book.getPublishing_house(), book.getIsbn(), book.getBook_id()};
//        try {
//            return queryRunner.update("update book set class_id = ? , original_name = ? , name = ? , original_price = ? , price = ? , description = ? , author = ? , translator = ? , publishing_house = ? , isbn = ?  where book_id = ?;",params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Book> getAllBookByPages(int pageIndex, int pageSize) {
//        try {
//            return queryRunner.query("select *from book limit ?, ?;", new BeanListHandler<Book>(Book.class), pageIndex, pageSize);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Long getBookCount() {
//        try {
//            return queryRunner.query("select count(*) from book;", new ScalarHandler<>());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
