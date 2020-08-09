# feature-flag-api
Feature Flag API using Kotlin

This API responsible to return the feature flag for each application. 
The feature flag is responsible for enabling specific feature from the caller side.
This API basically a "router" to determine what feature need to be displayed/disabled from the caller perspective.
 
Tech Stack
- Spring Boot 2
- JUnit5
- Kotlin
- MySQL 8
- TestContainer (Integration Test)
- Docker
- Circle CI Integration with AWS
- CodeCov

AWS Setup is being done by Terraform script
minus the DB (still don't know how to create MySQL instance in AWS with same VPC as Elastic Beanstalk)
