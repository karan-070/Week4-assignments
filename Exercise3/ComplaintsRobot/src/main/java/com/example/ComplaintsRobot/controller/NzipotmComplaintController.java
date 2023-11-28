package com.example.ComplaintsRobot.controller;
// NzipotmComplaintController.java
import com.example.ComplaintsRobot.service.ComplaintsRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NzipotmComplaintController {

    private final ComplaintsRobotService nzipotmComplaintService;
    @Autowired
    public NzipotmComplaintController(ComplaintsRobotService nzipotmComplaintService) {
        this.nzipotmComplaintService = nzipotmComplaintService;
    }

    @GetMapping("/run")
    public String runRobot() throws InterruptedException {
        return nzipotmComplaintService.runRobot();
    }

}
