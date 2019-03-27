import com.myjava.bean.Student;
import com.myjava.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/3/26 23:39
 * @Version 1.0
 */
public class TestClass {
    public static void main(String[] args) throws SQLException {
        System.out.println("running StudentDaoImpl-findall()");
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM stu";
        List<Student> list = runner.query(sql,new BeanListHandler<>(Student.class));
        for(Student s:list){
            System.out.println(s.getPhone());
        }
    }
}
