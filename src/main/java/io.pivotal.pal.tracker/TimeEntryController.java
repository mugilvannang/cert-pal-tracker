package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntry){
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{pTimeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long pTimeEntryId){
        TimeEntry objTimeEntry = this.timeEntryRepository.find(pTimeEntryId);
        ResponseEntity objResponseEntity = null;

        if(objTimeEntry != null)
         objResponseEntity = new ResponseEntity<>(objTimeEntry, HttpStatus.FOUND);
        else
         objResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return objResponseEntity;
    }

        @GetMapping
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> arrTimeEntry = timeEntryRepository.list();
        ResponseEntity objResponseEntity = new ResponseEntity<>(arrTimeEntry, HttpStatus.OK);
        return objResponseEntity;
    }

    @PutMapping("{pTimeEntryId}")
    public ResponseEntity update(@PathVariable  Long pTimeEntryId, @RequestBody  TimeEntry pTimeEntry){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    @DeleteMapping("{pTimeEntryId}")
    public ResponseEntity delete(@PathVariable Long pTimeEntryId){
        timeEntryRepository.delete(pTimeEntryId);
        ResponseEntity objResponseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return objResponseEntity;
    }

}
