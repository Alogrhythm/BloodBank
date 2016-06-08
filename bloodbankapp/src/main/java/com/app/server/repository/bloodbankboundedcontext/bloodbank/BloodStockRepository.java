package com.app.server.repository.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.core.SearchInterface;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "27", comments = "Repository for BloodStock Transaction table", complexity = Complexity.MEDIUM)
public interface BloodStockRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByBloodg(String bloodg) throws Exception;

    public T findById(String bloodStockIsd) throws Exception;
}
