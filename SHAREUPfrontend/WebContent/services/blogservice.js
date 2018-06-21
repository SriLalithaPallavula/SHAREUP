/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/addblogpost",blog)
	}
	
	return blogService;
})