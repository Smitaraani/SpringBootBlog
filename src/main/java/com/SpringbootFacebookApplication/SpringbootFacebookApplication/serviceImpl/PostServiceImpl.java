package com.SpringbootFacebookApplication.SpringbootFacebookApplication.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao.CategoryDao;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao.PostDao;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao.UserDao;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Category;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Post;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.exception.ResourceNotFoundException;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.PostDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.PostsErvice;

@Service
public class PostServiceImpl implements PostsErvice {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PostDao postDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public PostDto createPost(PostDto postdto) {

		Post post = this.modelMapper.map(postdto, Post.class);

		post.setImageName("smia.jpg");
		post.setLocalDateTime(LocalDateTime.now());

		Post newpostPost = postDao.save(post);
		PostDto postDto2 = this.modelMapper.map(newpostPost, PostDto.class);

		return postDto2;
	}

	@Override
	public List<PostDto> getAllpost() {

		List<Post> posts = postDao.findAll();

		return this.postAllEntityToPostDto(posts);

	}

	@Override
	public PostDto findbyPostid(int postid) {
		Post post = postDao.findById(postid)
				.orElseThrow(() -> new ResourceNotFoundException("the is " + postid + "not present"));

		return this.postEntityToPostDto(post);
	}

	@Override
	public PostDto updatepost(PostDto postDto, int postid) {

		Post post = postDao.findById(postid)
				.orElseThrow(() -> new ResourceNotFoundException("the is " + postid + "not present"));

		post.setPostTitle(postDto.getPostTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());

		Post post2 = postDao.save(post);

		return this.postEntityToPostDto(post2);
	}

	@Override
	public void postdelte(int postid) {
		// TODO Auto-generated method stub

		Post post = postDao.findById(postid)
				.orElseThrow(() -> new ResourceNotFoundException("the is " + postid + "not present"));

		postDao.delete(post);

	}

	public PostDto postEntityToPostDto(Post post) {
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	}

	public Post postEntityToPostDto(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
		return post;
	}

	private List<PostDto> postAllEntityToPostDto(List<Post> posts) {

		return posts.stream().map((post) -> postEntityToPostDto(post)).collect(Collectors.toList());
	}

	@Override
	public List<Post> getuserid(int userid) {
		// TODO Auto-generated method stub

		User user = userDao.findById(userid).orElseThrow(() -> new ResourceNotFoundException("id id" + userid + "not"));

		List<Post> posts = postDao.findByUser(user);

		return posts;
	}

	@Override
	public List<Post> getCatid(int catid) {
		// TODO Auto-generated method stub
		

	Category category= categoryDao.findById(catid).orElseThrow(() -> new ResourceNotFoundException("id id" + catid + "not"));

		List<Post> posts = postDao.findByCategory(category);

		return posts;
		
	}

	@Override
	public PostDto createpost(PostDto postDto, Integer userId, Integer categoryId) {
	
		
		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("the is =" + userId + "not presnt"));

		Category categor = categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("the category id" + categoryId + "id not presnt"));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("yuvi.jpg");
		post.setLocalDateTime(LocalDateTime.now());
		// post.setTitle(postDto.getTitle());
		// post.setContent(postDto.getContent());
		post.setUser(user);
		post.setCategory(categor);

		Post post2 = postDao.save(post);
		return this.modelMapper.map(post2, PostDto.class);
	}
}
