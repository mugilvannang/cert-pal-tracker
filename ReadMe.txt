1.The code by default using InMemory Database (InMemoryTimeEntryRepository)
2.The Repository which need to be called by specifying repo name in TimeEntryController.java constructor
3.If you want to switch between InMemory and MySQL DB then changing the qualifier name in TimeEntryController.java would be enough
4.In application.yml the DB credentials for Mysql are specified
    

CRUD using REST Calls
To Insert   >> curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userId\": 2, \"date\": \"2019-01-01\", \"hours\": 8}"
To Get      >> curl -i localhost:8080/time-entries/${TIME_ENTRY_ID}
To Update   >> curl -i -XPUT -H"Content-Type: application/json" localhost:8080/time-entries/${TIME_ENTRY_ID} -d"{\"projectId\": 88, \"userId\": 99, \"date\": \"2019-01-01\", \"hours\": 8}"
To Delete   >> curl -i -XDELETE -H"Content-Type: application/json" localhost:8080/time-entries/${TIME_ENTRY_ID}

CRUD PostMan JSON Request
----------------------------------------------------------
INSERT
----------------------------------------------------------

URL     : localhost:8080/time-entries
METHOD  : post 
Data    : { 			   
			   "projectId":3,
			   "userId":4,
			   "date":"2019-01-01",
			   "hours":8
		  }

----------------------------------------------------------
GET
----------------------------------------------------------
URL     : localhost:8080/time-entries/${TIME_ENTRY_ID}
METHOD  : get 
Data    : ID in URL

----------------------------------------------------------
UPDATE
----------------------------------------------------------
URL     : localhost:8080/time-entries/2
METHOD  : PUT 
Data    : ID in URL
          { 
			   "id":2,
			   "projectId":2,
			   "userId":44,
			   "date":"2019-01-01",
			   "hours":8
			} 
			
			
----------------------------------------------------------
DELETE
----------------------------------------------------------
URL     : localhost:8080/time-entries/${TIME_ENTRY_ID}
METHOD  : delete 
Data    : ID in URL
			