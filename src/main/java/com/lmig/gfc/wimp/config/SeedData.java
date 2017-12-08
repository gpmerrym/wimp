package com.lmig.gfc.wimp.config;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo, AwardRepository awardRepo) {
		
		actorRepo.save(new Actor("Cory", "Joseph", (long) 3.0, new Date(1985,12,3)));
		actorRepo.save(new Actor("Myles", "Turner", (long) 4.0, new Date(1990,10,13)));
		actorRepo.save(new Actor("Adam", "Sandler", (long) 5.5, new Date(1981, 12, 5)));
		actorRepo.save(new Actor("Paul", "George", (long) 7.0, new Date(1978,9,2)));
		actorRepo.save(new Actor("Kevin", "Durant", (long) 5.1, new Date(1972,8,20)));
		actorRepo.save(new Actor("Lebron", "James", (long) 6.2, new Date(1975,4,12)));
		actorRepo.save(new Actor("Michael", "Jordan", (long) 5.0, new Date(1965,5,15)));
		actorRepo.save(new Actor("Russell", "Westbrook", (long) 7.3, new Date(1981,4,15)));
		
		movieRepo.save(new Movie("The Hulk", new Date(2003, 10, 23), (long) 332222, "Marvel"));
		movieRepo.save(new Movie("Space Jam", new Date(2001, 9, 12), (long) 555222, "Pixar"));
		movieRepo.save(new Movie("Dumb And Dumber", new Date(1999, 8, 7), (long) 7766222, "Cinema"));
		movieRepo.save(new Movie("Christmas Vacation", new Date(1997, 7, 17), (long) 8832222, "Lampoon"));
		movieRepo.save(new Movie("The Grinch", new Date(2001, 11, 23), (long) 444374, "Disney"));
		
		awardRepo.save(new Award("Supporting Actor Award", "Home Depot", 2006));
		awardRepo.save(new Award("Best Actor", "Lowes", 2004));
		awardRepo.save(new Award("Best Villain", "Home Depot", 2004));
		
//		ArrayList<Actor> actors = new ArrayList<Actor>();
//		Actor actor = new Actor();
//		Movie movie = new Movie();
//		actors.add(actor);
//		movie.setActors(actors);
//		movieRepo.save(movie);
		
		
	}
	
	

}
