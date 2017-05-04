package controllers;

import controllers.utils.ResponseEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.TestSupervisorRepository;

@RestController
public class TestSupervisorController {

    private final TestSupervisorRepository testSupervisorRepository;

    @Autowired
    public TestSupervisorController(TestSupervisorRepository testSupervisorRepository) {
        this.testSupervisorRepository = testSupervisorRepository;
    }

    @GetMapping(path = "/supervisors", produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getAllTestSupervisors() {
        return ResponseEntityUtils.
                getResponseEntityForMultipleResponses(testSupervisorRepository.findAll());
    }

    @GetMapping(path = "/supervisors/id/{id}", produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getTestSupervisorById(@PathVariable(value = "id") String testSupervisorIdToSearch) {
        return ResponseEntityUtils.
                getResponseEntityForSingleResponse(testSupervisorRepository.findById(testSupervisorIdToSearch));
    }

    @PostMapping(path = "/supervisors/login", produces = "application/json")
    public @ResponseBody
    ResponseEntity<?> getTestSupervisorByLogin(@RequestParam(value = "login") String testSupervisorLoginToSearch) {
        return ResponseEntityUtils.
                getResponseEntityForSingleResponse(testSupervisorRepository.findByLogin(testSupervisorLoginToSearch));
    }
}
