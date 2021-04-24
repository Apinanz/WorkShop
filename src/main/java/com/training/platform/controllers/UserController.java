//package com.training.platform.controllers;
//
//import com.training.platform.entities.User;
//import com.training.platform.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/demo")
//public class UserController {
//    @Autowired
//    private UserService userService;
////
////    //1
////    @GetMapping(value = "")
////    public List<User> index() throws Exception {
////        return userService.findAll();
////    }
////    //2
////    @GetMapping(value = "/findById")
////    public Optional<User> findById(@RequestParam Integer id) {
////        return userService.findById(id);
////    }
////    //3
////    @GetMapping(value = "/findAllByLimit")
////    public Page<User> findAllByLimit(@RequestParam Integer start,@RequestParam Integer limit,@RequestParam String field) {
////        return userService.findAllByLimit(start, limit, field);
////    }
////    //4
////    @GetMapping(value = "/findByCityAndActiveAndAge/{city}/{active}/{age}")
////    public List<User> findByCityAndActiveAndAge(@PathVariable String city,@PathVariable Integer active,@PathVariable Integer age) {
////        return userService.findByCityAndActiveAndAge(city,active,age);
////    }
////    //5
////    @GetMapping(value = "/findByAgeIn")
////    public List<User> findByAgeIn(@RequestParam(name = "age") List<Integer> ages) {
////        return userService.findByAgeIn(ages);
////    }
////    //6
////    @GetMapping(value = "/findAllByQuery")
////    public List<User> findAllByQuery() {
////        return userService.findAllByQuery();
////    }
////    //7
////    @GetMapping(value = "/findAllByParamsQuery")
////    public List<User> findAllByParamsQuery(@RequestParam Integer active, @RequestParam String city) {
////        return userService.findAllByParamsQuery(active,city);
////    }
////    //8
////    @GetMapping(value = "/findAllByJpqlQuery")
////    public  List<User> findAllByJpqlQuery() {
////        return userService.findAllByJpqlQuery();
////    }
////
////    //9
////    @GetMapping(value = "/findAllByJpqlParamsQuery")
////    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city) {
////        return userService.findAllByJpqlParamsQuery(active , city);
////    }
////
////    //Homework1----------------------------------
////    @GetMapping(value = "/findByIdIn")
////    public List<User> findByIdIn(@RequestParam(name = "id")List<Integer> id) {
////        return userService.findByIdIn(id);
////    }
////    @GetMapping(value = "/findByCityAndAge")
////    public List<User> findByCityAndAge(@RequestParam String city , @RequestParam Integer age) {
////        return userService.findByCityAndAge(city,age);
////    }
//
//}
