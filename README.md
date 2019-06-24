# ElasticSearch Microservice
SpringBoot Microservice to expose AWS ElasticSearch funtionality

Home Assignment had 3 parts;

1) creating Aws elastic search domain 
 - Created domain called insurance.
 - it is m4.xlarge.elasticsearch instance type

2) Ingesting data provided
 - splitting of csv files into smaller files.(As m4.xlarge.elasticsearch has 100MB as limit of one payload)
 - converting each csv to indexed json format.
 example:
 { "index" : { "_index": "movies", "_type" : "_doc", "_id" : "2" } }
 {"director": "Frankenheimer, John", "genre": ["Drama", "Mystery", "Thriller"], "year": 1962}
 - ingested using curl:
 example:
 curl -XPOST <domain_endpoint>/_bulk --data-binary @<smaller json files> -H 'Content-Type: application/x-ndjson'
 
 
 3) exposing search functionality using java SpringBoot Microservice
 - a dedicated microservice with a Client to make requests to AWS elastic search
 
 Test:
 - Run microservice on local machine/ AWS EC2 instance
 - Request to microservice:
	1. to search by plan name:
		http://ip-address:8080/personalcapital/plan/Plan-name
 
	2. to search  by Sponsor Name:
		http://ip-address:8080/personalcapital/sponsor/Sponsor-name
		
	3. to search by Sponsor State:
		http://ip-address:8080/personalcapital/sponsorstate/Sponsor-state