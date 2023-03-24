package com.SpringbootFacebookApplication.SpringbootFacebookApplication.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.exception.ResourceNotFoundException;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao.UserDao;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public UserDto craeteuser(UserDto userdto) {
		// TODO Auto-generated method stub

		User user = this.convertuserdtotouserEntity(userdto);

		User newuser = userdao.save(user);

		UserDto userresponse = this.convertusertouserdto(newuser);

		return userresponse;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub

		List<User> users = userdao.findAll();

		List<UserDto> usersdtos = this.getAllUserEntityUserdto(users);
		return usersdtos;
	}

	@Override
	public UserDto getById(int id) {

		Optional<User> userentity = userdao.findById(id);

		if (userentity.isPresent()) {
			User user = userentity.get();
			return this.convertusertouserdto(user);
		} else {
			throw new ResourceNotFoundException("this is inform you" + id + "is not presnt");
		}

	}

	@Override
	public UserDto updateUser(UserDto userdto, int id) {
		// TODO Auto-generated method stub
		User databaseuser = userdao.findById(id).get();

		databaseuser.setName(userdto.getName());
		databaseuser.setEmail(userdto.getEmail());
		databaseuser.setAbout(userdto.getAbout());

		User usernewUser = userdao.save(databaseuser);

		return this.convertusertouserdto(usernewUser);
	}

	@Override
	public void delteUser(int id) {
		// TODO Auto-generated method stub
		
		Optional<User> userentity = userdao.findById(id);

		if (userentity.isPresent()) {
			User user = userentity.get();
			userdao.delete(user);
		} else {
			throw new ResourceNotFoundException("this is inform you" + id + "is not presnt");
		}

	}

	// convertormethod

	public User convertuserdtotouserEntity(UserDto userdto) {

		User userentity = new User();

		userentity.setId(userdto.getId());
		userentity.setName(userdto.getName());
		userentity.setEmail(userdto.getEmail());
		userentity.setAbout(userdto.getAbout());
		return userentity;
	}

	public UserDto convertusertouserdto(User userentity) {

		UserDto userdto = new UserDto();

		userdto.setId(userentity.getId());
		userdto.setName(userentity.getName());
		userdto.setEmail(userentity.getEmail());
		userdto.setAbout(userentity.getAbout());
		return userdto;
	}

	List<UserDto> getAllUserEntityUserdto(List<User> users) {

		List<UserDto> userdtos = users.stream().map((user) -> this.convertusertouserdto(user))
				.collect(Collectors.toList());
		return userdtos;
	}

	List<User> getAllUserdtoUserentity(List<UserDto> usersdto) {

		List<User> user = usersdto.stream().map((userdto) -> this.convertuserdtotouserEntity(userdto))
				.collect(Collectors.toList());
		return user;
	}

}
