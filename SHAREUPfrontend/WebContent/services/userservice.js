/**
 * UserService
 * 1. Register - call the middleware -> dao -> insert user details in User table
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.register=function(user){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/register",user)
	}
	
	userService.login=function(user){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/login",user)
	}
	
	userService.logout=function(){
		return $http.put("http://localhost:8067/SHAREUPmiddleware/logout")
	}
     
	userService.updateProfile=function(user){//updated user profile
		return $http.put("http://localhost:8067/SHAREUPmiddleware/update",user)
	}
	
	return userService;
})

