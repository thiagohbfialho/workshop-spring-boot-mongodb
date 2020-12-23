package com.thiagofialho.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagofialho.workshopmongo.domain.Post;
import com.thiagofialho.workshopmongo.domain.User;
import com.thiagofialho.workshopmongo.dto.AuthorDTO;
import com.thiagofialho.workshopmongo.repository.PostRepository;
import com.thiagofialho.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria= new User(null, "Maria Brown", "maria@gmail.com");
		User alex= new User(null, "Alex Green", "alex@gmail.com");
		User bob= new User(null, "Bob Grey", "bob@gmail.com");
		  
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Take off travel", "I'll travel to São Paulo!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good morning", "I wake up happy today!",new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}

}
