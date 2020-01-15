package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository{

    public TimeEntry create(TimeEntry pTimeEntry){
        TimeEntry objTimeEntry = null;
        return objTimeEntry;
    }

    public ResponseEntity<TimeEntry> read(Long pTimeEntryId){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }

    public TimeEntry find(Long pTimeEntryId){
        TimeEntry objTimeEntry = null;
        return objTimeEntry;
    }

    public ResponseEntity<List<TimeEntry>> list(){
        ResponseEntity objResponseEntity = null;
        return objResponseEntity;
    }


    public TimeEntry update(Long pTimeEntryId, TimeEntry pTimeEntry){
        TimeEntry objTimeEntry = null;
        return objTimeEntry;
    }

    public TimeEntry delete(Long pTimeEntryId){
        TimeEntry objTimeEntry = null;
        return objTimeEntry;
    }
}
