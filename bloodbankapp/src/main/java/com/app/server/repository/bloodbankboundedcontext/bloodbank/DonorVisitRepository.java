package com.app.server.repository.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.core.SearchInterface;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "39", comments = "Repository for DonorVisit Transaction table", complexity = Complexity.MEDIUM)
public interface DonorVisitRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByDType(String dType) throws Exception;

    public List<T> findByDonor(String donor) throws Exception;

    public List<T> findByCamp(String camp) throws Exception;

    public T findById(String donorVisitId) throws Exception;
}
