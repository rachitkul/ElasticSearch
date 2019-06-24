package com.personalcapital.rest.client.Elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Service
@Slf4j
public class PlanService {


    private RestHighLevelClient client;

    @Autowired
    public PlanService(RestHighLevelClient client)
    {
        this.client=client;
    }

    public SearchResponse searchByPlanName(String planName) throws Exception
    {
        SearchRequest searchRequest =  new SearchRequest("insurance");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("PLAN_NAME", planName));
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return searchResponse;
    }

    public SearchResponse searchBySponsorName(String sponsorName) throws Exception
    {
        SearchRequest searchRequest =  new SearchRequest("insurance");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("SPONSOR_DFE_NAME", sponsorName));
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return searchResponse;
    }

    public SearchResponse searchBySponsorState(String sponsorState) throws Exception
    {
        SearchRequest searchRequest =  new SearchRequest("insurance");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("SPONS_DFE_MAIL_US_STAT", sponsorState));
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return searchResponse;
    }

}
