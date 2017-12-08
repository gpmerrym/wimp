package com.lmig.gfc.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")

public class MovieAndActorRelationshipsApiController {
	
	private ActorRepository actorRepo;
	private MovieRepository movieRepo;
	
	public MovieAndActorRelationshipsApiController(ActorRepository actorRepo, MovieRepository movieRepo) {
		this.actorRepo = actorRepo;
		this.movieRepo = movieRepo;
	}
	
	
	
	@PostMapping("")
	//@ResponseStatus(code= HttpStatus.CREATED)
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {
		Movie movie = movieRepo.findOne(movieId);
		Actor actor = actorRepo.findOne(actorId);
		
		if(!movie.getActors().contains(actor)) {
			movie.getActors().add(actor);
			movieRepo.save(movie);
		}
		return movie;
		
		
		 
		
		
	}
}
