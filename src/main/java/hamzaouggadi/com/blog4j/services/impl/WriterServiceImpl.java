package hamzaouggadi.com.blog4j.services.impl;

import hamzaouggadi.com.blog4j.entities.Writer;
import hamzaouggadi.com.blog4j.repositories.WriterRepository;
import hamzaouggadi.com.blog4j.services.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    @Override
    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }

    @Override
    public Writer getWriterById(Long writerId) throws Exception {
        Optional<Writer> optionalWriter = writerRepository.findById(writerId);
        if (optionalWriter.isPresent()) {
            return optionalWriter.get();
        } else {
            throw new Exception("Writer Not Found !");
        }
    }

    @Override
    public Writer getWriterByEmail(String email) throws Exception {
        try {
            return writerRepository.findByEmailIgnoreCase(email);
        } catch (Exception e) {
            throw new Exception("Writer Not Found !");
        }
    }

    @Override
    public List<Writer> getWriterByUsername(String username) throws Exception {
        try {
            return writerRepository.findByUsernameContainsIgnoreCase(username);
        } catch (Exception e) {
            throw new Exception("Writer List Not Found !");
        }
    }

    @Override
    public void addWriter(Writer writer) {
        writerRepository.save(writer);
    }

    @Override
    public void editWriter(Writer writer) {
        addWriter(writer);
    }

    @Override
    public void deleteWriterById(Long writerId) {
        writerRepository.deleteById(writerId);
    }
}
