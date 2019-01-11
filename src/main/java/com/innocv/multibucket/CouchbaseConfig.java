package com.innocv.multibucket;

import com.couchbase.client.java.Bucket;
import com.innocv.multibucket.domain.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

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

    @Bean
    public Bucket teamBucket() throws Exception {
        return couchbaseCluster().openBucket("team", "");
    }

    @Bean(name = "campusTemplate")
    public CouchbaseTemplate teamTemplate() throws Exception {
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClusterInfo(), teamBucket(), mappingCouchbaseConverter(), translationService());
        template.setDefaultConsistency(getDefaultConsistency());
        return template;
    }

    @Override
    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping baseMapping) {
        try {
            baseMapping.mapEntity(Team.class, teamTemplate());
        } catch (Exception e) {
            // custom Exception handling
        }
    }

}
