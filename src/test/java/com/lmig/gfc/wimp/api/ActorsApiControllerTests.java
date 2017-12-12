package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepository;

public class ActorsApiControllerTests {
	
	private ActorsApiController controller;
	private ActorRepository repo;
	
	@Before
	public void setUp() {
		repo = mock(ActorRepository.class);
		controller = new ActorsApiController(repo);
	}
	
	@Test
	public void getAll_returns_list_of_actors() {
		//Arrange
		Actor actor = new Actor();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actor.setId(10L);
		actors.add(actor);
		when(repo.findAll()).thenReturn(actors);
		
		//Act
		List<ActorView> actual = controller.getAll();
		
		//Assert
		assertThat(actual.get(0).getId()).isSameAs(actors.get(0).getId());
		verify(repo).findAll();
	}
	
	@Test
	public void getOne_returns_list_of_actors_for_a_valid_id() {
		//Arrange
		Actor actor = new Actor();
		when(repo.findOne(10L)).thenReturn(actor);
		
		//Act
		ActorView actual = controller.getOne(10L);
		
		//Assert
		assertThat(actual.getId()).isSameAs(actor.getId());
		verify(repo).findOne(10L);
	}
	
	@Test
	public void getOne_returns_list_of_actors_for_an_invalid_id() {
		//Arrange
		when(repo.findOne(0L)).thenReturn(null);
		
		
		//Act
		ActorView actual = controller.getOne(0L);
		
		//Assert
		assertThat(actual).isNull();
		verify(repo).findOne(0L);
		
	}
	
	@Test
	public void create_saves_the_actor_and_returns_it() {
		//Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);
		
		//Act
		Actor actual = controller.create(actor);
		
		//Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).save(actor);
		
	}
	
	
	@Test 
	public void update_sets_id_of_actor_and_calls_save_and_returns_actor() {
		//Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);
		
		//Act
		Actor actual = controller.update(actor, 37L);
		
		//Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).save(actor);
		assertThat(actor.getId()).isEqualTo(37L);
		
		
	}
	
	@Test
	public void delete_gets_the_actor_and_deletes_it_and_returns_it() {
		//Arrange
		Actor actor = new Actor();
		when(repo.findOne(54L)).thenReturn(actor);
		
		//Act
		Actor actual = controller.delete(54L);
		
		//Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).findOne(54L);
		verify(repo).delete(54L);
		
		
	}

}
