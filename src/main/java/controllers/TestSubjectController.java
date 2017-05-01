package controllers;

import controllers.common.ResponseEntityOperations;
import model.TestSubject;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.TestSubjectRepository;

import java.util.List;

@RestController
public class TestSubjectController {

    private final TestSubjectRepository testSubjectRepository;

    @Autowired
    public TestSubjectController(TestSubjectRepository testSubjectRepository) {
        this.testSubjectRepository = testSubjectRepository;
    }

    @RequestMapping(path = "/subjects", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getAllTestSubjects() {
        return ResponseEntityOperations.
                getResponseEntityForMultipleResponses(testSubjectRepository.findAll());
    }

    @RequestMapping(path = "/subjects/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getTestSubjectById(@PathVariable(value = "id") String testSubjectIdToSearch) {
        return ResponseEntityOperations.
                getResponseEntityForSingleResponse(testSubjectRepository.findById(testSubjectIdToSearch));
    }

    @RequestMapping(path = "/subjects/name", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getTestSubjectByName(@RequestParam(value = "name") String testSubjectNameToSearch) {
        return ResponseEntityOperations.
                getResponseEntityForMultipleResponses(testSubjectRepository.findByName(testSubjectNameToSearch));
    }

}