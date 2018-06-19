/**
 * Job Service
 */
app.factory('JobService',function($http){

	var jobService={}
	
	jobService.addJob=function(job){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/addjob",job)
	}
	
	jobService.getActiveJobs=function(job){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/activejobs")
	}
	
	jobService.getInActiveJobs=function(job){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/inactivejobs")
	}
	
	jobService.updateActiveStatus=function(job){
		return $http.put("http://localhost:8067/SHAREUPmiddleware/updatejob",job)
	}
	return jobService;
	
})