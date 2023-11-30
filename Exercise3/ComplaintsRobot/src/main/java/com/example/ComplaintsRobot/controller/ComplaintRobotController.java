package com.example.ComplaintsRobot.controller;
// ComplaintRobotController.java
import com.example.ComplaintsRobot.service.ComplaintsRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ComplaintRobotController {

    private final ComplaintsRobotService complaintsRobotService;
    @Autowired
    public ComplaintRobotController(ComplaintsRobotService complaintsRobotService) {
        this.complaintsRobotService = complaintsRobotService;
    }

    @GetMapping("/run")
    public String runRobot() throws InterruptedException {
        return complaintsRobotService.runRobot();
    }

}
