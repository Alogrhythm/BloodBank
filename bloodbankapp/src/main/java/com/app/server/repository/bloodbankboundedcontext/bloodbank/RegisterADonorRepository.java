package com.app.server.repository.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.core.SearchInterface;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "38", comments = "Repository for RegisterADonor Transaction table", complexity = Complexity.MEDIUM)
public interface RegisterADonorRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByGendr(String gendr) throws Exception;

    public List<T> findByBg(String bg) throws Exception;

    public List<T> findByAddr(String addr) throws Exception;

    public T findById(String donorId) throws Exception;
}
