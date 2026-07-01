# Opensearch  
  
curl -X POST "http://localhost:9200/test-index/_doc/" -H 'Content-Type: application/json' -d'  
{  
  "user": "john_doe",  
  "message": "This is a test message",  
  "timestamp": "2026-01-12T14:00:00"  
}  
'  
  
curl -X GET "http://localhost:9200/_cat/shards/test-index?v"  
(Unassigned shards)  
  
curl "http://localhost:9200/test-index/_search?pretty"  
