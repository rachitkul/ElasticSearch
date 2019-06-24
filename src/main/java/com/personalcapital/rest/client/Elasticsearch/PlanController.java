package com.personalcapital.rest.client.Elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanController {

    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService)
    {
        this.planService=planService;

    }

    //search elastic search by Plan name
    @GetMapping("/personalcapital/plan/{planName}")
    public SearchResponse findByPlanName(@PathVariable String planName ) throws Exception
    {
        return planService.searchByPlanName(planName);
    }

    //search elastic search by Sponsor name
    @GetMapping("/personalcapital/sponsor/{sponsorName}")
    public SearchResponse findBySponsorName(@PathVariable String sponsorName ) throws Exception
    {
        return planService.searchBySponsorName(sponsorName);
    }

    //search elastic search by Sponsor state
    @GetMapping("/personalcapital/sponsorstate/{sponsorState}")
    public SearchResponse findBySponsorState(@PathVariable String sponsorState ) throws Exception
    {
        return planService.searchBySponsorState(sponsorState);
    }
}
