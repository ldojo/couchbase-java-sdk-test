package com.citi.couchbase;

import com.couchbase.client.java.*;
import com.couchbase.client.java.kv.*;
import com.couchbase.client.java.json.*;
import com.couchbase.client.java.query.*;

public class TestCouchbase {

	public static void main(String[] args) {

		if(args.length == 0) {
			System.out.println("Ex: java -jar target/couchbase-test.jar <host> <username> <password> <bucket-name>");
			System.exit(1);
		}
		
		Cluster cluster = Cluster.connect(args[0], args[1], args[2]);
		Bucket bucket = cluster.bucket(args[3]);
		Collection collection = bucket.defaultCollection();

		MutationResult upsertResult = collection.upsert("my-document", JsonObject.create().put("name", "mike"));
		GetResult getResult = collection.get("my-document");
		System.out.println(getResult);

		QueryResult result = cluster.query("select \"Hello World\" as greeting");
		System.out.println(result.rowsAsObject());
		System.out.println("couchbase test was successful!");
	}

}
