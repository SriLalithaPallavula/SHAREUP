/**
 * BlogInDetailCtrl
 * #/getblog/:id
 * eg , #/getblog/1
 */
app.controller('BlogInDetailCtrl',function($scope,$location,BlogService,$rootScope,$routeParams){
	var id=$routeParams.id// id of the blogpost which has to be viewed by the user
	
	BlogService.getBlogPost(id).then(function(response){
		//response.data -> blogpost object [select * from blogpost where id=?]
		$scope.blogPost=response.data
	},function(response){
		$scope.error=response.data
		if(response.status==401)
			$location.path('/login')
	
	})
	$scope.approved=function(blogPost){
		blogPost.approved=true
		BlogService.updateApprovalStatus(blogPost)
	}
	$scope.reject=function(blogPost){
		BlogService.updateApprovalStatus(blogPost)
	}
	
})

