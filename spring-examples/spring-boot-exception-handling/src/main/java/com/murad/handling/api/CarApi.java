package com.murad.handling.api;

import com.murad.handling.dto.Car;
import com.murad.handling.exception.EntityNotFoundException;
import com.murad.handling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }


    // Local Exception Handler is working only for defined controller

//    @ExceptionHandler({EntityNotFoundException.class})
//    public ResponseEntity entityNotFound(){
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

//    @ExceptionHandler({EntityNotFoundException.class})
//    public String entityNotFound(){
//        return "Record not founded";
//    }
}
