package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/create")
    public ResponseEntity create(TimeEntry pTimeEntry){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @GetMapping("/read")
    public ResponseEntity<TimeEntry> read(Long pTimeEntryId){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @GetMapping("/find")
    public ResponseEntity<TimeEntry> find(Long pTimeEntryId){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TimeEntry>> list(){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @PostMapping("/update")
    public ResponseEntity update(Long pTimeEntryId, TimeEntry pTimeEntry){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @PostMapping("/delete")
    public ResponseEntity delete(Long pTimeEntryId){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

}
