/**
 * FriendService
 */
app.factory('FriendService',function($http){
	var friendService={}

	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/suggestedusers")
	}
	friendService.sendFriendRequest=function(toIdValue){ //toId is User object
		return $http.post("http://localhost:8067/SHAREUPmiddleware/addfriend",toIdValue)
	}
	friendService.getPendingRequests=function(){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/pendingrequests")
	}
	friendService.updateStatus=function(updatedFriendRequest){
		return $http.put("http://localhost:8067/SHAREUPmiddleware/updatestatus",updatedFriendRequest)
	}
	friendService.getAllFriends=function(){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/friends")
	}
	return friendService;

})