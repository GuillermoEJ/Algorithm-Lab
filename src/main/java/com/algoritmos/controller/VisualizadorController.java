package com.algoritmos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisualizadorController {
    
    @GetMapping("/")
    public String index() {
        return "visualizador";
    }
}
