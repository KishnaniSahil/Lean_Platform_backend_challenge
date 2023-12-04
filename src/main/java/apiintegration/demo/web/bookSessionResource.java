package apiintegration.demo.web;

import apiintegration.demo.service.bookSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RestController
@RequestMapping({"/api"})
public class bookSessionResource {
    @Autowired
    private apiintegration.demo.service.bookSessionService bookSessionService;


//Api to get all consultant details
    @GetMapping("/getConsultantList/{job_role}")
    public List<Map<String ,Object>> getConsultantList(@PathVariable String job_role){
        return bookSessionService.getConsultantList(job_role); }


        //Get Statics of total client,consultant and session booked Api
    @GetMapping("/GetWebAppStatistics/")
    public Map<String ,Object> GetWebAppStatistics(){
        return bookSessionService.GetWebAppStatistics(); }


        //AcceptorRejectSessionwithclient Api
    @PostMapping("sessionAcceptingbetweenMentorandClient")
    public void sessionAccepting(@RequestBody Map<String,Object> sessionAccepting){
        this.bookSessionService.sessionAccepting(sessionAccepting);
    }


    //AddConsultantDetails Api
    @PostMapping("/addConsultant")
    public void addConsultant(@RequestBody Map<String,Object> addConsultant){
        this.bookSessionService.addConsultant(addConsultant);
    }
}
