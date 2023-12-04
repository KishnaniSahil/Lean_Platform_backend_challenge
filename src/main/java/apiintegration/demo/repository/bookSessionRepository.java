package apiintegration.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class bookSessionRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String ,Object>> getConsultantList(String job_role) {
        return this.jdbcTemplate.queryForList("exec GetConsultantDetails ?", job_role);
    }

    public Map<String ,Object> GetWebAppStatistics() {
        return this.jdbcTemplate.queryForMap("exec GetWebAppStatistics");
    }

    public void sessionAccepting(Integer client_id){
        System.out.println(this.jdbcTemplate.update("Exec consulting_app_schema.Sp_acceptRequestBookSession ?",client_id));
    }

    public void addConsultant( String name, Integer age, String phone_no, String email, String job_role , String cv) {
        this.jdbcTemplate.update("EXEC  AddConsultant ?,?,?,?,?,?", name, age, phone_no, email, job_role , cv);
    }



}
