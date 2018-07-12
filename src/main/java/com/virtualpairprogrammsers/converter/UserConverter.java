package com.virtualpairprogrammsers.converter;

import com.virtualpairprogrammers.dto.UserDTO;
import com.virtualpairprogrammers.model.User;

public class UserConverter implements Converter<User, UserDTO> {

	private User user;
	private UserDTO userDTO;
	
	public UserConverter() {
		
	}

	@Override
	public User convertToEntity(UserDTO dto) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		user = new User();
		//metodi per il set da prendere dal dto come get
		return user;
	}

	@Override
	public UserDTO convertToDTO(User entity) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		userDTO = new UserDTO();
		//metodi per il set da prendere dal dto come get
		return userDTO;
	}

}
