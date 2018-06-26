package com.niit.dao;

import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;

public interface BlogPostLikesDao {
BlogPostLikes hasUserLikedBlogPost(int blogpostId, String email);
//Null will be returned / 1 blogpostlikes object will be returned
// Null-gyphicon in blackcolor
//1 object-glyphicon in bluecolor

BlogPost updateBlogPostLikes(int blogPostId, String email);
}
