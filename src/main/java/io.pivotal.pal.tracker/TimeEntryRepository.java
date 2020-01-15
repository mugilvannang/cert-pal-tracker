package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry pTimeEntry);
    public ResponseEntity<TimeEntry> read(Long pEntryId);
    public TimeEntry find(Long pEntryId);
    public ResponseEntity<List<TimeEntry>> list();
    public TimeEntry update(Long pEntryId, TimeEntry pTimeEntry);
    public TimeEntry delete(Long pEntryId);
}
