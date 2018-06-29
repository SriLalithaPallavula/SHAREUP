/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/addblogpost",blog)
	}
	blogService.blogsApproved=function(){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/blogsapproved")
	}
	blogService.blogsWaitingForApproval=function(){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/blogswaitingforapproval")
	}
	blogService.getBlogPost=function(id){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/getblogpost/"+id)
		
	}
	blogService.updateApprovalStatus=function(blogPost){
		//if admin approves the blogPost, blogPost.approved=?
		//if admin rejects the blogPost, blogPost.reject=?
		return $http.put("http://localhost:8067/SHAREUPmiddleware/updateapprovalstatus",blogPost)
	}
	blogService.hasUserLikedBlog=function(blogpostId){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/hasuserlikedblog/"+blogpostId)
	}
	blogService.updateBlogPostLikes=function(blogPostId){
		return $http.put("http://localhost:8067/SHAREUPmiddleware/updateblogpostlikes/"+blogPostId)
	}
	blogService.addComment=function(commentTxt,id){
		return $http.post("http://localhost:8067/SHAREUPmiddleware/addcomment/"+commentTxt+"/"+id)
	}
	blogService.getAllBlogComments=function(blogPostId){
		return $http.get("http://localhost:8067/SHAREUPmiddleware/getblogcomments/"+blogPostId)
	}
	return blogService;
})