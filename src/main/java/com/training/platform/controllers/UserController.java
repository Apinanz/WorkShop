package com.training.platform.controllers;
import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> findAll() {
        return userService.findAll();
    }
    @GetMapping(value = "/id")
    public Optional<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    @GetMapping(value = "/lim")
    public Page<User> findAllByLimit(@RequestParam Integer start,@RequestParam Integer limit,@RequestParam String field) {
        PageRequest page = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
        return userService.findAllByLimit(start,limit,field);
    }
    @GetMapping(value = "/cityacage" )
    public List<User> findByCityAndActiveAndAge(@RequestParam String city,@RequestParam Integer active,@RequestParam Integer age) {
        return userService.findByCityAndActiveAndAge(city, active, age);
    }
    @GetMapping(value = "/age" )
    public List<User> findByAgeIn(@RequestParam List<Integer> ages) {
        return userService.findByAgeIn(ages);
    }
    @GetMapping(value = "/allQue")
    public List<User> findAllByQuery() {
        return userService.findAllByQuery();
    }
    @GetMapping(value = "/ParamQue")
    public List<User> findAllByParamsQuery(@RequestParam Integer active,@RequestParam String city) {
        return userService.findAllByParamsQuery(active, city);
    }
    @GetMapping(value = "/listAll")
    public List<User> findAllByJpqlQuery() {
        return userService.findAllByJpqlQuery();
    }
    @GetMapping(value = "/ParamJpql")
    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city) {
        return userService.findAllByJpqlParamsQuery(active, city);
    }
}
