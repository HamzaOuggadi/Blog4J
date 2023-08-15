package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> getAllWriters();
    Writer getWriterById(Long writerId);
    Writer getWriterByEmail(String email);
    Writer getWriterByUsername(String username);
    void addWriter(Writer writer);
    void editWriter(Writer writer);
    void deleteWriterById(Long writerId);
}
