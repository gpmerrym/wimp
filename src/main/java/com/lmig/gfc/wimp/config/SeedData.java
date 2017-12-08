package com.lmig.gfc.wimp.config;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo) {
		
		actorRepo.save(new Actor("Bill", "Smith", (long) 5.0, new Date(1985,12,3)));
		actorRepo.save(new Actor("Danny", "Thompson", (long) 6.0, new Date(1981, 12, 5)));
		movieRepo.save(new Movie("The Hulk", new Date(2003, 10, 23), (long) 332222, "Marvel"));
		movieRepo.save(new Movie("The Grinch", new Date(2001, 11, 23), (long) 44444, "Disney"));
		
		
//		ArrayList<Actor> actors = new ArrayList<Actor>();
//		Actor actor = new Actor();
//		Movie movie = new Movie();
//		actors.add(actor);
//		movie.setActors(actors);
//		movieRepo.save(movie);
		
		
	}
	
	

}
