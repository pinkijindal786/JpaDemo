package com.employee.jpademo.controller;

import com.employee.jpademo.model.RootJsonConvertor;
import com.employee.jpademo.model.Translator;
import com.employee.jpademo.service.TestingGit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("public/api")
@RequiredArgsConstructor
public class PublicApiController {
    private final TestingGit testingGit;
    @PostMapping("/testing")
    public ResponseEntity<Translator> translator(@RequestBody Translator trans) throws Exception {
        return new ResponseEntity(testingGit.translator(trans.toString()),HttpStatus.OK);
    }
}
