package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> getAllWriters();
    Writer getWriterById(Long writerId) throws Exception;
    Writer getWriterByEmail(String email) throws Exception;
    List<Writer> getWriterByUsername(String username) throws Exception;
    void addWriter(Writer writer);
    void editWriter(Writer writer);
    void deleteWriterById(Long writerId);
}
