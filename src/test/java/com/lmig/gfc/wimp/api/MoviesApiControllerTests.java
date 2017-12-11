package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.MovieRepository;

public class MoviesApiControllerTests {

	private MoviesApiController controller;
	private MovieRepository repo;

	@Before
	public void setUp() {
		repo = mock(MovieRepository.class);
		controller = new MoviesApiController(repo);
	}

	@Test
	public void getAll_return_list_of_movies() {
		// Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		when(repo.findAll()).thenReturn(movies);

		// Act
		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(actual).isSameAs(movies);
		verify(repo).findAll();
	}
	
	@Test
	public void getOne_returns_a_movie_for_a_valid_id() {
		//Arrange
		Movie movie = new Movie();
		when(repo.findOne(12L)).thenReturn(movie);
		
		//Act
		Movie actual = controller.getOne(12L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(12L);
	}
	
	@Test
	public void getOne_returns_a_movie_for_an_invalid_id() {
		//Arrange		
		when(repo.findOne(10L)).thenReturn(null);
		
		//Act
		Movie actual = controller.getOne(10L);
		
		//Assert
		assertThat(actual).isNull();
		verify(repo).findOne(10L);
	}
	
	@Test
	public void create_saves_the_movie_and_returns_it() {
		//Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);
		
		//Act
		Movie actual = controller.create(movie);
				
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
	}
	
	@Test
	public void update_sets_id_of_movie_and_calls_save__and_returns_movie() {
		//Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);
		
		//Act
		Movie actual = controller.update(movie, 2L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
		assertThat(movie.getId()).isEqualTo(2L);
	}
	
	@Test
	public void delete_gets_the_movie_and_deletes_it_and_returns_it() {
		//Arrange
		Movie movie = new Movie();
		when(repo.findOne(10L)).thenReturn(movie);
		
		//Act
		Movie actual = controller.delete(10L);
		
		//Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(10L);
		verify(repo).delete(10L);
	}
	
	

}
