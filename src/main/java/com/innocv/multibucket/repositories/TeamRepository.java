package com.innocv.multibucket.repositories;

import com.innocv.multibucket.domain.Team;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "team")
public interface TeamRepository extends CrudRepository<Team, String> {
}
