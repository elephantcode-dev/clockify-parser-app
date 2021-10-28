# Clockify to Chabre TR Parser
## Prerequisites
* Java 11

## How to use:
* put clockify api key to [config](src/main/resources/application-clockify.yaml)
* run script: `sh run.sh`

By default, application parses entries from current month. 
If you want to get entries from custom time range go to [config](src/main/resources/application-clockify.yaml) 
uncomment and alter `range.from` and/or `range.to`