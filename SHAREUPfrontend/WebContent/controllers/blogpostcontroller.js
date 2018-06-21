/**
 * BlogCtrl
 */
app.controller('BlogCtrl',function($scope,BlogService,$location){
	
	$scope.addBlog=function(blog){
		BlogService.addBlog(blog).then(function(response){
			alert('Blogpost has been inserted successfully..It is waiting for approval')
			$location.path('/home')
			},function(response){
				$rootScope.error=response.data
				if(response.status==401)//not looged in
					$location.path('/login')
			})
		
		
	}
	
	
})