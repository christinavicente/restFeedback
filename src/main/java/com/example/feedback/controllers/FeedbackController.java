package com.example.feedback.controllers;


import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FeedbackController {


    @Autowired
    private FeedbackRepository repo;
    ModelAndView mv= new ModelAndView("feedback");
    ModelAndView mv2= new ModelAndView("savefeedback");
    ModelAndView mv3=new ModelAndView("failedfeedback");
    Logger logger= LoggerFactory.getLogger((FeedbackController.class));

    @GetMapping("/")
    public String showServiceName()
    {
        return "feedback";
    }

    @GetMapping("/feedback")
    public ModelAndView enterFeedback() {
        logger.info("Webpage Loaded");

        return mv;
    }


    @PostMapping("/savedfeedback")
    public ModelAndView saveFeedback(@ModelAttribute Feedback newFeedback) {
        repo.save(newFeedback);
        logger.info("Data Saved to Database");
        if((newFeedback.getUser() != null)&&(newFeedback.getComments() != null)){
         return mv2;
        }else{
            return mv3;
        }

    }


}
