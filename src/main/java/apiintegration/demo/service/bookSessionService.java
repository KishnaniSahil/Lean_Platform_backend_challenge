package apiintegration.demo.service;

import apiintegration.demo.repository.bookSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class bookSessionService {
    @Autowired
    private bookSessionRepository bookSessionRepository;

    public List<Map<String ,Object>> getConsultantList(String job_role){
        return bookSessionRepository.getConsultantList(job_role); }

    public Map<String ,Object> GetWebAppStatistics(){
        return bookSessionRepository.GetWebAppStatistics(); }

    public void sessionAccepting(@RequestBody Map<String,Object> sessionAccepting){

        Integer client_id=(Integer)sessionAccepting.get("client_id");
        System.out.println(client_id);
        this.bookSessionRepository.sessionAccepting(client_id);
    }

    public void addConsultant(Map<String,Object> addConsultant){
        String name=(String)addConsultant.get("name");
        Integer age=(Integer)addConsultant.get("age");
        String phone_no=(String)addConsultant.get("phone_no");
        String email=(String)addConsultant.get("email");
        String job_role=(String)addConsultant.get("job_role");
        String cv=(String)addConsultant.get("cv");

        this.bookSessionRepository.addConsultant(name,age,phone_no,email,
                job_role,cv);
    }
}
