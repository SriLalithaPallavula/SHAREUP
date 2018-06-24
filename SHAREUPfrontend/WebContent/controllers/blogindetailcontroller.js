/**
 * BlogInDetailCtrl
 * #/getblog/:id
 * eg , #/getblog/1
 */
app.controller('BlogInDetailCtrl',function($scope,$location,BlogService,$rootScope,$routeParams,$sce){
	var id=$routeParams.id// id of the blogpost which has to be viewed by the user
	
	BlogService.getBlogPost(id).then(function(response){
		//response.data -> blogpost object [select * from blogpost where id=?]
		$scope.blogPost=response.data
		$scope.content=$sce.trustAsHtml($scope.blogPost.blogContent)
	},function(response){
		$scope.error=response.data
		if(response.status==401)
			$location.path('/login')
	
	})
	//Approve button is clicked
	$scope.approve=function(blogPost){
		blogPost.approved=true
		BlogService.updateApprovalStatus(blogPost).then(function(response){
			$location.path('/blogswaitingforapproval')
		},function(response){
			$scope.error=response.data
			if(response.status==401)
				$location.path('/login')
		})
	}
	//Reject button is clicked
	$scope.reject=function(blogPost){
		blogPost.approved=false
		BlogService.updateApprovalStatus(blogPost).then(function(response){
			$location.path('/blogswaitingforapproval')
		},function(response){
			$scope.error=response.data
			if(response.status==401)
				$location.path('/login')
		})
	
	}
	
})

