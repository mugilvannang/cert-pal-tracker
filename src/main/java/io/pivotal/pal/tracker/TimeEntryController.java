package io.pivotal.pal.tracker;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;
    private final DistributionSummary timeEntrySummary;
    private final Counter actionCounter;


	public TimeEntryController(@Qualifier("DB") TimeEntryRepository timeEntryRepository, MeterRegistry meterRegistry) {
		this.timeEntryRepository = timeEntryRepository;
        timeEntrySummary = meterRegistry.summary("timeEntry.summary");
        actionCounter = meterRegistry.counter("timeEntry.actionCounter");
		
	}

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntry){
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);

        actionCounter.increment();
        timeEntrySummary.record(timeEntryRepository.list().size());

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{pTimeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long pTimeEntryId){
        TimeEntry objTimeEntry = this.timeEntryRepository.find(pTimeEntryId);
        ResponseEntity objResponseEntity = null;

        if(objTimeEntry != null)
        {
         objResponseEntity = new ResponseEntity<>(objTimeEntry, HttpStatus.OK);
         actionCounter.increment();
        }
        else
         objResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return objResponseEntity;
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        actionCounter.increment();
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("{pTimeEntryId}")
    public ResponseEntity update(@PathVariable  Long pTimeEntryId, @RequestBody  TimeEntry pTimeEntry){
        TimeEntry updatedTimeEntry = timeEntryRepository.update(pTimeEntryId, pTimeEntry);

        if (updatedTimeEntry != null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{pTimeEntryId}")
    public ResponseEntity delete(@PathVariable Long pTimeEntryId){
        timeEntryRepository.delete(pTimeEntryId);
        ResponseEntity objResponseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return objResponseEntity;
    }

}
