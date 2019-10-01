package com.anpnmn.base.controller;

import com.anpnmn.base.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    private final MessageRepository messageRepository;

    public BaseController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public ModelAndView getMapping() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("message", messageRepository.findMessage().getText());
        return modelAndView;
    }
}
