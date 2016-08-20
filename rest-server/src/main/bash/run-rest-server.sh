#!/bin/bash

[[ $JAVA_OPTS != *-Dlog4j.configuration* ]] && export JAVA_OPTS="$JAVA_OPTS -Dlog4j.configuration=file:$(dirname $0)/../resources/log4j.xml"

# Check if server is set. If not - set server optimization
[[ $JAVA_OPTS != *-server* ]] && export JAVA_OPTS="$JAVA_OPTS -server"

exec $(dirname $0)/run-class.sh com.example.App "$@"
