import com.example.JdbcCorporateEventDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Created by yangwj5 on 2017/3/21 at 20:56.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        JdbcCorporateEventDao dao = (JdbcCorporateEventDao) applicationContext.getBean("corporateEventDao");
        List list = dao.getList("1");
        for (Object obj:list){
            if(obj instanceof List){
                for (Object o : (List)obj){
                    System.out.println(o);
                }
            }
        }
    }
}
