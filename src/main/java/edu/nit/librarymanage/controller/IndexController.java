package edu.nit.librarymanage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello";
    }

    @GetMapping("/abc")
    public String wedqqwdwqdqd() {
        return "abc";
    }

    @GetMapping("/plus")
    public Integer plus(
            @RequestParam Integer a,
            @RequestParam Integer b
    ) {
        return a + b;
    }

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(@RequestBody(required = false) String xxx) {
        return "test: " + xxx;
    }
}
