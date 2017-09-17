package com.synerzip.restwithspring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synerzip.restwithspring.exception.UserNotFound;
import com.synerzip.restwithspring.model.User;
import com.synerzip.restwithspring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = UserNotFound.class)
	public User delete(int id) throws UserNotFound {
		User deletedUser = userRepository.findOne(id);
		if (deletedUser == null)
			throw new UserNotFound();
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = UserNotFound.class)
	public User update(User User) throws UserNotFound {
		User updatedUser = userRepository.findOne(User.getId());
		if (updatedUser == null)
			throw new UserNotFound();
		updatedUser.setName(User.getName());
		updatedUser.setEmail(User.getEmail());
		return updatedUser;
	}
}