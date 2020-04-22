FROM java:8
ADD couchbase-test-jar-with-dependencies.jar /app/couchbase-test-jar-with-dependencies.jar
CMD java -jar /app/couchbase-test-jar-with-dependencies.jar $COUCHBASE_HOST $COUCHBASE_USERNAME $COUCHBASE_PASSWORD $COUCHBASE_BUCKET
