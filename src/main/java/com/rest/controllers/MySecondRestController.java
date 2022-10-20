package com.rest.controllers;

import com.rest.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MySecondRestController {


    @GetMapping("/hello")
    public void hello() throws StudentNotFoundException, IOException {
        if (1==1){
            throw new StudentNotFoundException("hhhhhhhh m al9ahx ");
        }
    }
}
