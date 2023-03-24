package com.SpringbootFacebookApplication.SpringbootFacebookApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Post;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.PostDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.PostsErvice;

@RestController
public class PostController {

	@Autowired
	PostsErvice postsErvice;
	
	
	@PostMapping("/post/{userId}/{categoryId}")

	public ResponseEntity<PostDto> CaretePost( @RequestBody PostDto postDto,
			@PathVariable(value = "userId") Integer userId, @PathVariable(value = "categoryId") Integer categoryId) {
		PostDto post = postsErvice.createpost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
	}

	@PostMapping("/post")
	public ResponseEntity<PostDto> caretepost(@RequestBody PostDto postDto) {

		PostDto postDto2 = postsErvice.createPost(postDto);

		return new ResponseEntity<PostDto>(postDto2, HttpStatus.CREATED);
	}

	@GetMapping("/post/cat/{id}")
	public List<Post> getAllpOstbycat(@PathVariable int id) {

		List<Post> list = postsErvice.getCatid(id);

		return list;
	}
	
	
	
	
	@GetMapping("/post/{catid}")
	public List<Post> getAllpOstbyuser(@PathVariable int id) {

		List<Post> list = postsErvice.getuserid(id);

		return list;
	}

	@GetMapping("/post/post")
	public ResponseEntity<List<PostDto>> getAllPostDtos() {
		List<PostDto> postDtos = this.postsErvice.getAllpost();

		return new ResponseEntity<>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/post/post/{postId}")
	public ResponseEntity<PostDto> getPostByID(@PathVariable(value = "postId") Integer postId) {
		PostDto postDto = this.postsErvice.findbyPostid(postId);

		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	@PutMapping("/post/post/{postId}")
	public ResponseEntity<PostDto> updateThepost(@RequestBody PostDto postDto,
			@PathVariable(value = "postId") Integer postId) {

		PostDto postDto2 = this.postsErvice.updatepost(postDto, postId);

		return new ResponseEntity<PostDto>(postDto2, HttpStatus.CREATED);

	}

//	@DeleteMapping("/post/post/{postId}")
//	public ResponseEntity<ApiResponse> deleteByPostId(@PathVariable(value ="postId") Integer postId) {
//
//		this.postService.deleteById(postId);)
//
//		return new ResponseEntity<>(new ApiResponse("message delte", true),HttpStatus.OK);
//
//	}

}
