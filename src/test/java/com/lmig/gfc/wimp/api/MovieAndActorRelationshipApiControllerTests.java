package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class MovieAndActorRelationshipApiControllerTests {
	
	private MovieAndActorRelationshipsApiController controller;
	@Mock private MovieRepository movieRepo;
	@Mock private ActorRepository actorRepo;
	
	@Before 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new MovieAndActorRelationshipsApiController(actorRepo, movieRepo);
	}
	
	@Test
	public void create_saves_movie_when_actor_is_not_in_the_movie() {
		// Arrange
		Movie movie = new Movie();
		movie.setActors(new ArrayList<Actor>());
		Actor actor = new Actor();
		when(actorRepo.findOne(12L)).thenReturn(actor);
		when(movieRepo.findOne(13L)).thenReturn(movie);
		
		// Act
		Movie actual = controller.create(13L, 12L);
		
		
		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
		assertThat(movie.getActors()).contains(actor);
		verify(movieRepo).findOne(13L);
		verify(actorRepo).findOne(12L);
		
	}
	
	@Test
	public void create_does_not_movie_when_actor_is_already_in_the_movie() {
		
		//Arrange
		Actor actor = new Actor();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(actor);
		Movie movie = new Movie();
		movie.setActors(actors);
		when(movieRepo.findOne(5L)).thenReturn(movie);
		when(actorRepo.findOne(6L)).thenReturn(actor);
		
		//Act
		Movie actual = controller.create(5L, 6L);
		
		//Assert
		verify(movieRepo).findOne(5L);
		verify(actorRepo).findOne(6L);
		assertThat(actual).isSameAs(movie);
		verify(movieRepo, never()).save(movie);
		assertThat(movie.getActors()).hasSize(1);
		
	}
	

}
