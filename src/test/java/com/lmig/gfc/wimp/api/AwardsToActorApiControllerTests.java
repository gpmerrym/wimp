package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;

public class AwardsToActorApiControllerTests {
	
	private AwardsToActorApiController controller;
	@Mock private AwardRepository awardRepo;
	@Mock private ActorRepository actorRepo;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new AwardsToActorApiController(awardRepo, actorRepo); 
	}
	
	@Test
	public void create_sets_actor_to_award_and_saves_award() {
		//Arrange
		Actor actor = new Actor();
		actor.setId(17L);
		Award award = new Award();
		when(actorRepo.findOne(17L)).thenReturn(actor);
				
		//Act
		ActorView actual = controller.create(17L, award);
		
		//Assert
		verify(actorRepo).findOne(17L);
		verify(awardRepo).save(award);
		assertThat(award.getActor()).isSameAs(actor);
				
	}
		

}
