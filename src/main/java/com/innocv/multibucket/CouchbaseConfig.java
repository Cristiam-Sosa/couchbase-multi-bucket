package com.innocv.multibucket;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories(basePackages = { "com.innocv.multibucket.repositories" })
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    private static final List<String> NODE_LIST = Collections.singletonList("localhost");
    private static final String DEFAULT_BUCKET_NAME = "people";
    private static final String DEFAULT_BUCKET_PASSWORD = "";

    @Override
    protected List<String> getBootstrapHosts() {
        return NODE_LIST;
    }

    @Override
    protected String getBucketName() {
        return DEFAULT_BUCKET_NAME;
    }

    @Override
    protected String getBucketPassword() {
        return DEFAULT_BUCKET_PASSWORD;
    }

}
