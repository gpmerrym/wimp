package com.lmig.gfc.wimp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepository;
import com.lmig.gfc.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardsToActorApiController {
	
	private AwardRepository awardRepo;
	private ActorRepository actorRepo;
	
	public AwardsToActorApiController(AwardRepository awardRepo, ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
	}
	
	@PostMapping("")
	@ResponseStatus(code= HttpStatus.CREATED)
	public ActorView create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = actorRepo.findOne(actorId);
		ActorView view = new ActorView(actor);
		award.setActor(actor);
		awardRepo.save(award);
		return view;
	}
	
	

}
